package org.phw.hbaser.valuetype;

import org.apache.hadoop.hbase.util.Bytes;
import org.phw.core.lang.Converts;

public class IntValue implements ValueTypable, MatchAware {

    @Override
    public String toStr(byte[] value) {
        return "" + Bytes.toInt(value);
    }

    @Override
    public byte[] toBytes(String value) {
        return Bytes.toBytes(Integer.valueOf(value));
    }

    @Override
    public boolean needQuoted() {
        return false;
    }

    @Override
    public boolean needEsacaping() {
        return false;
    }

    @Override
    public int getValueLength() {
        return Bytes.SIZEOF_INT;
    }

    @Override
    public boolean match(byte[] value, int offset) {
        return true;
    }

    @Override
    public boolean match(String value) {
        return Converts.convert(value, int.class) != null;
    }
}
