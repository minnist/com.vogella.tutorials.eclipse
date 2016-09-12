import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;

public class DateTimeSelectionProperty extends WidgetValueProperty {

	// this constant is used to correct the differences concerning the month counting
	private static final int MONTH_MAPPING_VALUE = 1;

	public DateTimeSelectionProperty() {
		super(SWT.Selection);
	}

	@Override
	public Object getValueType() {
		// use TemporalAccessor here, because it is the common interface for
		// LocalDate, LocalTime and LocalDateTime.
		return TemporalAccessor.class;
	}

	@Override
	protected Object doGetValue(Object source) {
		DateTime dateTime = (DateTime) source;

		// create LocalTime instance, if SWT.TIME is used,...
		if ((dateTime.getStyle() & SWT.TIME) != 0) {
			return LocalTime.of(dateTime.getHours(), dateTime.getMinutes(),
					dateTime.getSeconds());
		}

		// ... otherwise LocalDate
		return LocalDate.of(dateTime.getYear(), dateTime.getMonth()
				+ MONTH_MAPPING_VALUE, dateTime.getDay());
	}

	@Override
	protected void doSetValue(Object source, Object value) {
		DateTime dateTime = (DateTime) source;

		if (value == null)
			throw new IllegalArgumentException(
					"Cannot set null selection on DateTime"); 

		TemporalAccessor temporalAccessor = getTemporalAccessor(value);

		if (temporalAccessor == null)
			throw new IllegalArgumentException(
					"Cannot find TemporalAccessor for the given value"); 

		// set only hours, minutes and seconds in case the SWT.TIME flag is
		// set,...
		if ((dateTime.getStyle() & SWT.TIME) != 0) {
			dateTime.setTime(temporalAccessor.get(ChronoField.HOUR_OF_DAY),
					temporalAccessor.get(ChronoField.MINUTE_OF_HOUR),
					temporalAccessor.get(ChronoField.SECOND_OF_MINUTE));
		} else {
			// ... otherwise set year, month and day.
			dateTime.setDate(temporalAccessor.get(ChronoField.YEAR),
					temporalAccessor.get(ChronoField.MONTH_OF_YEAR)
							- MONTH_MAPPING_VALUE,
					temporalAccessor.get(ChronoField.DAY_OF_MONTH));
		}
	}

	// get TemporalAccessor from a Date, Calendar or TemporalAccessor object
	private TemporalAccessor getTemporalAccessor(Object value) {
		TemporalAccessor temporalAccessor = null;

		if (value instanceof Date) {
			temporalAccessor = LocalDateTime.from(((Date) value).toInstant());
		} else if (value instanceof TemporalAccessor) {
			temporalAccessor = (TemporalAccessor) value;
		} else if (value instanceof Calendar) {
			temporalAccessor = LocalDateTime.from(((Calendar) value)
					.toInstant());
		}
		return temporalAccessor;
	}

}
