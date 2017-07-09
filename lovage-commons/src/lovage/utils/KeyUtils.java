package lovage.utils;

import java.util.Collections;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

public class KeyUtils {

	/**
	 * Generates the next valid Long key for domain entities having Long as key.
	 * 
	 * @param keys
	 *            The collection of already existing keys
	 * @return The next valid Long
	 */
	public static Long nextLong(Set<Long> keys) {

		Long nextLong;
		if (CollectionUtils.isEmpty(keys)) {
			nextLong = 1L;
		} else {
			Long maxKey = Collections.max(keys);
			nextLong = maxKey + 1;
		}

		return nextLong;

	}

}
