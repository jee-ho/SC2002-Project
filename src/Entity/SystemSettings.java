package Entity;

import java.io.Serializable;

/**
 * This SystemSettings class contains saved toggles for admin settings.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-10
 */
public class SystemSettings implements Serializable {
	private int MovieDisplayToggle = 0;		//0 sets top movie listing by sales, 1 sets top movie listing by reviews

	public SystemSettings() {
		MovieDisplayToggle = 0;
	}

	public int getMovieDisplayToggle() {
		return MovieDisplayToggle;
	}

	public void setMovieDisplayToggle(int movieDisplayToggle) {
		MovieDisplayToggle = movieDisplayToggle;
	}
}
