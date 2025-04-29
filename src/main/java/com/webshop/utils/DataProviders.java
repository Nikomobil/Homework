package com.webshop.utils;

import com.webshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> validRegistrationFromDataProvider() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"gender-male", "Fi1Name", "LastName", "Email1t@gmail.net",
                "12523Sdf!"});
        list.add(new Object[]{"gender-female", "FirsName1", "LastName1", "Email2r@gmail.net",
                "12523Sdf!"});
        list.add(new Object[]{"gender-female", "Fst3Name2", "LastName", "Email3r@gmail.net",
                "12523Sdf!"});

        return list.iterator();

    }
    @DataProvider
    public Iterator <Object[]> validRegistrationFromDataProviderCsvFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contactdata.csv")));

        String line = reader.readLine();
        while (line != null) {


            String[] split = line.split(",");

            list.add(new Object[]{new User()
                    .setGender(split[0]).setFirstName(split[1]).setLastName(split[2])
                    .setEmail(split[3]).setPassword(split[4])});

            line = reader.readLine();
        }
        return list.iterator();
    }


}
