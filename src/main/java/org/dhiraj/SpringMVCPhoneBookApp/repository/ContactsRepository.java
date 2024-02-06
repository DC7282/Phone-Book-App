package org.dhiraj.SpringMVCPhoneBookApp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dhiraj.SpringMVCPhoneBookApp.model.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("contactsRepository")
public class ContactsRepository {
@Autowired
JdbcTemplate template;

//	public boolean isDataSaved(final Contacts contacts) {
//		return template.update("insert into phonebook values ('0',?,?,?,?,?,?)",new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, contacts.getName());
//				ps.setString(2, contacts.getEmail());
//				ps.setString(3, contacts.getContact());
//				ps.setString(4, contacts.getUsername());
//				ps.setString(5, contacts.getPassword());
//				ps.setString(6, contacts.getAddress());
//			}
//		})>0 ? true : false;
//	}

	public int isDataSaved(final Contacts contacts) {
		List<Contacts> emailList=template.query("select email from phonebook where email=?", new Object[] {contacts.getEmail()},new RowMapper<Contacts>(){

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts c = new Contacts();
				c.setEmail(rs.getString(1));
				return c;
			}});

		List<Contacts> contactList=template.query("select contact from phonebook where contact=?", new Object[] {contacts.getContact()}, new RowMapper<Contacts>() {

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts c=new Contacts();
				c.setContact(rs.getString(1));
				return c;
			}});

		List<Contacts> usernameList=template.query("select username from phonebook where username=?", new Object[] {contacts.getUsername()}, new RowMapper<Contacts>() {

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts c=new Contacts();
				c.setUsername(rs.getString(1));
				return c;
			}});

		if(emailList.size()>0) {
			return -1;
		}else if(contactList.size()>0) {
			return -2;
		}else if(usernameList.size()>0) {
			return -3;
		}else {
			return template.update("insert into phonebook values ('0',?,?,?,?,?,?)",new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, contacts.getName());
					ps.setString(2, contacts.getEmail());
					ps.setString(3, contacts.getContact());
					ps.setString(4, contacts.getUsername());
					ps.setString(5, contacts.getPassword());
					ps.setString(6, contacts.getAddress());
				}
			})>0 ? 1 : 0;
		}

	}

	public List<Contacts> getAllContacts(){
		List<Contacts> list = template.query("select * from phonebook", new RowMapper<Contacts>() {

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts c= new Contacts();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setUsername(rs.getString(5));
				c.setPassword(rs.getString(6));
				c.setAddress(rs.getString(7));
				return c;
			}
		});
		return list;
	}

	public List<Contacts> getAllContactBySearch(String user) {
		List<Contacts> list = template.query("select * from phonebook where name like '%"+user+"%' OR email like '%"+user+"%' OR Contact like '%"+user+"%' OR username like '%"+user+"%' OR address like '%"+user+"%'", new RowMapper<Contacts>() {

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts c=new Contacts();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setContact(rs.getString("contact"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				return c;
			}

		});
		return list;
	}

	public boolean deleteDataUsingId(Integer id) {
		return template.update("delete from phonebook where id="+id)>0 ? true : false;

	}

	public int checkEmail(String email) {
	 List list=template.query("select * from phonebook where email='"+email+"'", new RowMapper() {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return null;
		}
	 });
	return (list.size());
	}

	public int checkUsername(String username) {
		List list = template.query("select * from phonebook where username='"+username+"'", new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return null;
			}
		});
		return (list.size());
	}

	public int checkContact(String contact) {
		List list = template.query("select * from phonebook where contact='"+contact+"'", new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return null;
			}
		});
		return (list.size());
	}

	public List<Contacts> getAllContactForUpdate(Integer id) {
		List<Contacts> list = template.query("select * from phonebook where id="+id, new RowMapper<Contacts>() {

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts c= new Contacts();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setUsername(rs.getString(5));
				c.setPassword(rs.getString(6));
				c.setAddress(rs.getString(7));
				return c;
			}
		});
		return list;
	}

	public int UpdateUserData(final Contacts contacts, Integer id) {
		return template.update("Update phonebook set name=?, password=?, address=? where id="+id, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, contacts.getName());
				ps.setString(2, contacts.getPassword());
				ps.setString(3, contacts.getAddress());
			}
		})>0 ? 1 : 0;

	}
}
