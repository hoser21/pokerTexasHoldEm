package com.example.bellosil21.pokertexasholdem.Poker.Player;

import com.example.bellosil21.pokertexasholdem.Game.Game;
import com.example.bellosil21.pokertexasholdem.Game.GameComputerPlayer;
import com.example.bellosil21.pokertexasholdem.Game.GameMainActivity;
import com.example.bellosil21.pokertexasholdem.Game.GamePlayer;
import com.example.bellosil21.pokertexasholdem.Game.infoMsg.GameInfo;
import com.example.bellosil21.pokertexasholdem.Game.infoMsg.GameOverInfo;
import com.example.bellosil21.pokertexasholdem.Game.infoMsg.NotYourTurnInfo;
import com.example.bellosil21.pokertexasholdem.Poker.GameActions.PokerCall;
import com.example.bellosil21.pokertexasholdem.Poker.GameActions.PokerShowHideCards;
import com.example.bellosil21.pokertexasholdem.Poker.GameState.PokerGameState;

import java.util.logging.Handler;

/**
 * The "dumb" AI for Poker
 */
public class PokerDumbComputerPlayer extends GameComputerPlayer {

    protected Game game;
    protected GamePlayer player;
    protected String name;

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PokerDumbComputerPlayer(String name) {
        super(name);
    }

    /**
     * Updates the state of the other players and the game
     * @param info
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof NotYourTurnInfo){
            return;
        }
        if(info instanceof PokerGameState){
            if(Math.random() > 0.5){
                game.sendAction(new PokerShowHideCards(this));
            }
            else{
                game.sendAction(new PokerCall(this));
            }
        }
    }
}
