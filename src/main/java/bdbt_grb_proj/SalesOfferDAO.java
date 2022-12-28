package bdbt_grb_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class SalesOfferDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public SalesOfferDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<SalesOffer> list() {
		String sql = "SELECT nr_oferty as id, status_oferty as status, cena as price, "
				+ "nr_konia as horseId FROM Oferty_sprzedazy";
		List<SalesOffer> listSalesOffer = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(SalesOffer.class));
		return listSalesOffer;
	}

	/* (C)reate */
	public void save(SalesOffer salesOffer) {

		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("oferty_sprzedazy").usingColumns("status_oferty", "cena", "nr_konia");

		// BeanPropertySqlParameterSource param = new
		// BeanPropertySqlParameterSource(salesOffer);
		// in BeanPropertySqlParameterSource parameters names must be the same in
		// program as in database, otherwise doesn't work
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("status_oferty", salesOffer.getStatus());
		param.addValue("cena", salesOffer.getPrice());
		param.addValue("nr_konia", salesOffer.getHorseId());
		
		insertActor.execute(param);

	}

	/* (R)ead */
	public SalesOffer get(int id) {
		Object[] args = { id };
		String sql = "SELECT  nr_oferty as id, status_oferty as status, cena as price, "
				+ "nr_konia as horseId FROM oferty_sprzedazy WHERE nr_oferty = " + args[0];
		SalesOffer salesOffer = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(SalesOffer.class));
		return salesOffer;
	}

	/* (U)pdate */
	public void update(SalesOffer salesOffer) {
		String sql = "UPDATE oferty_sprzedazy SET status_oferty=:status, cena=:price, nr_konia=:horseId WHERE nr_oferty=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(salesOffer);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int id) {
		String sql = "DELETE FROM oferty_sprzedazy WHERE nr_oferty = ?";
		jdbcTemplate.update(sql, id);
	}
}
