package renukakamathacademy.data;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

public class Data {
	public List<HashMap<String, String>> DataMethod(String file) throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = FileUtils.readFileToString(new File(file));
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>> () {});
		return data;
	}
}
