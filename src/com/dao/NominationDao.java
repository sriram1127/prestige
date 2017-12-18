package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.Nomination;
import com.beans.Nominee;

public class NominationDao {

	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	ResultSet rs = null;

	String username = "postgres";
	String password = "admin";
	String url = "jdbc:postgresql://127.0.0.1:5432/Prestige";

	public Integer getRecognitionAreaId(String Area) throws SQLException, ClassNotFoundException {
		Integer Id = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(
					"SELECT * FROM public.\"RecognitionArea\" re WHERE re.\"Name\"=? and re.\"status\" = true");
			ps.setString(1, Area);
			rs = ps.executeQuery();
			if (rs.next()) {
				Id = rs.getInt("Id");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return Id;
	}

	public Integer getRecognitionTypeId(String type) throws SQLException, ClassNotFoundException {
		Integer Id = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(
					"SELECT * FROM public.\"RecognitionType\" re WHERE re.\"Name\"=? and re.\"status\" = true");
			ps.setString(1, type);
			rs = ps.executeQuery();
			if (rs.next()) {
				Id = rs.getInt("Id");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return Id;
	}

	public Long nominate(Nomination nomination) throws SQLException, ClassNotFoundException {
		Long Id = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, username, password);
			String insertTableSQL = "INSERT INTO public.\"Nominations\""
					+ "(\"Title\", \"RecognitionId\",\"NominatorFirstName\", \"NominatorLastName\", \"NominatorUserId\", \"RecognitionAreaId\", \"Description\", \"CreatedAt\", \"Status\") VALUES"
					+ "(?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nomination.getTitle());
			preparedStatement.setLong(2, nomination.getRecognitionId());
			preparedStatement.setString(3, nomination.getNominatorFirstName());
			preparedStatement.setString(4, nomination.getNominatorLastname());
			preparedStatement.setString(5, nomination.getNominatorUserId());
			// preparedStatement.setLong(6, (int) Math.random());
			preparedStatement.setLong(6, nomination.getRecognitionAreaId());
			preparedStatement.setString(7, nomination.getDescription());
			preparedStatement.setTimestamp(8, nomination.getCreatedAt());
			preparedStatement.setLong(9, nomination.getStatus());
			// execute insert SQL stetement

			int result = preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();

			if (rs != null && rs.next()) {
				Id = rs.getLong(1);
				for (Nominee nominee : nomination.getNominees()) {
					nominee.setNominationId(Id);
					nominate(nominee, con);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return Id;
	}

	public void nominate(Nominee nominee, Connection con) throws SQLException, ClassNotFoundException {
		Long Id = null;
		try {
			String insertTableSQL = "INSERT INTO public.\"Nominees\""
					+ "(\"NominationId\", \"NomineeFirstName\", \"NomineeLastname\", \"NomineeUserId\") VALUES"
					+ "(?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setLong(1, nominee.getNominationId());
			preparedStatement.setString(2, nominee.getNominationFirstName());
			preparedStatement.setString(3, nominee.getNominationLastName());
			preparedStatement.setString(4, nominee.getNominationUserId());

			// execute insert SQL stetement

			int result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
