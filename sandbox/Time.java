public record Time(int m, int s) {
	public Time {
		if (s >= 60) {

			int M = s / 60;
			m += M;
			s -= M * 60;
		}
	}
}
