package search;

/**
 * This class is used to evaluate the ranked results from a search engine
 * 
 * @author dkauchak
 *
 */
public class Evaluator {
	/** 
	 * Calculate recall at k.
	 * 
	 * @param relevantIDs the list of relevant ids for this query (may be in any order)
	 * @param returnedIDs the list of IDs returned from the system in order
	 * @param k
	 * @return Returns the recall at k
	 */
	public static double recall(int[] relevantIDs, int[] returnedIDs, int k){
		int found = 0;
		
		if(relevantIDs.length==0)
		{
			return 1;
		}
		
		for(int i=0; i<k; ++i)
		{
			for(int j=0; j<relevantIDs.length; ++j)
			{
				if(returnedIDs[i] == relevantIDs[j])
				{
					found++;
					//break;
				}
			}
		}
		return (double)found/(double)relevantIDs.length;
	}
	
	/** 
	 * Calculate precision at k.
	 * 
	 * @param relevantIDs the list of relevant ids for this query (may be in any order)
	 * @param returnedIDs the list of IDs returned from the system in order
	 * @param k
	 * @return Returns the precision at k
	 */
	public static double precision(int[] relevantIDs, int[] returnedIDs, int k){
		int found = 0;
		
		if(relevantIDs.length==0)
		{
			return 0;
		}
		
		for(int i=0; i<k; ++i)
		{
			for(int j=0; j<relevantIDs.length; ++j)
			{
				if(returnedIDs[i] == relevantIDs[j])
				{
					found++;
					//break;
				}
			}
		}
		return (double)found/(double)k;
	}

	/** 
	 * Calculate R-Precision
	 * 
	 * @param relevantIDs the list of relevant ids for this query (may be in any order)
	 * @param returnedIDs the list of IDs returned from the system in order
	 * @return Returns the R-Precision
	 */
	public static double rPrecision(int[] relevantIDs, int[] returnedIDs){
		int found = 0;
		
		if(relevantIDs.length>returnedIDs.length || relevantIDs.length == 0){
			return 0.0;
		}
		
		for(int i=0; i<relevantIDs.length; ++i)
		{
			for(int j=0; j<relevantIDs.length; ++j)
			{
				if(returnedIDs[i] == relevantIDs[j])
				{
					found++;
					//break;
				}
			}
		}
		return (double)found/(double)relevantIDs.length;
	}
	
	/** 
	 * Calculate MAP
	 * 
	 * @param relevantIDs the list of relevant ids for this query (may be in any order)
	 * @param returnedIDs the list of IDs returned from the system in order
	 * @return Returns the MAP
	 */
	public static double map(int[] relevantIDs, int[] returnedIDs){
		double precisionSum = 0.0;
		double countDocs = 0.0;
		for(int i=0; i<returnedIDs.length; ++i)
		{
			for(int j=0; j<relevantIDs.length; ++j)
			{
				if(returnedIDs[i] == relevantIDs[j])
				{
					double newValue = (countDocs+1.0)/(double)(i+1);
					precisionSum = precisionSum + newValue;
					countDocs++;
				}
			}
		}
		
		if(countDocs == 0.0)
			return 0.0;
		return precisionSum/countDocs;
	}
}
