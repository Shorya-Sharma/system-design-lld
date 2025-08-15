package examples.cricbuzz.ScoreUpdater;

import examples.cricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}
