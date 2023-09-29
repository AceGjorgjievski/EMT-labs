THE AMAZON WAY -- 
GREAT MAN--

BAU - https://accelerator.ukim.mk
================
1 kol
crons expressions i ostanatite od baza za delot zadachi
B2C, C2C itn...
Spotify
Canva direct competitor
od baza imashe nekoi tie slikanite od ispiti shto se...


=============================
Hakeri - lichnosti koi shto imaat namera da dobijat neavtoriziran pristap do compjuterski sistem


integritet - kje se pristapat data onaka kako shto se [ona shto sme zapishale kako odgovor kje se zachuva vo baza]
	
neodreklivost - onoj koj shto kje vleze vo e-trasakcija nema da mozhat da ja odrechat ovaa transakcija
 [primer: jas ne odgovoriv na prashanjeto ... "ne pominuva taa negacija"]
avtentichnost - da si znaeme so kogo si imame rabota (sigurna komunikacija) [proces na registracija/ login proces]
doverlivost - da mozheme da pristapime do prashanjata, no i do db [shto smeam da pravam, da pristapam [od strana na klientot]]
	(proces na avtorizacija)
privatnost - nachinot na koi individuite mozhat da gi kontroliraat informaciite
dostapnost - ako nema courses, nema da mozheme so bbb chas

worms - mozhe da zhiveat vo RAM 

mal. code - pasivni i chekaat nekoja akcija da se sluchi
ransomware - encripcija pravi so kluch, ako sakame da gi dobie podatoci treba da platime otkup [ransom] za da gi dobieme
	back up na kritichni fajls

phishing - drugi ne' naveduvaat da dademe podatoci; se oslonuvaat deka lugjeto se naivni, ljubopitni ...

insider atacks - nekoj od vnatre kje gi ukrade podatocite

D/Dos - golemo kolichestvo na soobrakjaj na eden server se isprateni


=============================
hibernate - ORM -> ovaa klasa mapiraj ja vo tabela
eden korisnik kje ima edna aktivna koshnichka, a drugi kje 'lebdat'
i potoa kje imame schedule task koj koga kje nema traffic mnogu na app vo 2am primer
i kje gi ischistime togash.


DTO -> za nekoja 3rd party aplikacija ni treba... 
	nekogash ne sakame da gi predademe site podatoci nanadvor ili
	da gi zachuvame site podatoci za ona shto go dobivame.
	Kje ni treba za predavanje, za podatoci za od gore nadolu i od dolu nagore niz aplikacijata
	- subset na informacii od vistinskiot entitet i go koristime za nekakva komunikacija

React* -> RestfullControllers vrakjaat data i tie data se onie koi vo nekakov json ili xml format
	nashata react aplikacija treba da gi prepoznae i kako takvi react aplikacijata kje bide 
	taa koja shto treba da odluchi kako istite da gi renderira t.e.
	taa kje bide odgovorna za gradenje na view-to koj shto korisnikot treba da go gleda.

@42m -> static
fetchType.EAGER -> kje ni ja zabavuva aplikacijata so povlekuvanje na vrskite
fetchType.LAZY -> podobro e, 

@52m
@EntityGraph.FETCH -> site atributi shto kje gi specificiram kje bidat so EAGER type,
		a site atributi shto ne gi specificiram kje bidat tretirani so LAZY type
@EntityGraph.LOAD -> site atributi shto kje gi specificiram kje bidat so EAGER type,
		a site onie koi shto ne gi specificiram kje bidat kako shto e tretirano
		vo nivniot tip t.e. ona shto e default dokolku nema takvo specificiranje

	ima i 'attributePaths' za koi vazhi takvoto loadiranje



@Transactional -> da ne se vmetne pred da se izbrishe vo multithread okolina [atomichno]
		(povekje povici do baza, da gi napravime atomicni), nema do pola da se izvrshi, ili se' ili nishto

@RequestBody - imajkji go https protocolot, podatocite shto kje bidat prateni kje bidat enkriptirani

application-properties -> setiranje na globalni properties na aplikacijata

kako da se zachuva editiran product na i-ta pozicija, a da ne e na posledna od listata.. ?
treba biznis logika?


FILTERS....

problem za "Found shared references to a collection"  https://prnt.sc/tdo-WPd8wZMY


http://localhost:8080/register?error=could%20not%20execute%20statement;%20SQL%20[n/a];%20constraint%20[id%22%20of%20relation%20%22shop_user];%20nested%20exception%20is%20org.hibernate.exception.ConstraintViolationException:%20could%20not%20execute%20statement
===================================
za proekcija kje ni treaba 1 intefejs, get methods soodvetni

enitity graph prashanja **** fetch, low
kaj proekcijata isto taka query**

read-write moment mozhat da se zashtitat so @Version ** [optimistic lock]
@Lock - pesimistic locking

@Autowired - ne treba kaj service logic; mozhe da ima nekoj problem pri injection, pri izvrshuvanjeto na aplikacijata mozhe
da padne na run, a koga imame pri constructor based injection - kje pradne pri konstruktorot? 
@Bean e se' ona shto e kontroler, service

se chuva na disk, ima problem koj go nema kaj normalen pogled, poblisku e do obichna tabela; 
ako neshto se smeni od koe e kreirano amterilizariano view treba da se refreshira.. ?

kje ni treba refresh() [vo service] koga se pravi nekoja promena vo baza, za da ni se pokazhe promenata vo tebelite 


PAGINATION - da nie dobivame razlichen subset na informacii od daden entitet bidejkji na pr. imame 1M data
	i imame nekoja prodavnica i nema sigurno da gi vlecheme site tie podatoci od DB i potoa da filtrirame
	zatoa shto toa e dosta pobavno od ona da se pravime direktno filtriranje pri samoto vlechenje. So
	samoto vlechenje da bide ogranicheno i ponatamu da se hendlaat kako takvi i toa e dosta pobrzo
	zatoa shto operaciite vo DB mozhe polesno da se optimiziraat

Optimistic lock - se koristi nekoj flag, koe shto ni kazhuva koga nekoj zapis vo DB bil posledno
		updateritan, nekoj timestampt koga toj zapis vo ramkata na DB bil primenet i
		dopolnitelno nekoj integer koj ni ovozmozhuva nekoe verzioniranje na toj zapis.
		(nekoj broj sekvencijalen broj 1,2,3 koj kje kazhuva koja e verzijata na toj zapis)
Pessimistic lock - koga imame nekoj eksluziven lock, zemame eksluzivitet vrz nekoj del od kodot i velime vo 
		daden moment dodeka go imame toj lock, samo nie menadzirame so toj zapis/i i odgovnornosta
		e na programerot podocna da go oslobodi toj lock za da ne ostane neiskoristliv kod

Event Publishing - nekakva sposobnost koja ni' e ovozmozhena od aplikaciskiot kontekst, vsushnost toa
		ni e nekakov mehanizam koj shto mozheme da go iskoristime za komunikacija pomegju
		komponentite vo ramkite na nekakva sping-boot aplikacija

schedule event -> 2am primerot List<ShoppingCart> carts....
============================================================
Node.js -> open source platform, javascript runtime enviroment, it allows to execute javascript code 
	beyond the broswer
Npm -> package manager for javascript 

react app ->  zadolzhena da go rendirara view-to za samiot korisnik. Prakja http baranje kon spring app [rest app]
		za na pr. i' treba listata od site produkti, potoa vraten vo json, xml. Mozhe da imame sluchaj 
		koga ne vrakjame informacii, na pr. brishenje na nekoj produkt.

componenti -> gradbeni edinki na edna react aplikacija t.e. komponentite go gradat toa drvo na aplikacija, ona se'
		shto kje se renderira vo ramki na aplikacijata

hook - ovozmozhuva da ima state vo stateless?
callbacks se funkcii

ResponseEntity<Enitity> - vo sebe chuva entitet i dopolnitelno status kod

-application abstract za molbi
-dali dto mora da bide subset od originalniot entitet? i 
kade [vo koj paket] da gi stavam site ovie zaedno so ApplicationAbstract

-skit za functional-based approach za karakteristikite

problem so verziite na react/// nvm install -v ..

life cycle na componenti ** KOL
dali e pravilna ovaa komponenta, ovoj kod..
kako izgleda edna kompomenata, staful, stateless, . .. .

========================================================================================
dimenzii za zashtita, napadi... *
kako kje garantiram doverlivorst> za profs eden kluch, za studenti dr kluch, itn...
confidentiality, nonrepudation

java web tocken na se decriptira,a tuku se prenesuva

[payment gateway + certificate]

**state, props, definiranje na componenta za react
klasni, funkcionalni komponenti 
koga, koe i kade se koristi...
**hooks
jpa - metodi, paging, sorting
entity graphs, kolku queries...
----------------------------------------
*problem kaj id Integer za molbi
*edit na i-ot element da se zachuva na i-ta pozicija

----------------------------------------------------------------------------------

statefull autheticity -> site informacii koi shto se vrzani za korisnikot (korisnichki profil, 
		ulogata vo samiot sistem), se chuvaat vo RAM memorijata na samiot server.
		Koga kje se restartira taa applikacija, site informacii koi shto se chuvale vo ramki
		na RAM memorijata kje bidat prebrishani i ako korisnik prethodno se obidel da ja 
		koristi web app site informacii shto bile smesteni vo RAM memorija kje mu se prebrishat.
		t.e. koristevme state(sostojba) so cel da gi zachuvame podatocite shto ni se potrebni.

statless -> koga stanuva zbor za mikroservisna arhitektura najchesto treba da vnimavame na toa deka treba
	skoro sekogash nashata aplikacija nekako da skalira. Za da mozhe najednostavno da skalira togash treba
	da koristime stateless mehanizmi. Eden od tie stateless mehanizmi, koga ne se voveduva sostojba koja shto
	se chuva vo RAM memorijata na web serverot, ni prestavuva aventikacijata i avtorizacijata na korisnicite. 
	Site informacii ne treba da gi zachuvame vo sesija koga stanuva zbor za takov tip na stateless avtentikacija i
	avtorizacija, tuku tie informacii treba postojano da patuvaat koga se prakjaat soodvetnite baranja (so sekoj request).
	Korisnichkoto ime i ulogata treba nekako da bidat postojano razmenuvani vo samiot server. No razmenata ne mozhe da 
	bide vo plain text bidejkji nekoj mozhe da go nacheka nashiot profil i mnogu lesno mozhe da simulira baranja deka nie 
	sme gi napravile (nekoj intruder) i togash bi imale bezbednosen problem vo samata web aplikacija.
                - Zatoa site informacii koi shto patuvaat od klientot do serverot treba da bidat encodirani. Za taa cel vo sovremeniot svet,
	vo sovremenite aplikacii se koristat JWT tokeni.

JWT tokens -> eden vid na standard za encodiranje na informacija koja shto taa informacija treba da bide razmenuvana
		pomegju dve ili povekje mashini so koristenje preku mrezhni resursi. Pritoa treba da bideme sigurni deka
		nikoj ne mozhe da gi dekodira tie informacii koi shto gi razmenuvame so onoj server so koi shto sme
		verifikuvani so koj shto treba da razmenime nekoja si informacija. Celiot toj transport na podatoci mora
		nekako da bide zashtiten za da ne dojde nekoj intruder chisto da ni ja napadne nashata bezbednost na
		internet.

		JWT tokenite se najchesto scenario koga sakame da razmenime informacija koja shto e vrzana za identifikacija
		na kod koj shto se obiduva da go pristapi soodveniot resurs. Shtom korisnikot vednash se najavi, toj dobiva
		nekoj si JWT token vo koj shto se enkodirani negovite informaciite za toa koj e toj (usually username & Role) vo 
		sistemot i potoa taa informacija se razmenuva postojano pomegju serverot i klientot so toa shto toj JWT postojano
		se dodava vo samiot header na baranjeto. 

	Kako fukcionira celoto use case scenario koga se pravi celata taa avtentikacija i avtorizacija na korisnici?
	Napochetok, korisnikot mozhebi ne e avtenticiran na serverot, vnesuva username & password, pravi POST baranje do serverot,
	serverot dokolku otkrie deka korisnikot e validen, deka se tochni negovite credenitials koi shto gi pratil, 
	togash mu kreira soodveten JWT so koristenje na secret kod i toj JWT se vrakja vo broswer. Broswer-ot 
	taa informacija ja chuva soodvetno vo kolache i potoa pri sekoe novo baranje, se prakja i JWT koi
	shto vo toa kolache kako Authorization Header (se preprekja kako dopolnitelen header vo sekoe baranje).
	Najchesto formatot na toj header: Authorization: Bearer <token> (nekoj si standard pri avtorizacija na korisnici).
	Serverot go chita toj header, go proveruva potpisot na samiot JWT i gi izvlekuva korisnichkite informacii 
	so koristenje na JWT. Zoshto gi izvlekuva? Bidejkji tie informacii se vgnezdeni vo ramki na samiot JWT koga
	kje se decodira na secret kodot koj shto samo go znae. 
	Potoa koga kje se otkrijat korisnichkite informacii na samiot korisnik togash se obrabotuva baranjeto, se znae
	negovata uloga vo ramki na sistemot i vrz baza na site tie informacii se vrakja soodveten odgovor na klientot.

	Ako serverot sluchajno ne uspee da go decodira JWT i otkrie nekakvi problemi vo samiot togash mu vrakja poraka za
	greshka t.e. mu kazhuva na korisnikot deka soodvetno ne e avtenticiran da go koristi resursot  koj shto se obiduva
	da go pristapi.

	JWT najchesto se koristat koga imame nekoj set na skaliranje na aplikacii, koga imame poseben back-end i koga
	imame poseben front-end. Vo toj sluchaj nemame nekoj si state pomegju dvete aplikacii, celata komunikacija
	ni e stateless, samiot http ni pretstavuva stateless protokol, protokol vo koj shto nemame postojana sesija. Tuku 
	prethodno koga koristevme thymeleaf se obiduvavme da odrzhuva nekoja si virtuelna sesija pomegju broswer-ot
	i samiot server. Sega koga imame posebna front-end i back-end aplikacija, taa sesija vooposhto ne postoi i najchesto
	celata taa komunikacija se vospostavuva so koristenje na nekoi dopolnitelni tokeni. I sega koga imame avtentikacija i
	avtorizacija na korisnici za da go koristime toj JWT da go avtenticirame/avtorizirame korisnikot.

Server sent events - sending one request and you keep getting one response
	infinitely unti you give up and close the connection or close the request. 
	




Load balancer - softversk aplikacija koja shto se obiduva site requesti koi shto pristignuvaat
	na odredena aplikacija da go balansira na nekolku identichni instanci od istata.
	Mnogu e vazhno koga sakame da izrabotime skalabilna aplikacija.


============================================

... -> spread operator so koj shto gi zimame prethodnite informacii

============================================

za sekoj ogranichen konteskt definirame posebna aplikacija, nekoj vid na mikroservisi
koj shto kje gi koristime ponatamu za da gi reshavame site posebni problemite poedinechno, a
voedno da ovozhmozhime nekakva komunikacija pomegju niv. Za sekoj poseben ogranichen 
konktest imame poseben softverski artefakt [posebna aplikacija koja shto ja koristime i razvivame postojano].

Subdomains => site onie definirani ogranicheni konteksti koi shto se razlikuvaat 
		od ona jadroto koe shto sakame da implementirame

mutable =>mozhe da se promenlivi,
	 znachi deka mozheme da kreirame seteri vo nashata klasa

anemichnost => promena koja shto ne sme sakale da ni se sluchni

vo value objects skoro nikogash ne se pishuavat seteri, bidejkji ako sakame da kreirame nov objekt, togash treba
	da krirame nov vrednosen objekt[?], ne sodrzhi identifikator

value objects mnogu chesto kje gi koristime za da referencirame drugi objekti

eden agregat mozhe da bide sostaven od povekje entiteti od povekje vrednosni objekti, no samo eden entitet
ni pretstavuva root na agregatot. Voedno site transakcii se izvrshuvaat i oddrzhuvaat vo samiot agregat.
Site ischituvanja na bazata, site zapishuvanja kje bidat vrz baza na celiot agregat.
Ako ischituvame neshto od ovoj agregat togash treba da bide sigurni deka site entiteti kje gi dobieme vo
edna transakcija; ako imame @OneToMany, @ManyToMany vrski, site gi ischituvame naednash.

Zapishuvanjeto e na nivo na celiot agregat, se pravi inset na site informacii.

vrednosnite objekti ne' zashtituvaat do pristap do nekoja si vrska do nekoj si drug agregat i
na toj nachin stavame nekakva si granica do kade celiot toj tip na fetching na data treba da zastane,
se' so cel da imame malku pooptimalni querinja

domain servisite ne smeat vnatre da sodrzhat nekoja tehnologija. Site raboti koi shto se vrzani so nekoja
tehnologija pr. security, menadziranje na transakcii, treba da stojat nadvor od domain servisite duri i od
celiot domain koj shto go imame. Ako sakame da vovedeme nekoja tehnologija, togash taa tehnologija
kje ja postavime vo aplikaciskite servisi.

pishuvame biznis logika vo domain servisite samo vo momenti koga odredeno parche kod ne se vklopuva 
vo nitu eden od value objektite nitu vo entitetite. Za da go reshime toj problem voveduvame domain service.

stateless => nikogash ne treba da ja menuvaat svojata sostojba, ne treba da chuvaat informacii, pri povik na 
	odreden method vo nikoj sluchaj ne smeat vnatre vo sebe tie da sodrzhat nekoj si vrednosti/data koj
	shto mozhat lesno da bidat promeneti.

Aplikaciski servisi => site raboti koi shto se vrzani so tehnologija dobro e da bidat postaveni vo aplikaciski servisi. 
	Njachesto tie ne implementiraat biznis logika, biznis logikata skoro sekogash treba da bide vo domain servisite
	i vo domain slojot.

@Transactional => site operacii koi shto se pravat vo ramki na samata baza, da se izvrshat so eden commit; se' so cel
	da imame informacija ako nastane nekoj exception, site promeni koi shto bile prethodno narpaveni da bidat roll-backed
	(prebrishani), poradi toa shto transakcijata ne e celosno izvrshena. Mora site operacii da bidat atomichno izvrsheni
	vo ramki na prakjanje na nekoja transakcija.
	[ako se isfrli exception, @Transactional kje napravi roll-back, 
	bilo kakva promena da sme napravile vo baza, taa kje ischezne]

=========================================================================================== 
Posoodvetno e site transakcii da se izveduvaat preku agregat root
Agregat root - site ostanati transakcii koi shto kje se izvrshuvaat, kje se pravat preku toj root.
		Vrz koj entitet kje se izvrshuvaat site promeni vo ostanatite entiteti.
		Ako imame OneToMany vrska kaj 'Many' zapisite nekako ne e soodvetno
		site tie 'Many' da ni bidat agregat roots, zatoa najdobro e da se dvizhime
		kon 'One' klasata koja shto sekogash e edna i zatoa e najdobro da bide
		agregat root za razlika od 'Many' vrskata. 
		[	https://prnt.sc/X_eJ0TKix-Pd		]
		Site modifikacii koi shto se ppavat koga se izvrshuva nekoja biznis invarijanta [pravila]
		togash odime preku samiot root i odime preku edna edinstvena transakcija.
	
Value object - ako na daden property treba da se pravi nekoja biznis logika, togash toj property
	treba da stane value object
	* Ako sakame da napravime promena na samata vrednost na vrednosnite objekti, togash
	treba da vratime nova instanca od istite

@MappedSuperclass => koga dadena klasa ima vakva anotacija, site atributi na ovaa klasa i site onie koi
		shto se specifikacii na ovaa klasa kje bidat kako edno mnozhestvo i kje bidat soodvetno dodadeni
		vo tabelata koja shto kje se kreira

DomainObjectId => toa kje bide domain object koj shto vnatre vo sebe kje ima samo id i kje implementira
		Serializable [za da mozhe da se serijalizira koga kje se perzistira vo baza]

Serializable - pretvoranje na objekt vo format shto mozhe da bide zachuvan ili prenesuvan vo mrezha i
	da se vrati vo originalna forma podocna. Ovozmozhuva perzistiranje na objektite i da se prevzemat
	podocna ako e potrebno.

@Embeddable => [lesno da se vgradi vo samiot entitet]
	site atributi shto ti ima odredena klasa [pr. Quantity], da gi ima soodvetno i samata tabela 
	[pr. Product koja shto chuva Quantity] koja shto kje se kreira vo ramki na samata baza.
	*Ako ne stavime @Embeddable togash kje se buni samiot JPA koga kje se startuva aplikacijata, 
	kje reche "mora da stavite ManyToOne vrska", ako ova se sluchi znachi deka treba da stavime 
	@Embeddable t.e. vo samata tabela da se kreiraat plus koloni kolku shto ima [pr. Quantity] atributi

@EmbeddedId => ako nekoe 'Id' sakame da kazheme da bide embedded t.e. kompoziten kluch vo ramki na 
		spring boot i na Jpa t.e. pole koe shto vnatre mozhebi sodrzhi povekje atributi,
		ne e nekoja primitiva tuku nekoja klasa



abstractEntity => osnovna klasa, koja shto kje poseduva najchesto samo Id
========================================================
controlerite ni sluzhat kako vrska so nadvoreshniot svet, no ne smeat da izvrshuvaat nekoja
biznis logika. Biznis logikata se izvrshuva vo ramki na samiot domen, poednostavni metodi koi shto
ne pobaruvaat tehnologija i site tie metodi, celiot toj domen, go orkestriraat(povikuvaat) aplikaciskite servisi.

==============================================

ddl hibernate tabeli kreiranje....
List<ShoppingCart>?

od resources kopiranje na db migrations i flyweight dependecies
migriranje na recourses

==============================================


Question:
This method is defined like this:

@EntityGraph(type = EntityGraph.EntityGraphType.Fetch, attributePaths = {"tags"})
Iterable<Video> findAll();

If in the database we have saved 5 videos, organized in 2 categories, how many hibernate queries will be generated 
within only one repository.fetchAll() ?
	
@Table
public class Video {

	@Id
	@GeneratedValue
	public Long id;

	@ManyToOne
	public Category category; //Category does not have foreign keys

	@ManyToMany
	public List<Tag> tags = new ArrayList<>(); //Tag does not have foreign keys

}

select one:
a. 7
b. 5
c. 3
d. 1





