package fr.lille.alom;

import fr.lille.alom.server.Server;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ServletFactory.getInstance().registerServlet("Helloworld",new HelloWorldServlet());
        Server server = new Server();
        server.run();
    }
}
