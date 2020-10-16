import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException, ScriptException {
        //String
     String string = " Java 11! ";

     System.out.println(string.repeat(3));
     System.out.println(string.isBlank());

     //strip() is Unicode whitespace aware,
        // whereas the existing method trim() removes any space which is less than or equal to (\u0020).

        String s = "test string\u205F";

        System.out.println(s.strip());
        System.out.println(s.trim());

        //http client from java.net package

        HttpClient client= HttpClient.newBuilder().build();
        HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create("https://www.google.com/"))
                .build();
        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


        //Unicode 10 support

        System.out.println("\u20BF");


        //javascriptEngine..nashorn will be deprecated in future
        ScriptEngine engine= new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('see message below')");

        //Use java Test.java to run this instead of using complier
    }
}
