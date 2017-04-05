/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author user
 */
public class Ventana extends javax.swing.JFrame {

    private Partido[] partidosGeneral = null;

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextResultados = new javax.swing.JTextArea();
        jCompara = new javax.swing.JButton();
        jLiga = new javax.swing.JCheckBox();
        jChampions = new javax.swing.JCheckBox();
        jEuropaLeague = new javax.swing.JCheckBox();
        jCopaRey = new javax.swing.JCheckBox();
        jSegunda = new javax.swing.JCheckBox();
        jSerieA = new javax.swing.JCheckBox();
        jPremier = new javax.swing.JCheckBox();
        jLeague1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBundesliga = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextResultados.setEditable(false);
        jTextResultados.setColumns(20);
        jTextResultados.setRows(5);
        jScrollPane1.setViewportView(jTextResultados);

        jCompara.setText("Comparar");
        jCompara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComparaActionPerformed(evt);
            }
        });

        jLiga.setText("Liga");

        jChampions.setText("Champions Legue");

        jEuropaLeague.setText("Europa League");
        jEuropaLeague.setEnabled(false);

        jCopaRey.setText("Copa del Rey");

        jSegunda.setText("Segunda");

        jSerieA.setText("Serie A");

        jPremier.setText("Premier League");

        jLeague1.setText("League 1");

        jLabel1.setText("Nacional");

        jLabel2.setText("Europa");

        jLabel3.setText("Internacional");

        jBundesliga.setText("Bundesliga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCompara))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEuropaLeague)
                            .addComponent(jChampions)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSegunda)
                                    .addComponent(jCopaRey)
                                    .addComponent(jLiga)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLeague1)
                                    .addComponent(jLabel3)
                                    .addComponent(jSerieA)
                                    .addComponent(jPremier)
                                    .addComponent(jBundesliga))))
                        .addGap(0, 549, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLiga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSegunda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCopaRey)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jCompara))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jChampions)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEuropaLeague))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPremier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSerieA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLeague1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBundesliga)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComparaActionPerformed

        String[] urlSportium, partidos;
        String aux = ";";

        // Comprobar las check box
        if (this.jLiga.isSelected()) {
            aux = aux + "13568" + ';';
        }
        if (this.jCopaRey.isSelected()) {
            aux = aux + "13561" + ';';
        }
        if (this.jSegunda.isSelected()) {
            aux = aux + "13510" + ';';
        }
        if (this.jChampions.isSelected()) {
            aux = aux + "13844" + ';';
        }
        if (this.jEuropaLeague.isSelected()) {
            aux = aux + "13814" + ';';
        }
        if (this.jBundesliga.isSelected()) {
            aux = aux + "13401" + ';';
        }
        if (this.jLeague1.isSelected()) {
            aux = aux + "20814" + ';';
        }
        if (this.jPremier.isSelected()) {
            aux = aux + "13881" + ';';
        }
        if (this.jSerieA.isSelected()) {
            aux = aux + "12565" + ';';
        }
        urlSportium = aux.split(";");

        try {
            if (partidosGeneral == null) {
                partidosGeneral = new WilliamHill().parser("http://sports.williamhill.es/bet_esp/es/betting/y/5/cp/577/.html");
                partidosGeneral = (Partido[]) ArrayUtils.addAll(partidosGeneral, new WilliamHill().parser("http://sports.williamhill.es/bet_esp/es/betting/y/5/cp/576/.html"));
                partidosGeneral = (Partido[]) ArrayUtils.addAll(partidosGeneral, new WilliamHill().parser("http://sports.williamhill.es/bet_esp/es/betting/y/5/cp/392/.html"));
                partidosGeneral = (Partido[]) ArrayUtils.addAll(partidosGeneral, new Bet365().parser("http://www.bet365.es/home/inplayapi/Sportsbook.asp?lid=3&zid=0&pd=%23AC%23B1%23C1%23D13%23E27147976%23F2%23R1%23W%5E0%3A%23AC%23B1%23C1%23D13%23E27951351%23F2%23R1%23%3A%23AC%23B1%23C1%23D13%23E27205780%23F2%23R1%23%3A%23AC%23B1%23C1%23D13%23E27801897%23F2%23R1%23%3A%23AC%23B1%23C1%23D13%23E27246864%23F2%23R1%23%3A%23AC%23B1%23C1%23D13%23E27254891%23F2%23R1%23&wg=0&cid=171&ctid=171"));
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

        // Capturo los datos de las competiciones
        this.jTextResultados.setText("");
        for (int i = 1; i < urlSportium.length; i++) {
            // Saco los partidos de la competición
            try {
                aux = new Sportium().parser(urlSportium[i]);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
            /*partidos = aux.split("\n");
             this.jTextResultados.append("\n\n");
             this.jTextResultados.append("Partidos de "+getCompeticion(urlSportium[i])+".\n");
             this.jTextResultados.append("Fecha\tHora\tPartido\t\t\tApuesta\n");
             for(int j=0;j<partidos.length;j++) {
             String [] datos = partidos[j].split(";");
             this.jTextResultados.append(datos[1]+" \t\t"+datos[0]);
             this.jTextResultados.append("\t "+datos[2]+" - "+datos[3]);
             this.jTextResultados.append("\t\t "+datos[4]+" - "+datos[5]+" - "+datos[6]+".\n");
             }*/
            //this.jTextResultados.append(urlSportium[i]+'\n');
            // Traduzco los partidos de Sportium
            Partido[] partidosSportium = new Sportium().StringToPartido(aux);
            // Busco los seleccionados para comparar y los muestro
            this.jTextResultados.append("\n\nCompetición " + getCompeticion(urlSportium[i]) + "\n----------------------------------------------------------------------\n\n");
            this.jTextResultados.append("Partido\t\t\tFecha\t\tHora\n");
            //System.out.println("Partidos Sportium: " + getCompeticion(urlSportium[i]) + " " + partidosSportium.length + " partidos William: " + partidosGeneral.length + ".");
            for (int j = 0; j < partidosSportium.length; j++) {
                this.jTextResultados.append(partidosSportium[j].equipo1 + " - " + partidosSportium[j].equipo2 + "\t\t");
                this.jTextResultados.append(partidosSportium[j].fecha.get(Calendar.DATE) + "-" + Sportium.toMonth(partidosSportium[j].fecha.get(Calendar.MONTH)) + "\t\t" + partidosSportium[j].fecha.get(Calendar.HOUR_OF_DAY));
                if (partidosSportium[j].fecha.get(Calendar.MINUTE) > 0) {
                    this.jTextResultados.append(":" + partidosSportium[j].fecha.get(Calendar.MINUTE) + "\n");
                } else {
                    this.jTextResultados.append(":00\n");
                }

                ArrayList<Partido> casas = new ArrayList<>();
                casas.add(partidosSportium[j]);
                double mejorVictoria1 = partidosSportium[j].costeVictoria1;
                double mejorVictoria2 = partidosSportium[j].costeVictoria2;
                double mejorEmpate = partidosSportium[j].costeEmpate;

                // this.jTextResultados.append("" + partidosSportium[j].casa + ": " + partidosSportium[j].costeVictoria1 + " - " + partidosSportium[j].costeEmpate + " - " + partidosSportium[j].costeVictoria2 + "\n");
                for (int k = 0; k < partidosGeneral.length; k++) {
                    if (partidosSportium[j].equals(partidosGeneral[k])) {
                        //System.out.println("Iguales encontrados!!\n");
                        // Comparamos
                        //this.jTextResultados.append("" + partidosGeneral[k].casa + ": " + partidosGeneral[k].costeVictoria1 + " - " + partidosGeneral[k].costeEmpate + " - " + partidosGeneral[k].costeVictoria2 + "\n");
                        casas.add(partidosGeneral[k]);

                        mejorVictoria1 = Math.max(mejorVictoria1, partidosGeneral[k].costeVictoria1);
                        mejorVictoria2 = Math.max(mejorVictoria2, partidosGeneral[k].costeVictoria2);
                        mejorEmpate = Math.max(mejorEmpate, partidosGeneral[k].costeEmpate);
                    }
                }

                for (Partido partido : casas) {
                    String a1 = partido.costeVictoria1 == mejorVictoria1 ? "*" : "";
                    String ae = partido.costeEmpate == mejorEmpate ? "*" : "";
                    String a2 = partido.costeVictoria2 == mejorVictoria2 ? "*" : "";
                    this.jTextResultados.append("" + partido.casa + ": \t" + partido.costeVictoria1 + a1 + " - " + partido.costeEmpate + ae + " - " + partido.costeVictoria2 + a2 + "\n");
                }
                if (casas.size() >= 2) {
                    this.jTextResultados.append("MEJORES: \t" + mejorVictoria1 + " - " + mejorEmpate + " - " + mejorVictoria2 + "\n");
                }
                Double gananciaMinima = Math.min(Math.min(mejorVictoria1, mejorVictoria2), mejorEmpate)-3;
                if (gananciaMinima > 0) {
                    this.jTextResultados.append("APUESTA SEGURA!!! MONOS LOCOS!!! GANACIA MINIMA: "+(Math.round(gananciaMinima*100)/100.0)+"\n");
                }

                this.jTextResultados.append("\n");
            }
        }
    }//GEN-LAST:event_jComparaActionPerformed

    private String getCompeticion(String id) {
        if (id.equalsIgnoreCase("13568")) {
            return "Liga";
        }
        if (id.equalsIgnoreCase("13510")) {
            return "Segunda";
        }
        if (id.equalsIgnoreCase("13561")) {
            return "Copa del rey";
        }
        if (id.equalsIgnoreCase("13844")) {
            return "Champions League";
        }
        if (id.equalsIgnoreCase("13814")) {
            return "EuropaLeague";
        }
        if (id.equalsIgnoreCase("13881")) {
            return "Premier League";
        }
        if (id.equalsIgnoreCase("20814")) {
            return "League 1";
        }
        if (id.equalsIgnoreCase("12565")) {
            return "Serie A";
        }
        if (id.equalsIgnoreCase("13401")) {
            return "Bundesliga";
        }

        return "";
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jBundesliga;
    private javax.swing.JCheckBox jChampions;
    private javax.swing.JButton jCompara;
    private javax.swing.JCheckBox jCopaRey;
    private javax.swing.JCheckBox jEuropaLeague;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox jLeague1;
    private javax.swing.JCheckBox jLiga;
    private javax.swing.JCheckBox jPremier;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jSegunda;
    private javax.swing.JCheckBox jSerieA;
    private javax.swing.JTextArea jTextResultados;
    // End of variables declaration//GEN-END:variables
}
