package br.araujo.caio.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.araujo.caio.enums.Uf;

public class Cidade implements Serializable {

	private static final long serialVersionUID = 8141581444992791229L;

	private Long ibgeId;

	private Uf uf;

	private String name;

	private Boolean capital;

	private Double longitude;

	private Double latitude;

	private String noAccents;

	private String alternativeNames;

	private String microregion;

	private String mesoregion;

	public Long getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(Long ibgeId) {
		this.ibgeId = ibgeId;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeName) {
		this.alternativeNames = alternativeName;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getIbgeId() + ",");
		sb.append(this.getUf() + ",");
		sb.append(this.getName() + ",");
		sb.append(this.isCapital() + ",");
		sb.append(this.getLongitude() + ",");
		sb.append(this.getLatitude() + ",");
		sb.append(this.getNoAccents() + ",");
		sb.append(this.getAlternativeNames() + ",");
		sb.append(this.getMicroregion() + ",");
		sb.append(this.getMesoregion());

		return sb.toString();
	}

	public static Map<String, String> getMethodNamesMapping() {
		Map<String, String> methodNames = new HashMap<String, String>();
		methodNames.put("ibge_id", "getIbgeId");
		methodNames.put("uf", "getUf");
		methodNames.put("name", "getName");
		methodNames.put("capital", "isCapital");
		methodNames.put("lon", "getLongitude");
		methodNames.put("longitude", "getLongitude");
		methodNames.put("lat", "getLatitude");
		methodNames.put("latitude", "getLatitude");
		methodNames.put("no_accents", "getNoAccents");
		methodNames.put("alternative_names", "getAlternativeNames");
		methodNames.put("microregion", "getMicroregion");
		methodNames.put("mesoregion", "getMesoregion");

		return methodNames;
	}

}
