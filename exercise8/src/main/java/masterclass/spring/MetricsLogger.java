package masterclass.spring;

import masterclass.spring.domain.Author;
import masterclass.spring.domain.Book;
import masterclass.spring.domain.Publisher;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.SessionFactory;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class MetricsLogger {

	private static final Logger LOGGER = Logger.getLogger(MetricsLogger.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Pointcut("execution(* masterclass.spring.persistence.*.*(..))")
	public void databaseMethods() {
	}

	@Around("databaseMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		LOGGER.info(pjp.getSignature() + " method execution time: " + elapsedTime + " milliseconds.");
		LOGGER.info("******************************************");
		return output;
	}

	@After("databaseMethods()")
	public void logStats() {

		LOGGER.info("****** Query metrics ********");
		Statistics stats = sessionFactory.getStatistics();

		double queryCacheHitCount = stats.getQueryCacheHitCount();
		double queryCacheMissCount = stats.getQueryCacheMissCount();
		double queryCacheHitRatio = queryCacheHitCount
				/ (queryCacheHitCount + queryCacheMissCount);

		LOGGER.info("Query Hit ratio:" + queryCacheHitRatio);

		EntityStatistics bookStats = stats.getEntityStatistics(Book.class
				.getName());
		long bookChanges = bookStats.getInsertCount()
				+ bookStats.getUpdateCount() + bookStats.getDeleteCount();
		LOGGER
				.info(Book.class.getName() + " changed " + bookChanges
						+ " times");

		EntityStatistics authorStats = stats.getEntityStatistics(Author.class
				.getName());
		long authorChanges = authorStats.getInsertCount()
				+ authorStats.getUpdateCount() + authorStats.getDeleteCount();
		LOGGER.info(Author.class.getName() + " changed " + authorChanges
				+ " times");

		EntityStatistics pubStats = stats.getEntityStatistics(Publisher.class
				.getName());
		long pubChanges = pubStats.getInsertCount() + pubStats.getUpdateCount()
				+ pubStats.getDeleteCount();
		LOGGER.info(Publisher.class.getName() + " changed " + pubChanges
				+ " times");

	}

}
