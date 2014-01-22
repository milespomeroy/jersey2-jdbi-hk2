package com.milespomeroy.jersey2jdbi2hk2;

import org.glassfish.hk2.api.DescriptorFileFinder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Finder implements DescriptorFileFinder
{
	private final ClassLoader classLoader;

	public Finder() {
		this.classLoader = Finder.class.getClassLoader();
	}

	@Override
	public List<InputStream> findDescriptorFiles() throws IOException
	{
		ArrayList<InputStream> returnList = new ArrayList<InputStream>();
		Enumeration<URL> e = classLoader.getResources("WEB-INF/classes/hk2-locator/default");

		for (; e.hasMoreElements();) {
			URL url = e.nextElement();
			returnList.add(url.openStream());
		}
		return returnList;
	}
}
