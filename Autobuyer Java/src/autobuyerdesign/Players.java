/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Yannick
 */
public class Players {

    static Players instance;

    public static Players getInstance() {
        if (instance == null) {
            instance = new Players();
        }
        return instance;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    String[] bayernMuenchen = {"Manuel Neuer", "Robert Lewandowski", "Mats Hummels", "Thiago", "Arjen Robben", "Jérôme Boateng", "Arturo Vidal", "Thomas Müller", "David Alaba", "James Rodríguez", "Franck Ribéry", "Javi Martinez", "Niklas Süle", "Joshua Kimmich", "Kingsley Coman", "Corentin Tolisso", "Juan Bernat Velasco", "Sandro Wagner", "Márcio Rafael Ferreira de Souza", "Sven Ulreich", "Christian Früchtl", "Felix Götze", "Marco Friedl", "Niklas Dorsch", "Fabian Benko", "Woo Yeong Jeong"};
    String[] borussiaDortmund = {"Marco Reus", "Michy Batshuayi", "Pierre-Emerick Aubameyang", "Roman Bürki", "Sokratis", "Andriy Yarmolenko", "Łukasz Piszczek", "André Schürrle", "Shinji Kagawa", "Ömer Toprak", "Gonzalo Castro", "Bartra", "Guerreiro", "Julian Weigl", "Mario Götze", "Maximilian Philipp", "MArcel Schmelzer", "Christian Pulisic", "Nuri Şahin", "Mahmoud Dahoud", "Sebastian Rode", "Roman Weidenfeller", "Neven Subotić", "Erik Durm", "Jeremy Toljan", "Joo Ho Park", "Manuel Akanji", "Dan-Axel Zagadou", "Alexander Isak", "Jacob Bruun Larsen", "Dominik Reimann", "Jan Niklas Beste", "David Sauerland", "Patrick Fritsch"};
    String[] gladbach = {"Thorgan Hazard", "Raffael", "Matthias Ginter", "Yann Sommer", "Lars Stindl", "Jannik Vestergaard", "Vincenzo Grifo", "Ibrahima Traoré", "Christoph Kramer", "Fabian Johnson", "Patrick Herrmann", "Raúl Bobadilla", "Oscar Wendt", "Jonas Hofmann", "Denis Zakaria", "Tony Jantschke", "Tobias Strobl", "Nico Elvedi", "Josip Drmić", "Tobias Sippel", "Mickaël Cuisance", "László Bénes", "Christofer Heimeroth", "Reece Oxford", "Mamadou", "Kwame Yeboah", "Julio Villalba", "Ba-Muaka", "Moritz Nicolas"};
    String[] freiburg = {"Nils Petersen", "Pascal Stenzel", "Yoric Ravet", "Florian Niederlechner", "Alexander Schwolow", "Gaëtan Bussmann", "Marc-Oliver Kempf", "Çağlar Söyüncü", "Mike Frantz", "Janik Haberer", "Manuel Gulde", "Rafał Gikiewicz", "Aleksandar Ignjovski", "Christian Günter", "Nicolas Höfler", "Bartosz Kapustka", "Amir Abrashi", "Marco Terrazzino", "Julian Schuster", "Ryan Kent", "Jonas Meffert", "Georg Niedermeier", "Patric Klandt", "Tim Kleindienst", "Lukas Kübler", "Lucas Höler", "Onur Bulut", "Robin Koch", "Patrick Kammerbauer", "Philipp Lienhart", "Karim Guédé", "Caleb Stanko", "Vincent Sierro"};
    String[] hamburgerSV = {"Filip Kostić", "Kyriakos Papadopoulos", "Nicolai Müller", "Lewis Holtby", "Albin Ekdal", "André Hahn", "Aaron Hunt", "Mërgim Mavraj", "Dennis Diekmeier", "Christian Mathenia", "Douglas Santos", "Bobby Wood", "Gōtoku Sakai", "Walace", "Gideon Jung", "Julian Pollersbeck", "Sven Schipplock", "Fiete Arp", "Bjarne Thoelke", "Rick van Drongelen", "Mohamed Gouaida", "Gian-Luca Waldschmidt", "Bakery Jatta", "Tom Mickel", "	Vasilije Janjičić", "Mats Köhlert", "Andreas Hirzel", "Frank Ronstadt", "Jonas Behounek", "Christian Stark"};
    String[] koeln = {"Timo Horn", "Jorge Meré", "Frederik Sørensen", "Jonas Hector", "Leonardo Bittencourt", "Vincent Koziello", "Dominique Heintz", "Marco Höger", "Simon Terodde", "Marcel Risse", "Jhon Córdoba", "Yūya Ōsako", "Miloš Jojić", "Matthias Lehmann", "Claudio Pizarro", "Christian Clemens", "Dominic Maroh", "Konstantin Rausch", "Paweł Olkowski", "Artjoms Rudnevs", "Simon Zoller", "Thomas Kessler", "Lukas Klünter", "Sehrou Guirassy", "Jannes Horn", "Salih Özcan", "Sven Müller"};
    String[] leverkusen = {"Leon Bailey", "Wendell", "Kevin Volland", "Lars Bender", "Bernd Leno", "Jonathan Tah", "Julian Brandt", "Lucas Alario", "Karim Bellarabi", "Charles Aránguiz", "Julian Baumgartlinger", "Dominik Kohr", "Tin Jedvaj", "Stefan Kießling", "Admir Mehmedi", "Ramazan Özcan", "Kai Havertz", "André Ramalho", "Joel Pohjanpalo", "Panagiotis Retsos", "Vladlen Yurchenko", "Niklas Lomb", "Marlon Frey", "Atakan Akkaynak", "Sam Schreck"};
    String[] schalke = {"Naldo", "Leon Goretzka", "Daniel Caligiuri", "Ralf Fährmann", "Breel Embolo", "Coke", "Nabil Bentaleb", "Matija Nastasić", "Max Meyer", "Yevhen Konoplyanka", "Guido Burgstaller", "Bastian Oczipka", "Amine Harit", "Alessandro Schöpf", "Abdul Rahman", "Benjamin Stambouli", "Marko Pjaca", "Franco Di Santo", "Donis Avdijaj", "Thilo Kehrer", "Michael Langer", "Weston McKennie", "Cedric Teuchert", "Alexander Nübel", "Fabian Reese", "Bernard Tekpetey", "Joshua Bitter"};
    String[] stuttgart = {"Mario Gómez", "Ron-Robert Zieler", "Christian Gentner", "Holger Badstuber", "Simon Terodde", "Emiliano Insúa", "Carlos Mané", "Benjamin Pavard", "Santiago Ascacibar", "Daniel Ginczek", "Andreas Beck", "Timo Baumgartl", "Dennis Aogo", "Ebenezer Ofori", "Ailton", "Takuma Asano", "Marcin Kamiński", "Anastasios Donis", "Josip Brekalo", "Chadrac Akolo", "Jens Grahl", "Matthias Zimmermann", "Anto Grgić", "Berkay Özcan", "Dženis Burnić", "Orel Mangala", "Jacob Bruun Larsen", "Joel Soñora"};
    String[] bremen = {"Jiří Pavlenka", "Max Kruse", "Zlatko Junuzovic", "Ishak Belfodil", "Fin Bartels", "Thomas Delaney", "Sebastian Langkamp", "Lamine Sané", "Niklas Moisander", "Theodor Gebre Selassie", "Robert Bauer", "Luca Caldirola", "Milot Rashica", "Jérôme Gondorf", "Philipp Bargfrede", "Jaroslav Drobný", "Florian Kainz", "Ludwig Augustinsson", "Miloš Veljković", "Aron Jóhannsson", "Izet Hajrović", "Maximilian Eggestein", "Justin Eilers", "Yuning Zhang", "Ulisses Garcia", "Michael Zetterer", "Marco Friedl", "Niklas Schmidt", "Ole Käuper"};
    String[] berlin = {"Rune Almenning Jarstein", "Salomon Kalou", "Vedad Ibišević", "Vladimír Darida", "Karim Rekik", "Marvin Plattenhardt", "Per Ciljan Skjelbred", "Sebastian Langkamp", "Mitchell Weiser", "Niklas Stark", "Thomas Kraft", "Fabian Lustenberger", "Peter Pekarík", "Valentin Stocker", "Genki Haraguchi", "Julian Schieber", "Ondrej Duda", "Karim Rekik", "Alexander Esswein", "Davie Selke", "Mathew Leckie", "Valentino Lazaro", "Arne Maier", "Maximilian Mittelstädt", "Jordan Torunarigha", "Sinan Kurt", "Florian Baak", "Jonathan Klinsmann", "Julius Kade", "Pál Dárdai"};
    String[] mainz = {"René Adler", "Jean-Philippe Gbamin", "Stefan Bell", "Pablo De Blasis", "Danny Latza", "Levin Öztunali", "Jairo", "Yoshinori Mutō", "Fabian Frei", "Daniel Brosinski", "Abdou Diallo", "Niko Bungert", "Leon Balogun", "Viktor Fischer", "Alexandru Maxim", "Gaëtan Bussmann", "Giulio Donati", "Jean-Philippe", "Nigel de Jong", "Robin Quaison", "Karim Onisiwo", "Alexander Hack", "Kenan Kodro", "Emil Berggreen", "Gerrit Holtmann", "Jannik Huth", "Suat Serdar", "Philipp Klement", "Robin Zentner", "Florian Müller", "Marin Šverko", "Bote Baku"};
    String[] wolfsburg = {"Mario Gómez", "Yunus Malli", "Divock Origi", "Camacho", "Daniel Didavi", "Josuha Guilavogui", "John Brooks", "Paul-Georges Ntep", "Maximilian Arnold", "Jeffrey Bruma", "Koen Casteels", "Paul Verhaegh", "Renato Steffen", "Jakub Błaszczykowski", "Felix Uduokhai", "Yannick Gerhardt", "Robin Knoche", "Sebastian Jung", "Riechedly Bazoer", "Marcel Tisserand", "Landry Dimata", "William de Asevedo Furtado", "Josip Brekalo", "Marvin Stefaniak", "Max Grün", "Felix Uduokhai", "Victor Osimhen", "Gian-Luca Itter", "Marian Sarr", "Elvis Rexhbecaj", "Justin Möbius", "Kaylen Hinds", "Davide Itter", "Phillip Menzel", "Robin Ziegele", "Dominik Franke"};
    String[] hannover = {"Salif Sané", "Niclas Füllkrug", "Jonathas", "Ihlas Bebou", "Martin Harnik", "Manuel Schmiedebach", "Julian Korb", "Matthias Ostrzolek", "Waldemar Anton", "Michael Esser", "Pirmin Schwegler", "Felix Klaus", "Edgar Prib", "Oliver Sorg", "Marvin Bakalorz", "Philipp Tschauner", "Kenan Karaman", "Uffe Bech", "Felipe", "Florian Hübner", "Miiko Albornoz", "Iver Fossum", "Noah Joel Sarenren Bazee", "Charlison Benschop", "Sebastian Maier", "Samuel Şahin-Radlinger", "Mike Steven Bähre", "Fynn Arkenberg", "Timo Hübers", "Yousef Emghames"};
    String[] frankfurt = {"Lukáš Hrádecký", "Kevin-Prince Boateng", "Ante Rebić", "Marco Fabián", "David Abraham", "Jonathan De Guzmán", "Makoto Hasebe", "Jetro Willems", "Alexander Meier", "Sébastien Haller", "Timmy Chandler", "Marc Stendera", "Omar Mascarell", "Gelson Tavares Fernandes", "Mijat Gaćinović", "Simon Falette", "Marco Russ", "Carlos Salcedo", "Marius Wolf", "Branimir Hrgota", "Slobodan Medojević", "Daichi Kamada", "Danny Blum", "Luka Jović", "Taleb Tawatha", "Andersson Ordóñez", "Jan Zimmermann", "Yanni Regäsel", "Aymen Barkok", "Max Besuschkow", "Leon Bätge", "Renat Dadashov"};
    String[] hoffenheim = {"Mark Uth", "Serge Gnabry", "Andrej Kramarić", "Oliver Baumann", "Pavel Kadeřábek", "Sandro Wagner", "Steven Zuber", "Kevin Vogt", "Kerem Demirbay", "Benjamin Hübner", "Håvard Nordtveit", "Eugen Polański", "Lukas Rupp", "Ermin Bičakčić", "Ádám Szalai", "Nico Schulz", "Florian Grillitsch", "Robert Žulj", "Kevin Akpoguma", "Justin Hoogma", "Dennis Geiger", "Felix Passlack", "Alexander Stolz", "Philipp Ochs", "Gregor Kobel", "Meris Skenderović", "Stefan Posch", "Robin Hack"};
    String[] augsburg = {"Philipp Max", "Michael Gregoritsch", "Martin Hinteregger", "Alfreð Finnbogason", "Daniel Baier", "Marwin Hitz", "Jeffrey Gouweleeuw", "Ja Cheol Koo", "Konstantinos Stafylidis", "Caiuby", "Marcel Heller", "Moritz Leitner", "Jonathan Schmid", "Gojko Kačar", "Jan Morávek", "Fabian Giefer", "Callsen-Bracker", "Christoph Janker", "Dong Won Ji", "Daniel Opare", "Andreas Luther", "Kevin Danso", "Rani Khedira", "Erik Thommy", "Shawn Parker", "Marvin Friedrich", "Kevin Danso", "Raphael Framberger", "Kilian Jakob", "Sergio Córdova", "Marco Richter", "Tim Rieder", "Ioannis Gelios"};
    String[] leipzig = {"Timo Werner", "Naby Keïta", "Emil Forsberg", "Bruma", "Marcel Sabitzer", "Kevin Kampl", "Willi Orban", "Péter Gulácsi", "Diego Demme", "Marcel Halstenberg", "Yussuf Poulsen", "Marvin Compper", "Yvon Mvogo", "Dayot Upamecano", "Stefan Ilsanker", "Bernardo", "Dominik Kaiser", "Jean-Kévin Augustin", "Lukas Klostermann", "Benno Schmitz", "Fabio Coltorti", "Konrad Laimer", "Ibrahima Konaté", "Ademola Lookman", "Federico Palacios Martínez", "Philipp Köhn", "Elias Abouchabaka", "Marc Dauter", "Kilian Senkbeil"};

    String[] bundesliga = {"Manuel Neuer", "Robert Lewandowski", "Mats Hummels", "Thiago", "Arjen Robben", "Jérôme Boateng", "Arturo Vidal", "Thomas Müller", "David Alaba", "James Rodríguez", "Franck Ribéry", "Javi Martinez", "Niklas Süle", "Joshua Kimmich", "Kingsley Coman", "Corentin Tolisso", "Juan Bernat Velasco", "Sandro Wagner", "Márcio Rafael Ferreira de Souza", "Sven Ulreich", "Christian Früchtl", "Felix Götze", "Marco Friedl", "Niklas Dorsch", "Fabian Benko", "Woo Yeong Jeong",
        "Marco Reus", "Michy Batshuayi", "Pierre-Emerick Aubameyang", "Roman Bürki", "Sokratis", "Andriy Yarmolenko", "Łukasz Piszczek", "André Schürrle", "Shinji Kagawa", "Ömer Toprak", "Gonzalo Castro", "Bartra", "Guerreiro", "Julian Weigl", "Mario Götze", "Maximilian Philipp", "MArcel Schmelzer", "Christian Pulisic", "Nuri Şahin", "Mahmoud Dahoud", "Sebastian Rode", "Roman Weidenfeller", "Neven Subotić", "Erik Durm", "Jeremy Toljan", "Joo Ho Park", "Manuel Akanji", "Dan-Axel Zagadou", "Alexander Isak", "Jacob Bruun Larsen", "Dominik Reimann", "Jan Niklas Beste", "David Sauerland", "Patrick Fritsch",
        "Thorgan Hazard", "Raffael", "Matthias Ginter", "Yann Sommer", "Lars Stindl", "Jannik Vestergaard", "Vincenzo Grifo", "Ibrahima Traoré", "Christoph Kramer", "Fabian Johnson", "Patrick Herrmann", "Raúl Bobadilla", "Oscar Wendt", "Jonas Hofmann", "Denis Zakaria", "Tony Jantschke", "Tobias Strobl", "Nico Elvedi", "Josip Drmić", "Tobias Sippel", "Mickaël Cuisance", "László Bénes", "Christofer Heimeroth", "Reece Oxford", "Mamadou", "Kwame Yeboah", "Julio Villalba", "Ba-Muaka", "Moritz Nicolas",
        "Nils Petersen", "Pascal Stenzel", "Yoric Ravet", "Florian Niederlechner", "Alexander Schwolow", "Gaëtan Bussmann", "Marc-Oliver Kempf", "Çağlar Söyüncü", "Mike Frantz", "Janik Haberer", "Manuel Gulde", "Rafał Gikiewicz", "Aleksandar Ignjovski", "Christian Günter", "Nicolas Höfler", "Bartosz Kapustka", "Amir Abrashi", "Marco Terrazzino", "Julian Schuster", "Ryan Kent", "Jonas Meffert", "Georg Niedermeier", "Patric Klandt", "Tim Kleindienst", "Lukas Kübler", "Lucas Höler", "Onur Bulut", "Robin Koch", "Patrick Kammerbauer", "Philipp Lienhart", "Karim Guédé", "Caleb Stanko", "Vincent Sierro",
        "Filip Kostić", "Kyriakos Papadopoulos", "Nicolai Müller", "Lewis Holtby", "Albin Ekdal", "André Hahn", "Aaron Hunt", "Mërgim Mavraj", "Dennis Diekmeier", "Christian Mathenia", "Douglas Santos", "Bobby Wood", "Gōtoku Sakai", "Walace", "Gideon Jung", "Julian Pollersbeck", "Sven Schipplock", "Fiete Arp", "Bjarne Thoelke", "Rick van Drongelen", "Mohamed Gouaida", "Gian-Luca Waldschmidt", "Bakery Jatta", "Tom Mickel", "	Vasilije Janjičić", "Mats Köhlert", "Andreas Hirzel", "Frank Ronstadt", "Jonas Behounek", "Christian Stark",
        "Timo Horn", "Jorge Meré", "Frederik Sørensen", "Jonas Hector", "Leonardo Bittencourt", "Vincent Koziello", "Dominique Heintz", "Marco Höger", "Simon Terodde", "Marcel Risse", "Jhon Córdoba", "Yūya Ōsako", "Miloš Jojić", "Matthias Lehmann", "Claudio Pizarro", "Christian Clemens", "Dominic Maroh", "Konstantin Rausch", "Paweł Olkowski", "Artjoms Rudnevs", "Simon Zoller", "Thomas Kessler", "Lukas Klünter", "Sehrou Guirassy", "Jannes Horn", "Salih Özcan", "Sven Müller",
        "Leon Bailey", "Wendell", "Kevin Volland", "Lars Bender", "Bernd Leno", "Jonathan Tah", "Julian Brandt", "Lucas Alario", "Karim Bellarabi", "Charles Aránguiz", "Julian Baumgartlinger", "Dominik Kohr", "Tin Jedvaj", "Stefan Kießling", "Admir Mehmedi", "Ramazan Özcan", "Kai Havertz", "André Ramalho", "Joel Pohjanpalo", "Panagiotis Retsos", "Vladlen Yurchenko", "Niklas Lomb", "Marlon Frey", "Atakan Akkaynak", "Sam Schreck",
        "Naldo", "Leon Goretzka", "Daniel Caligiuri", "Ralf Fährmann", "Breel Embolo", "Coke", "Nabil Bentaleb", "Matija Nastasić", "Max Meyer", "Yevhen Konoplyanka", "Guido Burgstaller", "Bastian Oczipka", "Amine Harit", "Alessandro Schöpf", "Abdul Rahman", "Benjamin Stambouli", "Marko Pjaca", "Franco Di Santo", "Donis Avdijaj", "Thilo Kehrer", "Michael Langer", "Weston McKennie", "Cedric Teuchert", "Alexander Nübel", "Fabian Reese", "Bernard Tekpetey", "Joshua Bitter",
        "Mario Gómez", "Ron-Robert Zieler", "Christian Gentner", "Holger Badstuber", "Simon Terodde", "Emiliano Insúa", "Carlos Mané", "Benjamin Pavard", "Santiago Ascacibar", "Daniel Ginczek", "Andreas Beck", "Timo Baumgartl", "Dennis Aogo", "Ebenezer Ofori", "Ailton", "Takuma Asano", "Marcin Kamiński", "Anastasios Donis", "Josip Brekalo", "Chadrac Akolo", "Jens Grahl", "Matthias Zimmermann", "Anto Grgić", "Berkay Özcan", "Dženis Burnić", "Orel Mangala", "Jacob Bruun Larsen", "Joel Soñora",
        "Jiří Pavlenka", "Max Kruse", "Zlatko Junuzovic", "Ishak Belfodil", "Fin Bartels", "Thomas Delaney", "Sebastian Langkamp", "Lamine Sané", "Niklas Moisander", "Theodor Gebre Selassie", "Robert Bauer", "Luca Caldirola", "Milot Rashica", "Jérôme Gondorf", "Philipp Bargfrede", "Jaroslav Drobný", "Florian Kainz", "Ludwig Augustinsson", "Miloš Veljković", "Aron Jóhannsson", "Izet Hajrović", "Maximilian Eggestein", "Justin Eilers", "Yuning Zhang", "Ulisses Garcia", "Michael Zetterer", "Marco Friedl", "Niklas Schmidt", "Ole Käuper",
        "Rune Almenning Jarstein", "Salomon Kalou", "Vedad Ibišević", "Vladimír Darida", "Karim Rekik", "Marvin Plattenhardt", "Per Ciljan Skjelbred", "Sebastian Langkamp", "Mitchell Weiser", "Niklas Stark", "Thomas Kraft", "Fabian Lustenberger", "Peter Pekarík", "Valentin Stocker", "Genki Haraguchi", "Julian Schieber", "Ondrej Duda", "Karim Rekik", "Alexander Esswein", "Davie Selke", "Mathew Leckie", "Valentino Lazaro", "Arne Maier", "Maximilian Mittelstädt", "Jordan Torunarigha", "Sinan Kurt", "Florian Baak", "Jonathan Klinsmann", "Julius Kade", "Pál Dárdai",
        "René Adler", "Jean-Philippe Gbamin", "Stefan Bell", "Pablo De Blasis", "Danny Latza", "Levin Öztunali", "Jairo", "Yoshinori Mutō", "Fabian Frei", "Daniel Brosinski", "Abdou Diallo", "Niko Bungert", "Leon Balogun", "Viktor Fischer", "Alexandru Maxim", "Gaëtan Bussmann", "Giulio Donati", "Jean-Philippe", "Nigel de Jong", "Robin Quaison", "Karim Onisiwo", "Alexander Hack", "Kenan Kodro", "Emil Berggreen", "Gerrit Holtmann", "Jannik Huth", "Suat Serdar", "Philipp Klement", "Robin Zentner", "Florian Müller", "Marin Šverko", "Bote Baku",
        "Mario Gómez", "Yunus Malli", "Divock Origi", "Camacho", "Daniel Didavi", "Josuha Guilavogui", "John Brooks", "Paul-Georges Ntep", "Maximilian Arnold", "Jeffrey Bruma", "Koen Casteels", "Paul Verhaegh", "Renato Steffen", "Jakub Błaszczykowski", "Felix Uduokhai", "Yannick Gerhardt", "Robin Knoche", "Sebastian Jung", "Riechedly Bazoer", "Marcel Tisserand", "Landry Dimata", "William de Asevedo Furtado", "Josip Brekalo", "Marvin Stefaniak", "Max Grün", "Felix Uduokhai", "Victor Osimhen", "Gian-Luca Itter", "Marian Sarr", "Elvis Rexhbecaj", "Justin Möbius", "Kaylen Hinds", "Davide Itter", "Phillip Menzel", "Robin Ziegele", "Dominik Franke",
        "Salif Sané", "Niclas Füllkrug", "Jonathas", "Ihlas Bebou", "Martin Harnik", "Manuel Schmiedebach", "Julian Korb", "Matthias Ostrzolek", "Waldemar Anton", "Michael Esser", "Pirmin Schwegler", "Felix Klaus", "Edgar Prib", "Oliver Sorg", "Marvin Bakalorz", "Philipp Tschauner", "Kenan Karaman", "Uffe Bech", "Felipe", "Florian Hübner", "Miiko Albornoz", "Iver Fossum", "Noah Joel Sarenren Bazee", "Charlison Benschop", "Sebastian Maier", "Samuel Şahin-Radlinger", "Mike Steven Bähre", "Fynn Arkenberg", "Timo Hübers", "Yousef Emghames",
        "Lukáš Hrádecký", "Kevin-Prince Boateng", "Ante Rebić", "Marco Fabián", "David Abraham", "Jonathan De Guzmán", "Makoto Hasebe", "Jetro Willems", "Alexander Meier", "Sébastien Haller", "Timmy Chandler", "Marc Stendera", "Omar Mascarell", "Gelson Tavares Fernandes", "Mijat Gaćinović", "Simon Falette", "Marco Russ", "Carlos Salcedo", "Marius Wolf", "Branimir Hrgota", "Slobodan Medojević", "Daichi Kamada", "Danny Blum", "Luka Jović", "Taleb Tawatha", "Andersson Ordóñez", "Jan Zimmermann", "Yanni Regäsel", "Aymen Barkok", "Max Besuschkow", "Leon Bätge", "Renat Dadashov",
        "Mark Uth", "Serge Gnabry", "Andrej Kramarić", "Oliver Baumann", "Pavel Kadeřábek", "Sandro Wagner", "Steven Zuber", "Kevin Vogt", "Kerem Demirbay", "Benjamin Hübner", "Håvard Nordtveit", "Eugen Polański", "Lukas Rupp", "Ermin Bičakčić", "Ádám Szalai", "Nico Schulz", "Florian Grillitsch", "Robert Žulj", "Kevin Akpoguma", "Justin Hoogma", "Dennis Geiger", "Felix Passlack", "Alexander Stolz", "Philipp Ochs", "Gregor Kobel", "Meris Skenderović", "Stefan Posch", "Robin Hack",
        "Philipp Max", "Michael Gregoritsch", "Martin Hinteregger", "Alfreð Finnbogason", "Daniel Baier", "Marwin Hitz", "Jeffrey Gouweleeuw", "Ja Cheol Koo", "Konstantinos Stafylidis", "Caiuby", "Marcel Heller", "Moritz Leitner", "Jonathan Schmid", "Gojko Kačar", "Jan Morávek", "Fabian Giefer", "Callsen-Bracker", "Christoph Janker", "Dong Won Ji", "Daniel Opare", "Andreas Luther", "Kevin Danso", "Rani Khedira", "Erik Thommy", "Shawn Parker", "Marvin Friedrich", "Kevin Danso", "Raphael Framberger", "Kilian Jakob", "Sergio Córdova", "Marco Richter", "Tim Rieder", "Ioannis Gelios",
        "Timo Werner", "Naby Keïta", "Emil Forsberg", "Bruma", "Marcel Sabitzer", "Kevin Kampl", "Willi Orban", "Péter Gulácsi", "Diego Demme", "Marcel Halstenberg", "Yussuf Poulsen", "Marvin Compper", "Yvon Mvogo", "Dayot Upamecano", "Stefan Ilsanker", "Bernardo", "Dominik Kaiser", "Jean-Kévin Augustin", "Lukas Klostermann", "Benno Schmitz", "Fabio Coltorti", "Konrad Laimer", "Ibrahima Konaté", "Ademola Lookman", "Federico Palacios Martínez", "Philipp Köhn", "Elias Abouchabaka", "Marc Dauter", "Kilian Senkbeil"
    };

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    String[] allPlayers = (String[]) ArrayUtils.addAll(bundesliga);

    String[] playerList = {
        "K. Mbappé",
        "O. Dembélé",
        "N. Keïta",
        "J. Giménez",
        "G. Rulli",
        "T. Lemar",
        "João Mário",
        "N. Süle",
        "Ederson",
        "Fabinho",
        "M. Salah",
        "A. Belotti",
        "E. Forsberg",
        "Marquinhos",
        "William Carvalho",
        "S. Umtiti",
        "R. Mahrez",
        "V. van Dijk",
        "Roberto Firmino",
        "Danilo Pereira",
        "Vitolo",
        "A. Lopes",
        "S. de Vrij",
        "M. Perin",
        "J. Matip",
        "I. Gueye",
        "Iago Aspas",
        "N. Otamendi",
        "N. Matić",
        "J. Pastore",
        "Parejo",
        "S. Kagawa",
        "G. Bonaventura",
        "B. Dost",
        "K. Walker",
        "Oscar",
        "S. N'Zonzi",
        "M. Musacchio",
        "O. Toprak",
        "José Callejón",
        "Adrien Silva",
        "S. Giovinco",
        "N. Gaitán",
        "M. Mandžukić",
        "A. Lallana",
        "B. Höwedes",
        "E. Banega",
        "Rui Patrício",
        "Y. Sommer",
        "M. Schneiderlin",
        "Jonas",
        "K. Gameiro",
        "L. Piszczek",
        "E. Garay",
        "A. Valencia",
        "K. Schmeichel",
        "M. Dembélé",
        "Borja Valero",
        "L. Perrin",
        "L. Biglia",
        "Juanfran",
        "Diego López",
        "Santi Cazorla",
        "J. Mascherano",
        "W. Sneijder",
        "Nani",
        "D. De Rossi",
        "José Reina",
        "Quaresma",
        "Y. Touré",
        "Casillas",
        "E. Bailly",
        "Marco Asensio",
        "Bernardo Silva",
        "A. Laporte",
        "D. Alli",
        "S. Mané",
        "Carvajal",
        "J. Draxler",
        "M. Icardi",
        "Morata",
        "K. Koulibaly",
        "T. Horn",
        "Koke",
        "K. Manolas",
        "S. Mustafi",
        "Ander Herrera",
        "K. Strootman",
        "Pedro",
        "R. Bürki",
        "Bruno",
        "I. Perišić",
        "E. Džeko",
        "Willian",
        "S. Khedira",
        "R. Fährmann",
        "Sergio Asenjo",
        "Juan Mata",
        "M. Benatia",
        "D. Payet",
        "Falcao",
        "L. Koscielny",
        "G. Cahill",
        "Dani Alves",
        "A. Gómez",
        "Aduriz",
        "Y. Carrasco",
        "R. Varane",
        "Casemiro",
        "L. Insigne",
        "A. Lacazette",
        "K. Navas",
        "H. Mkhitaryan",
        "D. Subašić",
        "B. Leno",
        "M. ter Stegen",
        "K. Glik",
        "Jordi Alba",
        "I. Gündoğan",
        "Azpilicueta",
        "A. Di María",
        "M. Pjanić",
        "C. Marchisio",
        "J. Vertonghen",
        "B. Matuidi",
        "S. Ruffier",
        "Filipe Luís",
        "V. Kompany",
        "A. Barzagli",
        "H. Kane",
        "J. Rodríguez",
        "Isco",
        "D. Alaba",
        "R. Lukaku",
        "Alex Sandro",
        "T. Müller",
        "Sergio Busquets",
        "Coutinho",
        "M. Reus",
        "T. Alderweireld",
        "David Luiz",
        "Diego Costa",
        "R. Nainggolan",
        "Javi Martínez",
        "D. Mertens",
        "Sokratis",
        "Miranda",
        "K. Benzema",
        "Cesc Fàbregas",
        "F. Ribéry",
        "Pepe",
        "P. Čech",
        "N. Kanté",
        "M. Verratti",
        "P. Pogba",
        "C. Eriksen",
        "A. Vidal",
        "E. Cavani",
        "Marcelo",
        "M. Hamšík",
        "I. Rakitić",
        "David Silva",
        "S. Handanovič",
        "Piqué",
        "Iniesta",
        "P. Dybala",
        "J. Oblak",
        "A. Griezmann",
        "Thiago",
        "P. Aubameyang",
        "L. Bonucci",
        "J. Boateng",
        "D. Godín",
        "M. Hummels",
        "M. Özil",
        "H. Lloris",
        "Thiago Silva",
        "Z. Ibrahimović",
        "A. Robben",
        "K. De Bruyne",
        "T. Courtois",
        "A. Sánchez",
        "L. Modrić",
        "G. Bale",
        "S. Agüero",
        "G. Chiellini",
        "G. Buffon",
        "De Gea",
        "E. Hazard",
        "T. Kroos",
        "G. Higuaín",
        "Sergio Ramos",
        "R. Lewandowski",
        "Neymar",
        "L. Suárez",
        "M. Neuer",
        "L. Messi",
        "Cristiano Ronaldo"};

}
