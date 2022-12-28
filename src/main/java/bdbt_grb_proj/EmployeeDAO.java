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
public class EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public EmployeeDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List for data from database */
	public List<Employee> list() {
		String sql = "SELECT nr_pracownika as id, imie as firstName, nazwisko as lastName, "
				+ "data_urodzenia as dateOfBirth, pesel, plec as sex, nr_telefonu as phoneNumber, "
				+ "mail as email, data_zatrudnienia as hireDate, nr_konta as accountNumber, "
				+ "nr_stadniny as studFarmId, nr_adresu as addressId, nr_stanowiska as positionId  FROM pracownicy ";
		List<Employee> listEmployee = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		return listEmployee;
	}

	/* (C)reate */
	public void save(Employee employee) {

		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("pracownicy").usingColumns("imie", "nazwisko", "data_urodzenia",
				"pesel", "plec", "nr_telefonu", "mail", "data_zatrudnienia", "nr_konta", 
				"nr_stadniny", "nr_adresu", "nr_stanowiska");

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("imie", employee.getFirstName());
		param.addValue("nazwisko", employee.getLastName());
		param.addValue("data_urodzenia", employee.getDateOfBirth());
		param.addValue("pesel", employee.getPesel());
		param.addValue("plec", employee.getSex());
		param.addValue("nr_telefonu", employee.getPhoneNumber());
		param.addValue("mail", employee.getEmail());
		param.addValue("data_zatrudnienia", employee.getHireDate());
		param.addValue("nr_konta", employee.getAccountNumber());
		param.addValue("nr_stadniny", employee.getStudFarmId());
		param.addValue("nr_adresu", employee.getAddressId());
		param.addValue("nr_stanowiska", employee.getPositionId());
		
		insertActor.execute(param);

	}

	/* (R)ead */
	public Employee get(int id) {
		Object[] args = { id };
		String sql = "SELECT  nr_pracownika as id, imie as firstName, nazwisko as lastName, "
				+ "data_urodzenia as dateOfBirth, pesel, plec as sex, nr_telefonu as phoneNumber, "
				+ "mail as email, data_zatrudnienia as hireDate, nr_konta as accountNumber,"
				+ "nr_stadniny as studFarmId, nr_adresu as addressId, nr_stanowiska as positionId  FROM pracownicy "
				+ "WHERE nr_pracownika = " + args[0];	
		Employee employee = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		return employee;
	}

	/* (U)pdate */
	public void update(Employee employee) {
		String sql = "UPDATE pracownicy SET imie=:firstName, nazwisko=:lastName, data_urodzenia=:dateOfBirth, "
				+ "pesel=:pesel, plec=:sex, nr_telefonu=:phoneNumber, mail=:email, data_zatrudnienia=:hireDate, "
				+ "nr_konta=:accountNumber, nr_stadniny=:studFarmId, nr_adresu=:addressId, "
				+ "nr_stanowiska=:positionId WHERE nr_pracownika=:id";
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		//BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(employee); //doesn't work because of 'date' data type
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", employee.getId());
		param.addValue("firstName", employee.getFirstName());
		param.addValue("lastName", employee.getLastName());
		param.addValue("dateOfBirth", employee.getDateOfBirth().substring(0,10)); //eliminate time (hh:mm:ss) from date
		param.addValue("pesel", employee.getPesel());
		param.addValue("sex", employee.getSex());
		param.addValue("phoneNumber", employee.getPhoneNumber());
		param.addValue("email", employee.getEmail());
		param.addValue("hireDate", employee.getHireDate().substring(0,10)); //eliminate time (hh:mm:ss) from date
		param.addValue("accountNumber", employee.getAccountNumber());
		param.addValue("studFarmId", employee.getStudFarmId());
		param.addValue("addressId", employee.getAddressId());
		param.addValue("positionId", employee.getPositionId());
		
		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int id) {
		String sql = "DELETE FROM pracownicy WHERE nr_pracownika = ?";
		jdbcTemplate.update(sql, id);
	}

}
