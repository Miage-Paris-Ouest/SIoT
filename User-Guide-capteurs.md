USER GUIDE
1.      Mise en place boitier, installations outils (putty, edison, Arduino…)
Connexion filezilla : se connecter avec son tel pour filezilla et le boitier pr faire la liaison.
2.       Configurer un wifi sur la carte
Faire un partage de connexion avec son téléphone pour que le boitier (et FileZilla) s’y connecte.
Une fois le boitier branché, on entre en ligne de commande sous Putty et on entre ses identifiants (id : root, pwd : que l’on a mis à la partie 1)
On lance la configuration wifi :
Ifconfig wlan0 up
Puis on entre la commande :

- configure_edison --wifi 

<img src="https://github.com/Miage-Paris-Ouest/SIoT/blob/master/img/abonnements.PNG"/>

Un scan va être lancé, puis une liste des wifi disponibles sera proposée.
On choisit celui qui nous intéresse.

On peut faire un reboot pour recharger le programme.
Pour visualiser ce qu’il y’a dans le fichier des connexions : on va dans etc/wpa_supplicant/
Et on visualise avec vi wpa_sufficant
 
3.       Installation CLI & PIP pour ajouter AWS dans Intel Edison
4.       Ajouter certificats et PrivaiteKey, PublicKey dans IntelEdison (CAroot.crt, attention format .crt du certificat à mettre en .pem)
5.       Communication entre AWS & Int(Edison-JS-Sample.js)
 
 3.Suivre ce tuto
https://software.intel.com/en-us/articles/connecting-to-amazon-web-services-aws-iot-using-mqtt
 
Attention quand on install aws amazon en ligne de commande on peut rencontrer une erreur :


Il faut faire aws configure et entrer le key ID  que l’on trouvera ici :
Sur aws amazon > IAM > User > Informations identifications > creer nouvelle clé
Entrez les différentes clés :


On relance la commande pour créer le device et on obtient ça si c’est bon :


New certification : entrez la commande :
aws iot create-keys-and-certificate --set-as-active --certificate-pem-outfile cert.pem --public-key-outfile publicKey.pem --private-key-outfile privateKey.pem
 
Une fois qu’on a récupéré les certif (cf tuto), on les transfere sur filezilla dans le dossier home/root/ de notre boitier.

 
 
Aller sur https://github.com/intel-iot-devkit/aws-iot-intel
 
Pour lier l’objet au policy au certificat, on tape en ligne de commande cmd en remplaçant par les bonnes valeurs:

 curl https://www.symantec.com/content/en/us/enterprise/verisign/roots/VeriSign-Class%203-Public-Primary-Certification-Authority-G5.pem > ~/certifs/rootCA.pem
 
 

SUR PUTTY pour SDK : https://github.com/aws/aws-iot-device-sdk-js


 
 
http://stackoverflow.com/questions/35991403/python-pip-install-gives-command-python-setup-py-egg-info-failed-with-error-c
 
POUR ERREUR EGG INFO apres pip install awscli
 
aws iot attach-thing-principal                   \
     --thing-name Prof_Edison                          \
     --principal arn:aws:iot:us-west-2:481237007159:cert/ae278cb8bff81011d540c8f0e822319fd7bc79dc42cf2b19140c8c0ca4f47ddf


6.    Ajouter capteurs via JonnhyFive & IntelIOT
 
https://github.com/rwaldron/johnny-five
sur putty :
git clone git://github.com/rwaldron/johnny-five.git && cd johnny-five
 
npm install
 
npm install johnny-five
 
Pour lancer l’execution d’un capteur depuis johnny five
 
-  npm install edison-io johnny-five
 
depuis root@SioTeam:~/johnny-five/eg#
- node grove-humidity-temperature-edison.js
une fois lancé on obtient ça: 
(pour fermer faire 2 fois ctrl c)

7. Modification des codes capteurs dans Edison-JS-Sample.js

puis relancer:

On reçoit bien les mises à jours des capteurs sur aws. > registre> objet > “MONBOITIER” > activité ou shadow pour voir l

8. Envoi de notifs SNS depuis les capteurs

Allez dans AWS > SNS
