package es.uc3m.ctw.me_gustauto.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AdvertisementRemote {
	public List<Integer> getRandomIndexesForGeneralAds(int sizeOfList);
}
