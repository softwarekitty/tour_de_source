package metric;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FeatureDictionary {

	HashMap<String, Integer> nameToIntMap;
	HashMap<Integer, String> intToNameMap;
	HashMap<Integer, String> intToCodeMap;
	HashMap<Integer, String> intToDescMap;

	public FeatureDictionary() {
		initializeNameToIntMap();
		initializeIntToNameMap();
		initializeIntToCodeMap();
		initializeIntToDescMap();
	}

	public String getCode(int index) {
		return intToCodeMap.get(index);
	}
	
	public String getName(int index) {
		return intToNameMap.get(index);
	}

	public int getIndex(String name) {
		Integer index = nameToIntMap.get(name);
		return index==null? -1:index;
	}

	public int getSize() {
		return intToNameMap.size();
	}
	
	public List<String> getRepetitionTokens() {
		return Arrays.asList(REP_ADDITIONAL,REP_DOUBLEBOUNDED,REP_KLEENISH,REP_LOWERBOUNDED,REP_QUESTIONABLE,REP_SINGLEEXACTLY);
	}

	private void initializeNameToIntMap() {
		nameToIntMap = new HashMap<String,Integer>(32);
		nameToIntMap.put(CC_DECIMAL,I_CC_DECIMAL);
		nameToIntMap.put(CC_NDECIMAL,I_CC_NDECIMAL);
		nameToIntMap.put(CC_NWHITESPACE,I_CC_NWHITESPACE);
		nameToIntMap.put(CC_NWORD,I_CC_NWORD);
		nameToIntMap.put(CC_RANGE,I_CC_RANGE);
		nameToIntMap.put(CC_WHITESPACE,I_CC_WHITESPACE);
		nameToIntMap.put(CC_WORD,I_CC_WORD);

		nameToIntMap.put(LOOK_AHEAD,I_LOOK_AHEAD);
		nameToIntMap.put(LOOK_AHEAD_NEGATIVE,I_LOOK_AHEAD_NEGATIVE);
		nameToIntMap.put(LOOK_BEHIND,I_LOOK_BEHIND);
		nameToIntMap.put(LOOK_BEHIND_NEGATIVE,I_LOOK_BEHIND_NEGATIVE);
		nameToIntMap.put(LOOK_NON_CAPTURE,I_LOOK_NON_CAPTURE);
		
		nameToIntMap.put(META_CC,I_META_CC);
		nameToIntMap.put(META_CAPTURING_GROUP,I_META_CAPTURING_GROUP);
		nameToIntMap.put(META_DOT_ANY,I_META_DOT_ANY);
		nameToIntMap.put(META_LITERAL,I_META_LITERAL);
		nameToIntMap.put(META_NCC,I_META_NCC);
		nameToIntMap.put(META_NUMBERED_BACKREFERENCE,I_META_NUMBERED_BACKREFERENCE);
		nameToIntMap.put(META_OR,I_META_OR);
		
		nameToIntMap.put(POS_END_ANCHOR,I_POS_END_ANCHOR);
		nameToIntMap.put(POS_NONWORD,I_POS_NONWORD);
		nameToIntMap.put(POS_START_ANCHOR,I_POS_START_ANCHOR);
		nameToIntMap.put(POS_WORD,I_POS_WORD);
		
		nameToIntMap.put(REP_ADDITIONAL,I_REP_ADDITIONAL);
		nameToIntMap.put(REP_DOUBLEBOUNDED,I_REP_DOUBLEBOUNDED);
		nameToIntMap.put(REP_KLEENISH,I_REP_KLEENISH);
		nameToIntMap.put(REP_LOWERBOUNDED,I_REP_LOWERBOUNDED);
		nameToIntMap.put(REP_QUESTIONABLE,I_REP_QUESTIONABLE);
		nameToIntMap.put(REP_SINGLEEXACTLY,I_REP_SINGLEEXACTLY);
		nameToIntMap.put(REP_ADDITIONAL_LAZY,I_REP_ADDITIONAL_LAZY);
		nameToIntMap.put(REP_DOUBLEBOUNDED_LAZY,I_REP_DOUBLEBOUNDED_LAZY);
		nameToIntMap.put(REP_KLEENISH_LAZY,I_REP_KLEENISH_LAZY);
		nameToIntMap.put(REP_LOWERBOUNDED_LAZY,I_REP_LOWERBOUNDED_LAZY);
		nameToIntMap.put(REP_QUESTIONABLE_LAZY,I_REP_QUESTIONABLE_LAZY);
		nameToIntMap.put(REP_SINGLEEXACTLY_LAZY,I_REP_SINGLEEXACTLY_LAZY);
	}

	private void initializeIntToNameMap() {
		intToNameMap = new HashMap<Integer,String>(32);		
		intToNameMap.put(I_CC_DECIMAL,CC_DECIMAL);
		intToNameMap.put(I_CC_NDECIMAL,CC_NDECIMAL);
		intToNameMap.put(I_CC_NWHITESPACE,CC_NWHITESPACE);
		intToNameMap.put(I_CC_NWORD,CC_NWORD);
		intToNameMap.put(I_CC_RANGE,CC_RANGE);
		intToNameMap.put(I_CC_WHITESPACE,CC_WHITESPACE);
		intToNameMap.put(I_CC_WORD,CC_WORD);

		intToNameMap.put(I_LOOK_AHEAD,LOOK_AHEAD);
		intToNameMap.put(I_LOOK_AHEAD_NEGATIVE,LOOK_AHEAD_NEGATIVE);
		intToNameMap.put(I_LOOK_BEHIND,LOOK_BEHIND);
		intToNameMap.put(I_LOOK_BEHIND_NEGATIVE,LOOK_BEHIND_NEGATIVE);
		intToNameMap.put(I_LOOK_NON_CAPTURE,LOOK_NON_CAPTURE);
		
		intToNameMap.put(I_META_CC,META_CC);
		intToNameMap.put(I_META_CAPTURING_GROUP,META_CAPTURING_GROUP);
		intToNameMap.put(I_META_DOT_ANY,META_DOT_ANY);
		intToNameMap.put(I_META_LITERAL,META_LITERAL);
		intToNameMap.put(I_META_NCC,META_NCC);
		intToNameMap.put(I_META_NUMBERED_BACKREFERENCE,META_NUMBERED_BACKREFERENCE);
		intToNameMap.put(I_META_OR,META_OR);
		
		intToNameMap.put(I_POS_END_ANCHOR,POS_END_ANCHOR);
		intToNameMap.put(I_POS_NONWORD,POS_NONWORD);
		intToNameMap.put(I_POS_START_ANCHOR,POS_START_ANCHOR);
		intToNameMap.put(I_POS_WORD,POS_WORD);
		
		intToNameMap.put(I_REP_ADDITIONAL,REP_ADDITIONAL);
		intToNameMap.put(I_REP_DOUBLEBOUNDED,REP_DOUBLEBOUNDED);
		intToNameMap.put(I_REP_KLEENISH,REP_KLEENISH);
		intToNameMap.put(I_REP_LOWERBOUNDED,REP_LOWERBOUNDED);
		intToNameMap.put(I_REP_QUESTIONABLE,REP_QUESTIONABLE);
		intToNameMap.put(I_REP_SINGLEEXACTLY,REP_SINGLEEXACTLY);
		intToNameMap.put(I_REP_ADDITIONAL_LAZY,REP_ADDITIONAL_LAZY);
		intToNameMap.put(I_REP_DOUBLEBOUNDED_LAZY,REP_DOUBLEBOUNDED_LAZY);
		intToNameMap.put(I_REP_KLEENISH_LAZY,REP_KLEENISH_LAZY);
		intToNameMap.put(I_REP_LOWERBOUNDED_LAZY,REP_LOWERBOUNDED_LAZY);
		intToNameMap.put(I_REP_QUESTIONABLE_LAZY,REP_QUESTIONABLE_LAZY);
		intToNameMap.put(I_REP_SINGLEEXACTLY_LAZY,REP_SINGLEEXACTLY_LAZY);
	}
	

	private void initializeIntToDescMap() {
		intToDescMap = new HashMap<Integer,String>(32);	
		intToDescMap.put(I_CC_DECIMAL,"any of: 0123456789");
		intToDescMap.put(I_CC_NDECIMAL,"any non-decimal character");
		intToDescMap.put(I_CC_NWHITESPACE,"any non-whitespace");
		intToDescMap.put(I_CC_NWORD,"any non-word character");
		intToDescMap.put(I_CC_RANGE,"for example a-z is all lowercase letters");
		intToDescMap.put(I_CC_WHITESPACE,"tab, newline, return, vertical-tab space or form-feed");
		intToDescMap.put(I_CC_WORD,"upper and lowercase letters, underscore and digits");

		intToDescMap.put(I_LOOK_AHEAD,"require a matching sequence to the right");
		intToDescMap.put(I_LOOK_AHEAD_NEGATIVE,"reject if there is a matching sequence to the right");
		intToDescMap.put(I_LOOK_BEHIND,"require a matching sequence to the left");
		intToDescMap.put(I_LOOK_BEHIND_NEGATIVE,"reject if there is a matching sequence to the left");
		intToDescMap.put(I_LOOK_NON_CAPTURE,"require this sequence but do not capture it");
		
		intToDescMap.put(I_META_CC,"a custom character class");
		intToDescMap.put(I_META_CAPTURING_GROUP,"a capture group / logical grouping");
		intToDescMap.put(I_META_DOT_ANY,"a character class matching everything but newline");
		intToDescMap.put(I_META_LITERAL,"a literal character");
		intToDescMap.put(I_META_NCC,"a negated custom character class");
		intToDescMap.put(I_META_NUMBERED_BACKREFERENCE,"require what was captured by the ith capture group");
		intToDescMap.put(I_META_OR,"logical or");
		
		intToDescMap.put(I_POS_END_ANCHOR,"match the end of the string");
		intToDescMap.put(I_POS_NONWORD,"negated word/non-word boundary");
		intToDescMap.put(I_POS_START_ANCHOR,"match the start of the string");
		intToDescMap.put(I_POS_WORD,"word/non-word boundary");
		
		intToDescMap.put(I_REP_ADDITIONAL,"one-or-more repetition");
		intToDescMap.put(I_REP_DOUBLEBOUNDED,"at least n, at most m repetition");
		intToDescMap.put(I_REP_KLEENISH,"zero-or-more repetition");
		intToDescMap.put(I_REP_LOWERBOUNDED,"at least n repetition");
		intToDescMap.put(I_REP_QUESTIONABLE,"zero-or-one repetition");
		intToDescMap.put(I_REP_SINGLEEXACTLY,"exactly n repetition");
		intToDescMap.put(I_REP_ADDITIONAL_LAZY,"lazy one-or-more repetition");
		intToDescMap.put(I_REP_DOUBLEBOUNDED_LAZY,"lazy at least n, at most m repetition");
		intToDescMap.put(I_REP_KLEENISH_LAZY,"lazy zero-or-more repetition");
		intToDescMap.put(I_REP_LOWERBOUNDED_LAZY,"lazy at least n repetition");
		intToDescMap.put(I_REP_QUESTIONABLE_LAZY,"lazy zero-or-one repetition");
		intToDescMap.put(I_REP_SINGLEEXACTLY_LAZY,"lazy exactly n repetition");
	}
	

	private void initializeIntToCodeMap() {
		intToCodeMap = new HashMap<Integer,String>(32);		
		intToCodeMap.put(I_CC_DECIMAL,"DEC");
		intToCodeMap.put(I_CC_NDECIMAL,"NDEC");
		intToCodeMap.put(I_CC_NWHITESPACE,"NWSP");
		intToCodeMap.put(I_CC_NWORD,"NWRD");
		intToCodeMap.put(I_CC_RANGE,"RNG");
		intToCodeMap.put(I_CC_WHITESPACE,"WSP");
		intToCodeMap.put(I_CC_WORD,"WRD");

		intToCodeMap.put(I_LOOK_AHEAD,"LKA");
		intToCodeMap.put(I_LOOK_AHEAD_NEGATIVE,"NLKA");
		intToCodeMap.put(I_LOOK_BEHIND,"LKB");
		intToCodeMap.put(I_LOOK_BEHIND_NEGATIVE,"NLKB");
		intToCodeMap.put(I_LOOK_NON_CAPTURE,"NCG");
		
		intToCodeMap.put(I_META_CC,"CCC");
		intToCodeMap.put(I_META_CAPTURING_GROUP,"CG");
		intToCodeMap.put(I_META_DOT_ANY,"ANY");
		intToCodeMap.put(I_META_LITERAL,"LIT");
		intToCodeMap.put(I_META_NCC,"NCCC");
		intToCodeMap.put(I_META_NUMBERED_BACKREFERENCE,"BKR");
		intToCodeMap.put(I_META_OR,"OR");
		
		intToCodeMap.put(I_POS_END_ANCHOR,"END");
		intToCodeMap.put(I_POS_NONWORD,"NWNW");
		intToCodeMap.put(I_POS_START_ANCHOR,"STR");
		intToCodeMap.put(I_POS_WORD,"WNW");
		
		intToCodeMap.put(I_REP_ADDITIONAL,"ADD");
		intToCodeMap.put(I_REP_DOUBLEBOUNDED,"DBB");
		intToCodeMap.put(I_REP_KLEENISH,"KLE");
		intToCodeMap.put(I_REP_LOWERBOUNDED,"LWB");
		intToCodeMap.put(I_REP_QUESTIONABLE,"QST");
		intToCodeMap.put(I_REP_SINGLEEXACTLY,"SNG");
		intToCodeMap.put(I_REP_ADDITIONAL_LAZY,"ADDL");
		intToCodeMap.put(I_REP_DOUBLEBOUNDED_LAZY,"DBBL");
		intToCodeMap.put(I_REP_KLEENISH_LAZY,"KLEL");
		intToCodeMap.put(I_REP_LOWERBOUNDED_LAZY,"LWBL");
		intToCodeMap.put(I_REP_QUESTIONABLE_LAZY,"QSTL");
		intToCodeMap.put(I_REP_SINGLEEXACTLY_LAZY,"SNGL");
	}

	public static final String ELEMENT = "ELEMENT";
	public static final String ALTERNATIVE = "ALTERNATIVE";
	public static final String GREEDY = "GREEDY";
	public static final String LAZY = "LAZY";
	public static final String NUMBER = "NUMBER";
	public static final String QUANTIFIER = "QUANTIFIER";

	//: /d
	public static final String CC_DECIMAL = "DecimalDigit";
	//: /D
	public static final String CC_NDECIMAL = "NotDecimalDigit";
	//: /S
	public static final String CC_NWHITESPACE = "NotWhiteSpace";
	//: /W
	public static final String CC_NWORD = "NotWordChar";
	//: [a-z] or maybe [3-7]
	public static final String CC_RANGE = "RANGE";
	//: /s
	public static final String CC_WHITESPACE = "WhiteSpace";
	//: /w
	public static final String CC_WORD = "WordChar";

	//: (?=...)
	public static final String LOOK_AHEAD = "LOOK_AHEAD";
	//: (?!...)
	public static final String LOOK_AHEAD_NEGATIVE = "NEGATIVE_LOOK_AHEAD";
	//: (?<=...)
	public static final String LOOK_BEHIND = "LOOK_BEHIND";
	//: (?<!...)
	public static final String LOOK_BEHIND_NEGATIVE = "NEGATIVE_LOOK_BEHIND";
	//: (?:...)
	public static final String LOOK_NON_CAPTURE = "NON_CAPTURING_GROUP";

	//: [...]
	public static final String META_CC = "CHARACTER_CLASS";
	//: (...)
	public static final String META_CAPTURING_GROUP = "CAPTURING_GROUP";
	//: .
	public static final String META_DOT_ANY = "ANY";
	//: ...
	public static final String META_LITERAL = "LITERAL";
	//: [^...]
	public static final String META_NCC = "NEGATED_CHARACTER_CLASS";
	//: \1
	public static final String META_NUMBERED_BACKREFERENCE = "NUMBERED_BACKREFERENCE";
	//: |
	public static final String META_OR = "OR";

	//: $
	public static final String POS_END_ANCHOR = "EndOfSubjectOrLine";
	//: \B
	public static final String POS_NONWORD = "NonWordBoundary";
	//: ^
	public static final String POS_START_ANCHOR = "START_OF_SUBJECT";
	//: \b
	public static final String POS_WORD = "WordBoundary";
	
	
	//: +
	public static final String REP_ADDITIONAL = "ADDITIONAL";
	//: {n,m}
	public static final String REP_DOUBLEBOUNDED = "DOUBLEBOUNDED";
	//: *
	public static final String REP_KLEENISH = "KLEENISH";
	//: {n,}
	public static final String REP_LOWERBOUNDED = "LOWERBOUNDED";
	//: ?
	public static final String REP_QUESTIONABLE = "QUESTIONABLE";
	//: {n}
	public static final String REP_SINGLEEXACTLY = "SINGLEEXACTLY";
	
	//: +?
	public static final String REP_ADDITIONAL_LAZY = "ADDITIONAL_LAZY";
	//: {n,m}?
	public static final String REP_DOUBLEBOUNDED_LAZY = "DOUBLEBOUNDED_LAZY";
	//: *?
	public static final String REP_KLEENISH_LAZY = "KLEENISH_LAZY";
	//: {n,}?
	public static final String REP_LOWERBOUNDED_LAZY = "LOWERBOUNDED_LAZY";
	//: ??
	public static final String REP_QUESTIONABLE_LAZY = "QUESTIONABLE_LAZY";
	//: {n}?
	public static final String REP_SINGLEEXACTLY_LAZY = "SINGLEEXACTLY_LAZY";

	public static final int I_CC_DECIMAL = 0;
	public static final int I_CC_NDECIMAL = 1;
	public static final int I_CC_NWHITESPACE = 2;
	public static final int I_CC_NWORD = 3;
	public static final int I_CC_RANGE = 4;
	public static final int I_CC_WHITESPACE = 5;
	public static final int I_CC_WORD = 6;

	public static final int I_LOOK_AHEAD = 7;
	public static final int I_LOOK_AHEAD_NEGATIVE = 8;
	public static final int I_LOOK_BEHIND = 9;
	public static final int I_LOOK_BEHIND_NEGATIVE = 10;
	public static final int I_LOOK_NON_CAPTURE = 11;

	public static final int I_META_CC = 12;
	public static final int I_META_CAPTURING_GROUP = 13;
	public static final int I_META_DOT_ANY = 14;
	public static final int I_META_LITERAL = 15;
	public static final int I_META_NCC = 16;
	public static final int I_META_NUMBERED_BACKREFERENCE = 17;
	public static final int I_META_OR = 18;

	public static final int I_POS_END_ANCHOR = 19;
	public static final int I_POS_NONWORD = 20;
	public static final int I_POS_START_ANCHOR = 21;
	public static final int I_POS_WORD = 22;
	
	public static final int I_REP_ADDITIONAL = 23;
	public static final int I_REP_DOUBLEBOUNDED = 24;
	public static final int I_REP_KLEENISH = 25;
	public static final int I_REP_LOWERBOUNDED = 26;
	public static final int I_REP_QUESTIONABLE = 27;
	public static final int I_REP_SINGLEEXACTLY = 28;
	public static final int I_REP_ADDITIONAL_LAZY = 29;
	public static final int I_REP_DOUBLEBOUNDED_LAZY = 30;
	public static final int I_REP_KLEENISH_LAZY = 31;
	public static final int I_REP_LOWERBOUNDED_LAZY = 32;
	public static final int I_REP_QUESTIONABLE_LAZY = 33;
	public static final int I_REP_SINGLEEXACTLY_LAZY = 34;


}
