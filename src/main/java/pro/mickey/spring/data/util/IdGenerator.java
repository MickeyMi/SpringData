package pro.mickey.spring.data.util;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {
	public String id;

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Number number = new MickeySnowflake(123).generateKey();
		long idLong = number.longValue();
		return idLong;
	}

}