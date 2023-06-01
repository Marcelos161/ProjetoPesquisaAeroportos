package models;

public class Aeroporto {

    private int airportId;
    private String name;
    private String city;
    private String country;
    private String iata;
    private String icao;
    private double latitude;
    private double longitude;
    private double altitudeM;
    private String timeZone;
    private String dst;
    private String tzDatabaseTimeZone;
    private String type;
    private String source;

    public Aeroporto(){

    }

    public Aeroporto(int airportId, String name, String city, String country, String iata, String icao, double latitude, double longitude, double altitudeM, String timeZone, String dst, String tzDatabaseTimeZone, String type, String source) {
        this.airportId = airportId;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iata = iata;
        this.icao = icao;

        this.latitude = latitude;
        this.longitude = longitude;
        this.altitudeM = altitudeM;
        this.timeZone = timeZone;
        this.dst = dst;
        this.tzDatabaseTimeZone = tzDatabaseTimeZone;
        this.type = type;
        this.source = source;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitudeM() {
        return altitudeM;
    }

    public void setAltitudeM(double altitudeM) {
        this.altitudeM = altitudeM;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getTzDatabaseTimeZone() {
        return tzDatabaseTimeZone;
    }

    public void setTzDatabaseTimeZone(String tzDatabaseTimeZone) {
        this.tzDatabaseTimeZone = tzDatabaseTimeZone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ID = %s \n", airportId));
        sb.append(String.format("Nome = %s \n", name));
        sb.append(String.format("Cidade = %s \n", city));
        sb.append(String.format("Pais = %s \n", country));
        sb.append(String.format("IATA = %s \n", iata));
        sb.append(String.format("ICAO = %s \n", icao));
        sb.append(String.format("Longitude = %f \n", longitude));
        sb.append(String.format("latidude = %f \n", latitude));
        sb.append(String.format("Altitude = %.2f \n", altitudeM));
        sb.append(String.format("Fuso Horario = %s \n", timeZone));
        sb.append(String.format("Horario de Verao = %s \n", dst));
        sb.append(String.format("Tipo = %s \n", type));

        return sb.toString();
    }
}
