package org.fnb.reservation;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterCodec implements Codec<DateTimeFormatter> {

    @Override
    public void encode(BsonWriter writer, DateTimeFormatter value, EncoderContext encoderContext) {
        writer.writeString(value.toString());
    }

    @Override
    public DateTimeFormatter decode(BsonReader reader, DecoderContext decoderContext) {
        return DateTimeFormatter.ofPattern(reader.readString());
    }

    @Override
    public Class<DateTimeFormatter> getEncoderClass() {
        return DateTimeFormatter.class;
    }
}
