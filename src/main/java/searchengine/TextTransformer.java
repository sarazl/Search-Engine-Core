package searchengine;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * uses Text Transformer methods to create Index from crawled pages
 * @author Parsa
 *
 */
public class TextTransformer implements IndexerInterface{
	
	PorterStemmer stemmer = new PorterStemmer();
	Map<String, Map<String, Integer>> docWordCountIndex = new HashMap<String, Map<String, Integer>>();
	TFIDF tfidf = new TFIDF();
	StopWords stopWords = new StopWords();
	
	/**
	 * runs stemming
	 * creates fwd Index and inverted index
	 */
	public void run() {
		stemDocWordCount();
		createFWDIndex();
		createInvertedIndex();	
	}
	
	/**
	 * creates word count from a given document and 
	 * uses NLP stemming and stopping algorithms from filterString() method
	 * to filter words and sentences
	 */
	public void stemDocWordCount() {
		for(Map.Entry<String, String> i : this.contentRepo.entrySet()) {
			List<String> content = Arrays.asList(filterString(i.getValue()).toLowerCase().split("\\s+"));
			Map<String, Integer> wordCount = new HashMap<String, Integer>();
			for(String s : content) {	  
				s = s.toLowerCase();
				if(!stemString(s).equals(""))
					wordCount.put(stemString(s), (wordCount.get(s)==null)? 1 : wordCount.get(s)+1);
			}
			docWordCountIndex.put(i.getKey(), wordCount);
		}
	}
	
	/**
	 * uses tfidf and docWordCountIndex created from stemDocWordCount() 
	 * to populate IndexerInterface fwdIndex
	 */
	public void createFWDIndex() {
		
	}
	
	/**
	 * uses fwdIndex and urlPageRank from IndexerInterface to
	 * populate invertedIndex from IndexerInterface
	 */
	public void createInvertedIndex() {
		
	}
	
	/**
	 * NLP stopping and stemming of String s 
	 * @param s
	 * @return
	 */
	public String filterString(String s) {
		
	}
	
	/**
	 * uses Porter Stemmer to Stem string s
	 * @param s
	 * @return
	 */
	public String stemSentence(String s) {
		
	}
	
	/**
	 * @param s
	 * @return
	 */
	public String stemString(String s) {
		
	}
	
	/**
	 * gets pure URL (protocol://hostname/) from a given url string
	 * @param url
	 * @return
	 */
	public String getUrlHost(String url) {
		try {
			URL myUrl = new URL(url);
			return myUrl.getProtocol()+"://"+myUrl.getHost()+"/";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
