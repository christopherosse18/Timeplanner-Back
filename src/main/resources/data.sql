INSERT INTO timeplanner.utilisateur (id_utilisateur, nom, prenom, username, email) VALUES (gen_random_uuid (), 'Rossé', 'Christophe', 'crosse', 'cr@proconcept.ch');
INSERT INTO timeplanner.utilisateur (id_utilisateur, nom, prenom, username, email) VALUES (gen_random_uuid (), 'Rossé', 'Alexandra', 'arosse', 'ar@proconcept.ch');
INSERT INTO timeplanner.utilisateur (id_utilisateur, nom, prenom, username, email) VALUES (gen_random_uuid (), 'Maillard', 'Cyril', 'cmaillard', 'cyril@proconcept.ch');
INSERT INTO timeplanner.utilisateur (id_utilisateur, nom, prenom, username, email) VALUES (gen_random_uuid (), 'Wüthrich', 'Cyril', 'awuth', 'cw@proconcept.ch');

--Table temps
/*INSERT INTO timeplanner.temps (id_temps, id_utilisateur) VALUES (gen_random_uuid (), 1);
INSERT INTO timeplanner.temps (id_temps, id_utilisateur) VALUES (gen_random_uuid (), 2);
INSERT INTO timeplanner.temps (id_temps, id_utilisateur) VALUES (gen_random_uuid (), 3);
INSERT INTO timeplanner.temps (id_temps, id_utilisateur) VALUES (gen_random_uuid (), 4);
*/
--Table departement
/*INSERT INTO timeplanner.departement(id_service, heures,nom, taux_activite, id_utilisateur)
values(1, 20, 'Customer Services', 0.5, 1);
INSERT INTO timeplanner.departement(id_service, heures,nom, taux_activite, id_utilisateur)
values(2, 28, 'Customer Services', 0.7, 2);
INSERT INTO timeplanner.departement(id_service, heures,nom, taux_activite, id_utilisateur)
values(3, 40, 'Customer Services', 1, 3);
INSERT INTO timeplanner.departement(id_service, heures, nom, taux_activite, id_utilisateur)
values(4, 40, 'Consulting', 1, 4);*/
/*insert into timeplanner.departement(id_utilisateur)

INSERT INTO timeplanner.departement(id_departement, heures, jours_actifs, nom, taux_activite, id_utilisateur)
values(gen_random_uuid (), 20, array['mercredi', 'jeudi', 'vendredi'], 'Customer Services', 0.5, 1);
INSERT INTO timeplanner.departement(id_departement, heures, jours_actifs, nom, taux_activite, id_utilisateur)
values(gen_random_uuid (), 28, array['mardi','mercredi', 'jeudi', 'vendredi'], 'Customer Services', 0.7, 2);
INSERT INTO timeplanner.departement(id_departement, heures, jours_actifs, nom, taux_activite, id_utilisateur)
values(gen_random_uuid (), 40, array['lundi','mardi','mercredi', 'jeudi', 'vendredi'], 'Customer Services', 1, 3);
INSERT INTO timeplanner.departement(id_departement, heures, jours_actifs, nom, taux_activite, id_utilisateur)
values(gen_random_uuid (), 40, array['lundi','mardi','mercredi', 'jeudi', 'vendredi'], 'Consulting', 1, 4);
*/
--Ajout du departement dans les users
/*update timeplanner.utilisateur set id_temps = 1 where id_utilisateur= 1;
update timeplanner.utilisateur set id_temps = 2 where id_utilisateur= 2;
update timeplanner.utilisateur set id_temps = 3 where id_utilisateur= 3;
update timeplanner.utilisateur set id_temps = 4 where id_utilisateur= 4;

--Table semaine
INSERT INTO timeplanner.semainetravail (id_semainetravail, heures_dues, heures_realisees, num_semaine, id_temps) VALUES (1, 40, 10, 12, 1);
*/
--Table jour
--INSERT INTO timeplanner.jourtravail (id_jourtravail, annee, duree, duree_saisie, jours, temps_realise, type_saisie, id_semainetravail) VALUES (1, 2023, 8, 8, 'lundi', 8, 'travail', 1);
