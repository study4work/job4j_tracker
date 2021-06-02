package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenProfilesStreamToAdress() {
        Profiles pr = new Profiles();
        Address adress = new Address("Moscow", "Main", 42, 24);
        Profile profile = new Profile(adress);
        List<Profile> profiles = List.of(profile);
        List<Address> expected = List.of(adress);
        List<Address> rsl = pr.collect(profiles);
        assertThat(rsl, is(expected));

    }

    @Test
    public void whenAdressStramToDistinct() {
        Profiles pr = new Profiles();
        Address adress = new Address("Moscow", "Main", 44, 24);
        Address adress1 = new Address("Washington", "Ma", 43, 24);
        Address adress2 = new Address("Texas", "Mai", 41, 24);
        Address adress3 = new Address("Moscow", "Main", 40, 24);
        List<Address> addresses = new ArrayList<>();
        addresses.add(adress);
        addresses.add(adress1);
        addresses.add(adress2);
        addresses.add(adress3);
        List<Address> expected = List.of(adress, adress2, adress1);
        List<Address> rsl = pr.cut(addresses);
        assertThat(rsl, is(expected));

    }
}