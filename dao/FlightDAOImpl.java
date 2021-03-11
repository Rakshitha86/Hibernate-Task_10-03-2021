package com.xworkz.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.xworkz.dto.FlightDTO;
import com.xworkz.sessionfactory.SingleSessionFactory;

public class FlightDAOImpl implements FlightDAO {


	@Override
	public void saveFlight(FlightDTO dto) {
		Session session = null;
		try {
			SessionFactory sessionFactory = SingleSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dto);
			System.out.println(dto);
			transaction.commit();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {

				if (Objects.nonNull(session)) {
					session.close();
					System.out.println("Session is closed");
				} else {
					System.out.println("Session not closed");
				}
				SingleSessionFactory.closeFactory();
			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

	 
	}

	@Override
	public boolean readFlight(int Flightid) {
		Session session = null;
		try {
			SessionFactory sessionFactory = SingleSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
			System.out.println(flightDTO);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {
				if (Objects.nonNull(session)) {
					session.close();
					System.out.println("Session is closed");
				} else {
					System.out.println("Session not closed");
				}
				SingleSessionFactory.closeFactory();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

	@Override
	public boolean updateFlight(int Flightid) {
		Session session = null;
		try {
			SessionFactory sessionFactory = SingleSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
			flightDTO.setName("SpaceJet");
			Transaction transaction = session.beginTransaction();
			session.update(flightDTO);
			transaction.commit();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {

				if (Objects.nonNull(session)) {
					session.close();
					System.out.println("Session is closed");
				} else {
					System.out.println("Session not closed");
				}

				SingleSessionFactory.closeFactory();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

	@Override
	public boolean deleteFlight(int Flightid) {
		Session session = null;
		try {
			SessionFactory sessionFactory = SingleSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
			Transaction transaction = session.beginTransaction();
			session.delete(flightDTO);
			transaction.commit();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {
				if (Objects.nonNull(session)) {
					session.close();
					System.out.println("Session is closed");
				} else {
					System.out.println("Session not closed");
				}

				SingleSessionFactory.closeFactory();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

}
