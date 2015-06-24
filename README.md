#Geocoding der Adressdaten

##Ziel

Ziel dieses Projektes ist es die Geokoordinaten einer Adresse zu bestimmen. Die Bestimmung selber wird über eine Nominatim Service vorgenommen. Hier wird eine Antwort im JSON-Format erwartet. Der Service selber ist in der Lage die wichten Informationen JSON formatiert zu beantworten. Der Aufruf wird durch die URL gemacht.

##Gedanken zum GeoCoding-Service

Ich habe mich für einen Nominatim-Service entschieden, weil hier weder Abhängigkeiten zu kommerziellen Produkten existieren, noch urheberechtliche Bedenken zu berücksichtigen sind. Nachteil dieser Lösung ist das eingeschränkte Vertrauen in diese Lösung. In meinen vorausgehenden Diskussionen habe ich gesehen, dass OSM zwar von jedem, im Zweifel auch parallel zu kommerziellen Lösungen, eingesetzt wird, das Vertrauen in die Ergebnisse allerdings eingeschränkt ist. 

##Eigener Nominatim-Server

Das OSM-Projekt sieht den öffentlich betriebenen Nominatim-Server als Ergänzung zur eigenen OSM-Installation und verbittet sich mehr Abfragen als 1/sec und Bulk-Anfragen. D.h. Es ist durchaus möglich mal eine Anfrage durchzuführen, aber gleich 10000, wie hier geplant sind, entspricht nicht der [Usage Policy](http://wiki.openstreetmap.org/wiki/Nominatim_usage_policy).

Neben Nominatim betreibt [MapQuest](http://developer.mapquest.com/de/web/products/open/nominatim) eine Nomintim GeoCoding Instanz, die in beliebigem Umfang eingesetzt werden kann. Hier wird allerdings darauf hingewiesen, dass die Verwendung auf der Webseite genannt werden muss. Da ich diesen Service allerdings im Hintergrund einsetze, ist mir dies nicht möglich.   

Das Aufsetzen eines eigenen Nominatim-Servers ist mit der Anleitung gut durchführbar. Empfohlene Voraussetzungen ist die Verwendung im Rahmen einer VirtualBox (1 Prozessor, 2 GB RAM, 12 GB HDD). 

##Space-characters

[TBD] Die Ansprache des eigenen Nominatim wird durch die Vewendung des space-characters eingeschränkt. 

