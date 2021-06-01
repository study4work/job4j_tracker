package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenProfilesStramToAdress() {
        Profiles pr = new Profiles();
        Address adress = new Address("Moscow", "Main", 42, 24);
        Profile profile = new Profile(adress);
        List<Profile> profiles = List.of(profile);
        List<Address> expected = List.of(adress);
        List<Address> rsl = pr.collect(profiles);
        assertThat(rsl, is(expected));

    }

}