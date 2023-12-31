package com.softwareengineering.personalhw;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MySoftReducer extends Reducer<Text, LongWritable,Text,LongWritable> {
    private LongWritable outV = new LongWritable();
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        Long sum = Long.valueOf(0);
        for (LongWritable value : values) {
            sum += value.get();
        }
        outV.set(sum);
        context.write(key,outV);
    }
}
