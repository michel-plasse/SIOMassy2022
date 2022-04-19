DROP VIEW IF EXISTS v_efg_groupes_membres;
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



CREATE VIEW stat_sur_reponses AS
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