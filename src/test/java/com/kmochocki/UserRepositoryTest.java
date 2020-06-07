package com.kmochocki;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserRepositoryTest {

    @Test
    public void shouldReturnUserWithProvidedName() {
        String imie = "Kokos";
        UserRepository repository = new UserRepository();
        Optional<User> nonExistingUser = repository.findUserByName(imie);
        assertThat(nonExistingUser).isNotPresent();

        repository.createUser(imie);
        Optional<User> user = repository.findUserByName(imie);

//        assertThat(user).isNotNull().extracting(User::getImie).isNotNull().isEqualTo(imie);
        assertThat(user.map(User::getImie).orElse(null)).isNotNull().isEqualTo(imie);
    }

    @Test
    public void shouldThrowExceptionWhenImieIsNull() {
        String imie = null;

        ThrowableAssert.ThrowingCallable action = () -> new UserRepository().createUser(imie);

        assertThatThrownBy(action).isInstanceOf(RepositoryException.class).
                hasMessage("Imie nie moze byc krotsze jak 3 znaki");
    }

    @Test
    public void shouldThrowExceptionWhenImieLengthIsLowerThanThree() {
        String imie = "ab";

        ThrowableAssert.ThrowingCallable action = () -> new UserRepository().createUser(imie);

        assertThatThrownBy(action).isInstanceOf(RepositoryException.class)
                .hasMessage("Imie nie moze byc krotsze jak 3 znaki");
    }

    @Test
    public void shouldEditUser() {
        String imie = "Marmolada";
        UserRepository repository = new UserRepository();
        repository.createUser(imie);
        User originalUser = repository.findUserByName(imie).get();

        User changedUser = new User(originalUser.getId(), "Marmolada_zmieniona");
        repository.modifyUser(changedUser);

        assertThat(repository.findUserByName(originalUser.getImie())).isNotPresent();
        Optional<User> repositoryVersion = repository.findUserByName(changedUser.getImie());
        assertThat(repositoryVersion).isPresent();
        assertThat(repositoryVersion.get().getId()).isEqualTo(originalUser.getId());
        assertThat(repositoryVersion.get().getImie()).isNotEqualTo(originalUser.getImie());
    }
}