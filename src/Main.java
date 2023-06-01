import models.Aeroporto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        static Scanner console = new Scanner(System.in);

        static List<Aeroporto> aeroportos = new ArrayList<>();

        static final String DIRETORIO_ARQUIVO = "data/airports.csv";

        static Aeroporto pesquisarAeroportoIata(String iata) {
            for (int i = 0; i <aeroportos.size(); i++) {
                if (aeroportos.get(i).getIata().equalsIgnoreCase(iata)) {
                    return aeroportos.get(i);
                }
            }
            return null;
        }

        static Aeroporto pesquisarAeroportoNome(String nome) {
            for (int i = 0; i <aeroportos.size(); i++) {
                if (aeroportos.get(i).getName().equalsIgnoreCase(nome)) {
                    return aeroportos.get(i);
                }
            }
            return null;
        }

        static List<Aeroporto> pesquisarAeroportoCidade(String cidade) {
            List<Aeroporto> aeroportoCidadeList = new ArrayList<>();
            for (int i = 0; i < aeroportos.size(); i++) {
                if (aeroportos.get(i).getCity().equalsIgnoreCase(cidade)){
                    aeroportoCidadeList.add(aeroportos.get(i));

                }
            }
            return aeroportoCidadeList;
        }

        static List<Aeroporto> pesquisarAeroportoPais(String pais) {
            List<Aeroporto> aeroportosPaisList = new ArrayList<>();
            for (int i = 0; i < aeroportos.size(); i++) {
                if (aeroportos.get(i).getCountry().equalsIgnoreCase(pais)){
                    aeroportosPaisList.add(aeroportos.get(i));

                }
            }
            return aeroportosPaisList;
        }

    static double converterPesToMeters(double pes) {
            return pes * 0.3048;
        }

        static void carregarDadosDosAeroportos() {
            try (BufferedReader leitor = new BufferedReader(new FileReader(DIRETORIO_ARQUIVO))) {
                String linhaDoArquivo = leitor.readLine();
                while (linhaDoArquivo != null) {
                    String[] campos = linhaDoArquivo.split(";");

                    Aeroporto a = new Aeroporto();

                    int aero = Integer.parseInt(campos[0]);
                    String name = campos[1];
                    String city = campos[2];
                    String country = campos[3];
                    String iata = campos[4];
                    String icao = campos[5];
                    double latitude = Double.parseDouble(campos[6]);
                    double longitude = Double.parseDouble(campos[7]);
                    double altitudeM = Double.parseDouble(campos[8]);
                    String fusoHorario = campos[9];
                    String horarioDeVerao = campos[10];
                    String type = campos[11];

                    a.setAirportId(aero);
                    a.setName(name);
                    a.setCity(city);
                    a.setCountry(country);
                    a.setIata(iata);
                    a.setIcao(icao);
                    a.setLatitude(latitude);
                    a.setLongitude(longitude);
                    a.setAltitudeM(altitudeM);
                    a.setTimeZone(fusoHorario);
                    a.setTzDatabaseTimeZone(horarioDeVerao);
                    a.setType(type);

                    aeroportos.add(a);
                    linhaDoArquivo = leitor.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        static void buscarAeropostos() {


            System.out.println("Voce deseja buscar um aeroporto por iata ou nome ou buscar aeroportos em alguma regiao? digite 0 para sair.");
            String entrada = console.nextLine().trim().toUpperCase();

            if(entrada.equalsIgnoreCase("0")){
                System.exit(0);
            } else{
                if  (entrada.equalsIgnoreCase("regiao")) {
                    System.out.println("Pais ou cidade?");
                    entrada = console.nextLine();
                    if (entrada.equalsIgnoreCase("cidade")) {
                        // para buscar aeroportos na cidade
                        System.out.println("Digite a cidade: ");
                        entrada = console.nextLine();

                        System.out.println("Aeroportos na cidade de " + entrada);
                        List<Aeroporto> aeroportoCidadeList = new ArrayList<>();
                        aeroportoCidadeList = pesquisarAeroportoCidade(entrada);
                        int quantidade = 0;

                        for (int i = 0; i < aeroportoCidadeList.size(); i++) {
                            System.out.println(aeroportoCidadeList.get(i));
                            System.out.println("");
                            quantidade++;
                        }
                        System.out.println(quantidade + " Aeroportos encontrados na cidade de " + entrada);
                    } else {
                        // para buscar aeroportos num pais
                        System.out.println("Digite o pais: ");
                        entrada = console.nextLine();

                        System.out.println("Aeroportos no pais " + entrada);
                        List<Aeroporto> aeroportoPaisList = new ArrayList<>();
                        aeroportoPaisList = pesquisarAeroportoPais(entrada);
                        int quantidade = 0;

                        for (int i = 0; i < aeroportoPaisList.size(); i++) {
                            System.out.println(aeroportoPaisList.get(i));
                            System.out.println();
                            quantidade++;
                        }
                        System.out.println(quantidade + " Aeroportos encontrados no pais " + entrada);

                    }
                } else if (entrada.equalsIgnoreCase("iata")) {
                    // para buscar por iata
                    System.out.println("digite a IATA do aeroporto desejado: ");
                    entrada = console.nextLine().trim().toUpperCase();

                    Aeroporto aeroporto = pesquisarAeroportoIata(entrada);
                    System.out.println(aeroporto.toString());

                } else if (entrada.equalsIgnoreCase("nome")){
                    // para buscar por nome
                    System.out.println("Digite o Nome do aeroporto desejado: ");
                    entrada = console.nextLine().trim();

                    Aeroporto aeroporto = pesquisarAeroportoNome(entrada);
                    System.out.println(aeroporto.toString());
                }
                buscarAeropostos();
            }

        }
    public static void main(String[] args) {

            carregarDadosDosAeroportos();
            buscarAeropostos();
    }
}