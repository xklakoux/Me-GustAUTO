package es.uc3m.ctw.me_gustauto.ejb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Advertisement
 */
@Stateless
public class Advertisement implements AdvertisementRemote {

	@Override
	public List<Integer> getRandomIndexesForGeneralAds(int sizeOfList) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		LinkedList<Integer> indexes = new LinkedList<Integer>();
		for (int i=0; i<sizeOfList; i++) {
			indexes.add(i);
		}
		Collections.shuffle(indexes);
		for (int i=0; i<Math.min(5, sizeOfList); i++) {
			result.add(indexes.get(i));
		}
		return result;
	}

}
