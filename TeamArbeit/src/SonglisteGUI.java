import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SonglisteGUI extends JFrame {
	// Allgemeine Klassenvariabeln werden gesetzt
	private Songliste songliste;
	private Song aktuellerSong;
	private boolean neuModus = false;

	// Alle Label werden initialisiert
	private JLabel titelLabel;
	private JLabel interpreterLabel;
	private JLabel albumLabel;
	private JLabel jahrLabel;

	// Alle Textfelder werden initialisiert
	private JTextField titelText;
	private JTextField interpreterText;
	private JTextField albumText;
	private JTextField jahrText;

	// Alle Kn�pfe werden initialisiert
	private JButton ersteSong;
	private JButton vorigeSong;
	private JButton nechsteSong;
	private JButton letzteSong;
	private JButton neueSong;
	private JButton entferntSong;
	private JButton entferntAlles;

	// GUI Konstruktor wird erstellt
	public SonglisteGUI() {
		// Titel wird festgelegt
		setTitle("Songliste");
		// Gr��e und Position auf den Bildschirm werden gesetzt
		// width = 460px; height = 220px
		setBounds(100, 100, 460, 220);
		// Wenn das Fenster geschlossen wird, wird somit das Programm auch beendet
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Alle Label werden deklariert und positioniert
		// 5px vom Rand und 25px vom oberen Label
		// Breite des Label = 80px; H�he = 18px
		titelLabel = new JLabel("Titel:");
		titelLabel.setBounds(5, 15, 80, 18);
		interpreterLabel = new JLabel("Interpret:");
		interpreterLabel.setBounds(5, 40, 80, 18);
		albumLabel = new JLabel("Album:");
		albumLabel.setBounds(5, 65, 80, 18);
		jahrLabel = new JLabel("Jahr:");
		jahrLabel.setBounds(5, 90, 80, 18);

		// Alle Textfelder werden deklariert und neben den Label positioniert
		// Gleich neben Label, 80px vom Rand
		// Alle au�er JahrText sind 370px breit; H�he = 18px
		titelText = new JTextField();
		titelText.setBounds(80, 15, 370, 18);
		interpreterText = new JTextField();
		interpreterText.setBounds(80, 40, 370, 18);
		albumText = new JTextField();
		albumText.setBounds(80, 65, 370, 18);
		jahrText = new JTextField();
		// Ist k�rzer als andere
		jahrText.setBounds(80, 90, 50, 18);

		// Erste Reihe an Kn�pfe wird angelegt un positioniert
		// Knopf: Breite= 111px; H�he= 30px
		// 117px von oben Abstand; Immer +111px von links
		ersteSong = new JButton("Erster");
		ersteSong.setBounds(5, 117, 111, 30);
		vorigeSong = new JButton("Voriger");
		vorigeSong.setBounds(116, 117, 111, 30);
		nechsteSong = new JButton("N�chster");
		nechsteSong.setBounds(227, 117, 111, 30);
		letzteSong = new JButton("Letzter");
		letzteSong.setBounds(338, 117, 111, 30);

		// Zweite Reihe an Kn�pfe
		// Knopf: Breite= 150px; H�he= 30px
		// 150px von oben und +150 von links
		neueSong = new JButton("Neu");
		neueSong.setBounds(5, 150, 150, 30);
		entferntSong = new JButton("L�schen");
		entferntSong.setBounds(155, 150, 150, 30);
		entferntAlles = new JButton("L�scht alles");
		entferntAlles.setBounds(305, 150, 145, 30);

		// Container macht alle Elemente auf dem Fenster sichtbar
		Container contentPane = getContentPane();
		// Kein Layout verwendet
		contentPane.setLayout(null);
		contentPane.add(titelLabel);
		contentPane.add(interpreterLabel);
		contentPane.add(albumLabel);
		contentPane.add(jahrLabel);
		contentPane.add(titelText);
		contentPane.add(interpreterText);
		contentPane.add(albumText);
		contentPane.add(jahrText);
		contentPane.add(ersteSong);
		contentPane.add(vorigeSong);
		contentPane.add(nechsteSong);
		contentPane.add(letzteSong);
		contentPane.add(neueSong);
		contentPane.add(entferntSong);
		contentPane.add(entferntAlles);

		// Gr��e des Fensters kann nicht ver�ndert werden
		setResizable(false);
		// Fenster ist somit sichtbar
		setVisible(true);

		// Erstellt eine neue Songliste mit einer maximalen Anzahl an Songs
		songliste = new Songliste(0);
		// Setzt den Pfad wo die Datei liegt die alle Songs enth�lt
		songliste.setPfad("D:\\School\\Informatik\\Rohdateien\\RohdateienTeam\\tracklist.csv");
		// Liest alle songs aus der Datei
		songliste.lesenSongs();

		// Leerer Song wird angelegt, sp�ter wird dem Werte �bergeben
		aktuellerSong = new Song();
		aktuellerSong.setTitel("");
		aktuellerSong.setAlbum("");
		aktuellerSong.setErscheinungsjahr(650);
		aktuellerSong.setInterpret("");

		// Knopf um zum Ersten Song in der Songliste zu kommen
		ersteSong.addActionListener(
				// Action des Knopfes
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Um Null auszuweichen
						try {
							// Aktuelle Song wird zum ersten Song in der Songliste
							aktuellerSong = songliste.getErster();
							// Alle Texte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// NullPointerException Fehler wird aufegangen
						} catch (NullPointerException e) {
							// Wenn Null entsteht, werden alle Felder auf "Fehler" gesetzt
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Knopf um den Vorigen Song in der Songliste auszugeben
		vorigeSong.addActionListener(
				// Aktion des Knopfs
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Damit wird bei leere Songs das Null ausgewichen
						try {
							// Aktueller Song wird zum aktuellen Song
							aktuellerSong = songliste.getVoriger();
							// Wenn der aktuelle Song bereits der erste ist, wird eine Meldung ausgegeben
							if (aktuellerSong == null) {
								aktuellerSong = songliste.getErster();
								JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
							}
							// Alle Werte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// Wenn der Song Null ausgibt, wird eine Fehlermeldung aufgefangen
						} catch (NullPointerException e) {
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Knopf um den n�chsten Song auszugeben
		nechsteSong.addActionListener(
				// Aktion des Knopfes
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Damit werden Null ausgewichen
						try {
							// Aktueller Song wird zum aktuellen Song in der Songliste
							aktuellerSong = songliste.getNaechster();
							// Wenn der n�chste Song null ist, bedeutet es dass wir am Ende angekommen sind
							if (aktuellerSong == null) {
								// Alle Werte werden leer gestellt, somit kann ein neuer Song am Ende angef�gt
								// werden
								aktuellerSong = new Song();
								//aktuellerSong.setTitel("");
								//aktuellerSong.setInterpret("");
								//aktuellerSong.setAlbum("");
								//aktuellerSong.setErscheinungsjahr(0);
							}
							// Alle Werte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// Null Fehler wird aufgefangen
						} catch (NullPointerException e) {
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Knopf um das letzte Song zur�ckzugeben
		letzteSong.addActionListener(
				// Aktion des Knopfes
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Somit wird der NullException Fehler ausgewichen
						try {
							// Aktueller Song wird zum letzten Song
							aktuellerSong = songliste.getLetzter();

							// Werte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// NullpointerException wird aufgefangen
						} catch (NullPointerException e) {
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Knopf um den neuen Song zu setzen
		neueSong.addActionListener(
				// Aktion des Knopfes
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Somit wird der NullException Fehler ausgewichen
						try {
							// Es wird zuerst ein leerer Song erstellt
							aktuellerSong = new Song();
							// Dann wird alles auf leer gestzt, somit kann man neue Werte einf�gen
							aktuellerSong.setTitel("");
							aktuellerSong.setInterpret("");
							aktuellerSong.setAlbum("");
							aktuellerSong.setErscheinungsjahr(0);

							// Werte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// erst dann wenn es genug Platz im Array gibt, wird der Song eingef�gt
							if (songliste.getAnzahl() < songliste.getMaxAnzahl()) {
								// F�gt ein neuen Song am Ende des Arrays ein
								songliste.anfuegenNeuen(aktuellerSong);
							} else {
								// Fehlermeldung: Kein Platz im Array
								JOptionPane.showMessageDialog(getContentPane(), "Maximale Anzahl an Songs erreicht\n"
										+ "Songs: " + songliste.getAnzahl() + " / " + songliste.getMaxAnzahl());
							}
							// NullpointerException wird aufgefangen
						} catch (NullPointerException e) {
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Knopf um den aktuellen Song zu l�schen
		entferntSong.addActionListener(
				// Aktion des Knopfes
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Somit wird der NullException Fehler ausgewichen
						try {
							// Aktueller Song wird zum aktuellen Song
							aktuellerSong = songliste.getAktueller();

							// Werte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// Wenn der Benutzer beim Meldungsfenster auf Ja clickt
							if (JOptionPane.showConfirmDialog(getContentPane(),
									// Text und Titel des Fenster
									"Wirklich den aktuellen Song l�schen?", "Song l�schen",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								// Aktueller Song wird aus der Liste gel�scht
								songliste.loeschenAktuellen();
							}
							// NullpointerException wird aufgefangen
						} catch (NullPointerException e) {
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Knopf um alle Songs zu l�schen
		entferntAlles.addActionListener(
				// Aktion des Knopfes
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						// Somit wird der NullException Fehler ausgewichen
						try {
							// Es wird der aktuelle Song ausgegeben
							aktuellerSong = songliste.getAktueller();
							// Werte werden gesetzt
							titelText.setText(aktuellerSong.getTitel());
							interpreterText.setText(aktuellerSong.getInterpret());
							albumText.setText(aktuellerSong.getAlbum());
							jahrText.setText(String.valueOf(aktuellerSong.getErscheinungsjahr()));

							// Dialogfenster um das L�schen aller Songs zu best�tigen
							if (JOptionPane.showConfirmDialog(getContentPane(),
									// Text und Titel des Fenster
									"Wirklich alle Songs l�schen?", "Alles l�schen",
									// Wenn auf "Ja" geclickt wird
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								// Alle Songs werden gel�scht
								songliste.loeschenAlle();
								// Der Zeiger in der Songliste wird auf den ersten gestellt
								songliste.getErster();
								// Alle Felder werden auf leer gestellt
								titelText.setText("");
								interpreterText.setText("");
								albumText.setText("");
								jahrText.setText("");
							}

							// NullpointerException wird aufgefangen
						} catch (NullPointerException e) {
							titelText.setText("NullException");
							interpreterText.setText("NullException");
							albumText.setText("NullException");
							jahrText.setText("0");
						}
					}
				});
		// Beim Schlie�en des Fenster werden alle Songs im Array geschreiebn und das
		// Programm beendet
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					// Schreibt alle Songs im Array
					songliste.schreibenSongs();
					// Zigt dass es erfolgreich war
					System.out.println("Erfolgreich!\n"
							+ songliste.getAnzahl() +" Songs in der Datei geschrieben");
				} catch (NullPointerException f) {
					System.out.println("Fehler beim Schreiben der Songs");
				}
			}
		});
		// Eventlistener f�r Textfelder. H�ren Events ab und reagieren dementsprechend
		// Sind f�r alle Textfelder fast gleich, nur beim Erscheinungsjahr muss noch
		// geschaut werden dass die Zahl auch g�ltig ist
		// Eventlistener f�r den Textfeld: titelText
		titelText.getDocument().addDocumentListener(new DocumentListener() {
			// Wenn der Textfeld ge�ndert wurde, wird auch der Song dementsprechend ge�ndet
			public void changedUpdate(DocumentEvent e) {
				// Vermeidet Fehlermeldungen
				try {
					// �ndert den aktuellen Song ab und speichert es im Array
					aktuellerSong.setTitel(titelText.getText());
					songliste.aendernAktuellen(aktuellerSong);
					// Um bei leere Songs das Programm nicht zu crashen wird ein catch eingesetzt
				} catch (NullPointerException f) {
					// Gibt einfach Null aus
					System.out.println("Null");
				}
			}

			// Wenn der Inhalt des Textfelds gel�scht wird, wird es ebenfalls gespiechert
			public void removeUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setTitel(titelText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}

			// Wenn im Texfeld etwas neues eingef�gt wird, wird es auch gespeichert
			public void insertUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setTitel(titelText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}
		});
		// Eventlistener f�r den Textfeld: interpreterText
		interpreterText.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setInterpret(interpreterText.getText());
					songliste.aendernAktuellen(aktuellerSong);

				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}

			public void removeUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setInterpret(interpreterText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}

			public void insertUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setInterpret(interpreterText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}
		});
		// Eventlistener f�r den Textfeld: albumText
		albumText.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setAlbum(albumText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}

			public void removeUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setAlbum(albumText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}

			public void insertUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setAlbum(albumText.getText());
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				}
			}
		});
		// Eventlistener f�r den Textfeld: jahrText
		jahrText.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				// Durch try und catch k�nnen wir falsche Eingaben vorbeugen
				try {
					// Versucht den String in ein Integer umzuwandeln
					aktuellerSong.setErscheinungsjahr(Integer.parseInt(jahrText.getText()));
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				} catch (NumberFormatException n) {
					// Gibt eine Fehlermeldung aus
					JOptionPane.showMessageDialog(getContentPane(), "Bitte geben Sie ein g�ltiges Jahr ein");
				}
			}

			public void removeUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setErscheinungsjahr(Integer.parseInt(jahrText.getText()));
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				} catch (NumberFormatException n) {
					// Musste auskommentieren weil sonst st�ndig eine Fehlermeldung erscheinen w�rde
					// JOptionPane.showMessageDialog(getContentPane(), "Bitte geben Sie ");
				}
			}

			public void insertUpdate(DocumentEvent e) {
				try {
					aktuellerSong.setErscheinungsjahr(Integer.parseInt(jahrText.getText()));
					songliste.aendernAktuellen(aktuellerSong);
				} catch (NullPointerException f) {
					System.out.println("Null");
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(getContentPane(), "Bitte geben Sie ein g�ltiges Jahr ein");
				}
			}
		});
	}

}
