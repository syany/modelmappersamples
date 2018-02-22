/*
 * ModelMapper Sample
 *
 * $Id: Convertion.java$
 */
package org.sample;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

/**
 * 転換テスト。<br>
 *
 * @since 2018/02/23
 * @author syany
 */
public class Convertion {

    private final ModelMapper modelMapper;

    private final Map<String, Object> srcMap = new HashMap<String, Object>() {
        {
            put("hoge", "AAA");
            put("fuga", new String[] {"BBB", "CCC"});
            put("aga", new String[] {"SSS", "KKK"});
            put("testDt", "2018-02-19");
            put("id", "2018");
        }
    };

    /**
     * コンストラクタ。<br>
     */
    public Convertion() {
        modelMapper = new ModelMapper();

        // String配列→Stringに転換するルール
        // 配列がnullでなければ、最初の要素を入れるようにする。
        Converter<String[], String> converter = new AbstractConverter<String[], String>() {
            @Override
            protected String convert(String[] source) {
                return (source != null && source.length > 0) ? source[0] : "";
            }
        };
        modelMapper.addConverter(converter);
    }

    /**
     * マッピング実施
     */
    public void exec() {

        System.out.println("srcMap -> ActForm");
        ActForm actForm = modelMapper.map(srcMap, ActForm.class);
        System.out.println(">>[結果] " + actForm.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Convertion().exec();
    }
}


class ActForm {
    private String hoge;
    private String fuga;
    private String[] aga;
    private Date testDt;
    private Integer id;
    /**
     * testDtを取得する。
     * @return testDtを返却
     */
    public final Date getTestDt() {
        return testDt;
    }
    /**
     * testDtを設定する。
     * @param testDt 設定対象のtestDt
     */
    public final void setTestDt(Date testDt) {
        this.testDt = testDt;
    }
    /**
     * idを取得する。
     * @return idを返却
     */
    public final Integer getId() {
        return id;
    }
    /**
     * idを設定する。
     * @param id 設定対象のid
     */
    public final void setId(Integer id) {
        this.id = id;
    }
    /**
     * agaを取得する。
     * @return agaを返却
     */
    public final String[] getAga() {
        return aga;
    }
    /**
     * agaを設定する。
     * @param aga 設定対象のaga
     */
    public final void setAga(String[] aga) {
        this.aga = aga;
    }
    /**
     * hogeを取得する。
     * @return hogeを返却
     */
    public final String getHoge() {
        return hoge;
    }
    /**
     * hogeを設定する。
     * @param hoge 設定対象のhoge
     */
    public final void setHoge(String hoge) {
        this.hoge = hoge;
    }
    /**
     * fugaを取得する。
     * @return fugaを返却
     */
    public final String getFuga() {
        return fuga;
    }
    /**
     * fugaを設定する。
     * @param fuga 設定対象のfuga
     */
    public final void setFuga(String fuga) {
        this.fuga = fuga;
    }
    /* (非 Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ActForm [hoge=" + hoge + ", fuga=" + fuga + ", aga=" + Arrays.toString(aga) + ", testDt=" + testDt
                + ", id=" + id + "]";
    }
}
