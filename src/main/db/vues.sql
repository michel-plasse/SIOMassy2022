DROP VIEW IF EXISTS v_efg_groupes_membres;/*Karim*/
CREATE VIEW v_efg_groupes_membres AS
SELECT
    efg.id_efg, efg.intitule, efg.id_canal, efg.cree_a,
    c.id_personne AS id_createur,
    c.prenom AS prenom_createur,
    c.nom AS nom_createur,
    p.id_personne, p.prenom, p.nom,
    ge.id_groupe
FROM
    efg
        INNER JOIN
    personne c ON efg.id_createur = c.id_personne
        INNER JOIN
    groupe_efg ge ON efg.id_efg = ge.id_efg
        INNER JOIN
    membre_groupe_efg mge ON mge.id_efg = ge.id_efg AND mge.id_groupe = ge.id_groupe
        INNER JOIN 
    personne p ON mge.id_personne = p.id_personne
ORDER BY efg.id_efg, ge.id_groupe, p.nom;


DROP VIEW IF EXISTS v_membre_canal;
CREATE VIEW v_membre_canal AS
SELECT
	p.id_personne, p.prenom, p.nom, p.email, p.url_photo,
  mc.ajoute_a 
FROM
	personne p
		INNER JOIN
	membre_canal mc ON p.id_personne = mc.id_personne;


/* Données du sondage (tableau question) + nom/prénom de son créateur
  + réponses des membres du canal associé au sondage,
  y compris quand ils n'ont pas encore répondu (elles valent alors NULL).
  Nous distinguons le libellé écrit par le membre qui répond (libelle_donne)
  des options proposées par l'auteur du sondage (libelle_propose), et en
  faisons la synthèse dans libell_reponse.
*/
DROP VIEW IF EXISTS v_reponse_sondage;
CREATE VIEW v_reponse_sondage AS
SELECT 
	q.id_question, q.id_canal, q.libelle AS libelle_question, q.id_type_question,
	q.id_createur, c.prenom AS prenom_createur, c.nom AS nom_createur,
  p.id_personne, p.prenom, p.nom,
  IFNULL(rq.libelle, oq.libelle) AS libelle_reponse,
  rq.id_option_question, 
  rq.libelle AS libelle_donne,
  oq.libelle AS libelle_propose
FROM 
	personne p
		INNER JOIN
  membre_canal mc ON p.id_personne = mc.id_personne
		INNER JOIN
	question q ON mc.id_canal = q.id_canal
		INNER JOIN
	personne c ON q.id_createur = c.id_personne
		LEFT OUTER JOIN
	reponse_question rq ON q.id_question = rq.id_question AND p.id_personne = rq.id_personne
		LEFT OUTER JOIN
	option_question oq ON rq.id_question = oq.id_question 
		AND rq.id_option_question = oq.id_option_question
ORDER BY q.id_question, p.nom, p.prenom;



DROP VIEW IF EXISTS v_stat_sur_reponses;
CREATE VIEW v_stat_sur_reponses AS
SELECT t1.*, nb_etudiants, nb_reponses_total, nb_etudiants-nb_reponses_total As nb_non_reponse
FROM
(
    SELECT q.id_canal, q.id_question, q.libelle, rq.libelle AS reponse,
        COUNT(rq.id_question) AS nb_reponses
    FROM 
        question q
            LEFT OUTER JOIN 
        reponse_question rq ON q.id_question= rq.id_question
    GROUP BY q.id_canal, q.id_question, q.libelle, reponse
) t1
    INNER JOIN
(
    SELECT mc.id_canal, COUNT(DISTINCT p.id_personne) AS nb_etudiants
    FROM
        membre_canal mc
            INNER JOIN
        personne p ON mc.id_personne = p.id_personne
    WHERE p.est_formateur=0 AND p.est_administrateur=0
  GROUP BY mc.id_canal
) t2 ON t1.id_canal = t2.id_canal
    LEFT OUTER JOIN
(
    SELECT q.id_canal, rq.id_question, COUNT(DISTINCT rq.id_personne) AS nb_reponses_total
  FROM 
        reponse_question rq
            INNER JOIN
        question q
  GROUP BY q.id_canal, rq.id_question
) t3 ON t1.id_question = t3.id_question AND t2.id_canal = t3.id_canal;



/* Pour saisir ou afficher les notes des étudiants dans une évaluation
(Abdallah) */
CREATE VIEW v_note_etudiant AS
SELECT p.id_personne, p.prenom, p.nom, e.id_evaluation, ne.note
FROM 
	personne p
		INNER JOIN
	membre_canal mc ON p.id_personne = mc.id_personne
		INNER JOIN
	evaluation e ON mc.id_canal = e.id_canal
		LEFT OUTER JOIN
	note_evaluation ne ON e.id_evaluation = ne.id_evaluation AND p.id_personne = ne.id_etudiant
ORDER BY e.id_evaluation, p.nom, p.prenom;
