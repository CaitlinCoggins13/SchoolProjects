package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import search.BasicDocumentReader.TextIDPair;

public class DocumentRelevance {
	private String documentFile;
	private BufferedReader in;
	private ArrayList<ArrayList<Integer>> docs;

	public DocumentRelevance(String documentFile){
		this.documentFile = documentFile;
		docs = new ArrayList<ArrayList<Integer>>();
		try{
			in = new BufferedReader(new FileReader(documentFile));
			readNextDocText(in);
			System.out.println(docs.toString());
		}catch(IOException e){
			throw new RuntimeException("Problems opening file: " + documentFile + "\n" + e.toString());
		}
	}
	
	public void readNextDocText(BufferedReader docIn)
	{
		String line = "";
		try {
			line = docIn.readLine();
			System.out.println(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(hasNext(line))
		{
			String[] split = line.split("\\s+");
			if(split[2].equals("1") || split[2].equals("2"))
			{
				int cell = Integer.parseInt(split[0]);
				int doc = Integer.parseInt(split[1]);
				while(docs.size()<cell)
					docs.add(new ArrayList<Integer>());
				docs.get(cell-1).add(doc);
			}
			
			try {
				line = docIn.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	public boolean hasNext(String line) {
		return line != null;
	}
	
	public int[] getRelevantDocs(int query)
	{
		//return (Integer[]) docs.get(query).toArray();
		return docs.get(query).stream().mapToInt(i->i).toArray();
	}
}
