package bdbt_grb_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class HorseDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public HorseDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List for data from database */
	public List<Horse> list() {
		String sql = "SELECT nr_konia as id, nazwa as name, plec_konia as sex, "
				+ "data_urodzenia as dateOfBirth, rod_meski as maleLineage, linia_zenska as femaleLineage, "
				+ "przeznaczenie as intendedUse, kraj_pochodzenia as countryOfOrigin, wymiar1 as dimensionOne, "
				+ "wymiar2 as dimensionTwo, wymiar3 as dimensionThree, dodatkowe_informacje as additionalInfo, "
				+ "nr_stadniny as studFarmId, nr_masci as equineCoatColorId, nr_rasy as breedId  FROM konie ";
		List<Horse> listHorse = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Horse.class));
		return listHorse;
	}
	
	/* (C)reate */
	public void save(Horse horse) {

		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("konie").usingColumns("nazwa", "plec_konia", "data_urodzenia",
				"rod_meski", "linia_zenska", "przeznaczenie", "kraj_pochodzenia", "wymiar1", "wymiar2", 
				"wymiar3", "dodatkowe_informacje", "nr_stadniny", "nr_masci", "nr_rasy");

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nazwa", horse.getName());
		param.addValue("plec_konia", horse.getSex());
		param.addValue("data_urodzenia", horse.getDateOfBirth());
		param.addValue("rod_meski", horse.getMaleLineage());
		param.addValue("linia_zenska", horse.getFemaleLineage());
		param.addValue("przeznaczenie", horse.getIntendedUse());
		param.addValue("kraj_pochodzenia", horse.getCountryOfOrigin());
		if (horse.getDimensionOne() != null && !horse.getDimensionOne().isEmpty())
			param.addValue("wymiar1", Float.parseFloat(horse.getDimensionOne()));
		else
			param.addValue("wymiar1", null);
		if (horse.getDimensionTwo() != null && !horse.getDimensionTwo().isEmpty())
			param.addValue("wymiar2", Float.parseFloat(horse.getDimensionTwo()));
		else
			param.addValue("wymiar2", null);
		if (horse.getDimensionThree() != null && !horse.getDimensionThree().isEmpty())
			param.addValue("wymiar3", Float.parseFloat(horse.getDimensionThree()));
		else
			param.addValue("wymiar3", null);
		param.addValue("dodatkowe_informacje", horse.getAdditionalInfo());
		param.addValue("nr_stadniny", horse.getStudFarmId());
		param.addValue("nr_masci", horse.getEquineCoatColorId());
		param.addValue("nr_rasy", horse.getBreedId());
		
		insertActor.execute(param);

	}

	/* (R)ead */
	public Horse get(int id) {
		Object[] args = { id };
		String sql = "SELECT  nr_konia as id, nazwa as name, plec_konia as sex, "
				+ "data_urodzenia as dateOfBirth, rod_meski as maleLineage, linia_zenska as femaleLineage, "
				+ "przeznaczenie as intendedUse, kraj_pochodzenia as countryOfOrigin, wymiar1 as dimensionOne, "
				+ "wymiar2 as dimensionTwo, wymiar3 as dimensionThree, dodatkowe_informacje as additionalInfo, "
				+ "nr_stadniny as studFarmId, nr_masci as equineCoatColorId, nr_rasy as breedId FROM konie "
				+ "WHERE nr_konia = " + args[0];	
		Horse horse = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Horse.class));
		return horse;
	}

	/* (U)pdate */
	public void update(Horse horse) {
		String sql = "UPDATE konie SET nazwa=:name, plec_konia=:sex, data_urodzenia=:dateOfBirth, "
				+ "rod_meski=:maleLineage, linia_zenska=:femaleLineage, przeznaczenie=:intendedUse, kraj_pochodzenia=:countryOfOrigin, "
				+ "wymiar1=:dimensionOne, wymiar2=:dimensionTwo, wymiar3=:dimensionThree, dodatkowe_informacje=:additionalInfo, "
				+ "nr_stadniny=:studFarmId, nr_masci=:equineCoatColorId, nr_rasy=:breedId WHERE nr_konia=:id";
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		//BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(horse); //doesn't work because of 'date' data type
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", horse.getId());
		param.addValue("name", horse.getName());
		param.addValue("sex", horse.getSex());
		param.addValue("dateOfBirth", horse.getDateOfBirth().substring(0,10)); //eliminate time (hh:mm:ss) from date
		param.addValue("maleLineage", horse.getMaleLineage());
		param.addValue("femaleLineage", horse.getFemaleLineage());
		param.addValue("intendedUse", horse.getIntendedUse());
		param.addValue("countryOfOrigin", horse.getCountryOfOrigin());
		if (horse.getDimensionOne() != null && !horse.getDimensionOne().isEmpty())
			param.addValue("dimensionOne", Float.parseFloat(horse.getDimensionOne()));
		else
			param.addValue("dimensionOne", null);
		if (horse.getDimensionTwo() != null && !horse.getDimensionTwo().isEmpty())
			param.addValue("dimensionTwo", Float.parseFloat(horse.getDimensionTwo()));
		else
			param.addValue("dimensionTwo", null);
		if (horse.getDimensionThree() != null && !horse.getDimensionThree().isEmpty())
			param.addValue("dimensionThree", Float.parseFloat(horse.getDimensionThree()));
		else
			param.addValue("dimensionThree", null);
		param.addValue("additionalInfo", horse.getAdditionalInfo());
		param.addValue("studFarmId", horse.getStudFarmId());
		param.addValue("equineCoatColorId", horse.getEquineCoatColorId());
		param.addValue("breedId", horse.getBreedId());
		
		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int id) {
		String sql = "DELETE FROM konie WHERE nr_konia = ?";
		jdbcTemplate.update(sql, id);
	}

}
