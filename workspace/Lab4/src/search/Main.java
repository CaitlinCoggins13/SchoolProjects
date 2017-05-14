package search;

import java.io.File;
import java.io.IOException;

import search.Index.DOC_MODIFIER;
import search.Index.LENGTH_MODIFIER;
import search.Index.TERM_MODIFIER;

public class Main {
	public static void main(String[] args) 
	{
		DocumentRelevance relevance = new DocumentRelevance("./src/data/cranfield.query.relevance");
		CranfieldReader cran = new CranfieldReader("./src/data/cranfield.documents");
		cran.setTokenizer(new ImprovedTokenizer());
		//TokenProcessor process = new TokenProcessor();
		//process.setStem(true);
		//process.setFoldNumbers(true);
		//cran.setTokenProcessor(process);
		Index index = new Index(cran, TERM_MODIFIER.n, DOC_MODIFIER.t, LENGTH_MODIFIER.c);
		BasicQueryReader read = new BasicQueryReader("./src/data/cranfield.queries");
		read.setTokenizer(new ImprovedTokenizer());
		
		int i=0;
		
		double precision = 0.0;
		double recall = 0.0;
		double rPrecision = 0.0;
		double map = 0.0;
		
		while(read.hasNext())
		{
			Query query = read.next();
			VectorResult results = index.rankedQuery(query);
		
			int[] returnedIDs = results.getIDs();
			int[] relevantIDs = relevance.getRelevantDocs(i);
			
			precision += Evaluator.precision(relevantIDs, returnedIDs, 50);
			recall += Evaluator.recall(relevantIDs, returnedIDs, 50);
			rPrecision += Evaluator.rPrecision(relevantIDs, returnedIDs);
			map += Evaluator.map(relevantIDs, returnedIDs);
			++i;
		}
		if(i==0)
		{
			System.out.println("zero");
			System.out.println("precision " + precision);
			System.out.println("recall " + recall);
			System.out.println("rprecision " + rPrecision);
			System.out.println("map " + map);
		}
		else{
			
			System.out.println("precision " + precision/(double)i);
		System.out.println("recall " + recall/(double)i);
		System.out.println("rprecision " + rPrecision/(double)i);
		System.out.println("map " + map/(double)i);
		
		}
		
		
	}
}
