package lovage.players.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import lovage.domain.Player;

public class PlayersServiceTest {

	private final PlayersServiceImpl service = Mockito.spy(new PlayersServiceImpl());

	@Test
	public void testValidate_WhenNameEmpty_ThenUnsuccessful() {
		Player player = new Player();
		Boolean success = service.validate(player);

		Assert.assertFalse(success);
	}

	@Test
	public void testValidate_WhenEmailEmpty_ThenUnsuccessful() {
		Player player = new Player();
		player.name = "test";
		Boolean success = service.validate(player);

		Assert.assertFalse(success);
	}

	@Test
	public void testValidate_WhenPasswordEmpty_ThenUnsuccessful() {
		Player player = new Player();
		player.name = "test";
		player.email = "test";
		Boolean success = service.validate(player);

		Assert.assertFalse(success);
	}

	@Test
	public void testValidate_WhenBirthEmpty_ThenUnsuccessful() {
		Player player = new Player();
		player.name = "test";
		player.email = "test";
		player.password = "test";
		Boolean success = service.validate(player);

		Assert.assertFalse(success);
	}

	@Test
	public void testValidate_WhenComplete_ThenSuccessful() {
		Player player = new Player();
		player.name = "test";
		player.email = "test";
		player.password = "test";
		player.birth = "test";
		Boolean success = service.validate(player);

		Assert.assertTrue(success);
	}

	@Test
	public void testLogin_WhenIncorrectEmail_ThenUnsuccessful() {
		Player player = new Player();
		player.name = "test";
		player.email = "test";
		player.password = "test";
		player.birth = "test";

		Mockito.when(service.getPlayer("test")).thenReturn(null);
		Player login = service.login(player);

		Assert.assertNull(login);
	}

	@Test
	public void testLogin_WhenIncorrectPassword_ThenUnsuccessful() {
		Player player = new Player();
		player.name = "test";
		player.email = "test";
		player.password = "test";
		player.birth = "test";

		Player mockLogin = new Player();
		mockLogin.password = "test2";

		Mockito.when(service.getPlayer("test")).thenReturn(mockLogin);
		Player login = service.login(player);

		Assert.assertNull(login);
	}

	@Test
	public void testLogin_WhenCorrect_ThenSuccessful() {
		Player player = new Player();
		player.name = "test";
		player.email = "test";
		player.password = "test";
		player.birth = "test";

		Player mockLogin = new Player();
		mockLogin.password = "test";

		Mockito.when(service.getPlayer("test")).thenReturn(mockLogin);
		Player login = service.login(player);

		Assert.assertEquals(login, mockLogin);
	}
}
