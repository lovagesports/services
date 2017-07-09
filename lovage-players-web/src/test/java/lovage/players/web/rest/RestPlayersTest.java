package lovage.players.web.rest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import lovage.domain.Player;
import lovage.players.service.IPlayersService;

public class RestPlayersTest {

	private final RestPlayers rest = new RestPlayers();

	@Test
	public void testCreatePlayer_WhenNull_ThenUnsuccessful() {
		Player player = null;
		Boolean success = rest.create(player);
		Assert.assertFalse(success);
	}

	@Test
	public void testCreatePlayer_WhenInvalid_ThenUnsuccessful() {
		IPlayersService mockService = Mockito.mock(IPlayersService.class);
		Whitebox.setInternalState(rest, "service", mockService);

		Player player = Mockito.mock(Player.class);
		Mockito.when(mockService.validate(player)).thenReturn(Boolean.FALSE);

		Boolean success = rest.create(player);
		Assert.assertFalse(success);
	}

	@Test
	public void testCreatePlayer_WhenCreationFailed_ThenUnsuccessful() {
		IPlayersService mockService = Mockito.mock(IPlayersService.class);
		Whitebox.setInternalState(rest, "service", mockService);

		Player player = Mockito.mock(Player.class);
		Mockito.when(mockService.validate(player)).thenReturn(Boolean.TRUE);
		Mockito.when(mockService.create(player)).thenReturn(Boolean.FALSE);

		Boolean success = rest.create(player);
		Assert.assertFalse(success);
	}

	@Test
	public void testCreatePlayer_WhenCreationSuccess_ThenSuccessful() {
		IPlayersService mockService = Mockito.mock(IPlayersService.class);
		Whitebox.setInternalState(rest, "service", mockService);

		Player player = Mockito.mock(Player.class);
		Mockito.when(mockService.validate(player)).thenReturn(Boolean.TRUE);
		Mockito.when(mockService.create(player)).thenReturn(Boolean.TRUE);

		Boolean success = rest.create(player);
		Assert.assertTrue(success);
	}
}
