CREATE USER IF NOT EXISTS siomassy2022_user@localhost IDENTIFIED BY 'siomassy2022_pwd';
GRANT ALL ON siomassy2022.* TO siomassy2022_user@localhost WITH GRANT OPTION;
GRANT EXECUTE ON siomassy2022.* TO siomassy2022_user@localhost;
-- si l'instruction précédente échoue, lancer :
-- GRANT SELECT ON mysql.proc TO siomassy2022_user@localhost;
