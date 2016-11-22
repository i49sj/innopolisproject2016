package ru.innopolis.cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.List;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;

/**
 * Created by innopolis on 22.11.16.
 */
@Configuration
public class SpringIgniteRun {
    public static void main(String[] args) throws Exception{


        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        Ignition.setClientMode(true);

        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setPeerClassLoadingEnabled(true);
        cacheConfiguration.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        Ignite ignite = Ignition.start(igniteConfiguration);
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

            for (int i = 0; i < 10; i++)
                cache.put(i, Integer.toString(i));

            for (int i = 0; i < 10; i++)
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
        }
    }
