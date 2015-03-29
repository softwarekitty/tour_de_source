// $ANTLR 3.5.2 PCRE.g 2014-07-20 13:43:40

  package pcre;
  
  import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PCRELexer extends Lexer {
	public static final int EOF=-1;
	public static final int ALC=4;
	public static final int ALTERNATIVE=5;
	public static final int ANY=6;
	public static final int ASCII=7;
	public static final int ASSERT=8;
	public static final int ATOMIC_GROUP=9;
	public static final int AUC=10;
	public static final int AlphaNumeric=11;
	public static final int AlphaNumerics=12;
	public static final int Ampersand=13;
	public static final int BACKTACK_CONTROL_ACCEPT=14;
	public static final int BACKTACK_CONTROL_COMMIT=15;
	public static final int BACKTACK_CONTROL_FAIL=16;
	public static final int BACKTACK_CONTROL_MARK_NAME=17;
	public static final int BACKTACK_CONTROL_PRUNE=18;
	public static final int BACKTACK_CONTROL_PRUNE_NAME=19;
	public static final int BACKTACK_CONTROL_SKIP=20;
	public static final int BACKTACK_CONTROL_SKIP_NAME=21;
	public static final int BACKTACK_CONTROL_THEN=22;
	public static final int BACKTACK_CONTROL_THEN_NAME=23;
	public static final int BLC=24;
	public static final int BUC=25;
	public static final int Backslash=26;
	public static final int BellChar=27;
	public static final int BlockQuoted=28;
	public static final int CALLOUT=29;
	public static final int CAPTURING_GROUP=30;
	public static final int CHARACTER_CLASS=31;
	public static final int CLC=32;
	public static final int COMMENT=33;
	public static final int CUC=34;
	public static final int Caret=35;
	public static final int CarriageReturn=36;
	public static final int CharWithProperty=37;
	public static final int CharWithoutProperty=38;
	public static final int CharacterClassEnd=39;
	public static final int CharacterClassStart=40;
	public static final int CloseBrace=41;
	public static final int CloseParen=42;
	public static final int Colon=43;
	public static final int Comma=44;
	public static final int ControlChar=45;
	public static final int D0=46;
	public static final int D1=47;
	public static final int D2=48;
	public static final int D3=49;
	public static final int D4=50;
	public static final int D5=51;
	public static final int D6=52;
	public static final int D7=53;
	public static final int D8=54;
	public static final int D9=55;
	public static final int DEFINE=56;
	public static final int DLC=57;
	public static final int DUC=58;
	public static final int DecimalDigit=59;
	public static final int Dot=60;
	public static final int ELC=61;
	public static final int ELEMENT=62;
	public static final int EUC=63;
	public static final int EndOfSubject=64;
	public static final int EndOfSubjectOrLine=65;
	public static final int EndOfSubjectOrLineEndOfSubject=66;
	public static final int Equals=67;
	public static final int EscapeChar=68;
	public static final int Exclamation=69;
	public static final int ExtendedUnicodeChar=70;
	public static final int FLC=71;
	public static final int FUC=72;
	public static final int FormFeed=73;
	public static final int GLC=74;
	public static final int GREEDY=75;
	public static final int GUC=76;
	public static final int GreaterThan=77;
	public static final int HLC=78;
	public static final int HUC=79;
	public static final int Hash=80;
	public static final int HexChar=81;
	public static final int HexDigit=82;
	public static final int HorizontalWhiteSpace=83;
	public static final int Hyphen=84;
	public static final int ILC=85;
	public static final int IUC=86;
	public static final int JLC=87;
	public static final int JUC=88;
	public static final int KLC=89;
	public static final int KUC=90;
	public static final int LAZY=91;
	public static final int LITERAL=92;
	public static final int LLC=93;
	public static final int LOOK_AHEAD=94;
	public static final int LOOK_BEHIND=95;
	public static final int LUC=96;
	public static final int LessThan=97;
	public static final int MLC=98;
	public static final int MUC=99;
	public static final int NAME=100;
	public static final int NAMED_BACKREFERENCE_NET=101;
	public static final int NAMED_BACKREFERENCE_PERL=102;
	public static final int NAMED_BACKREFERENCE_PYTHON=103;
	public static final int NAMED_CAPTURING_GROUP_PERL=104;
	public static final int NAMED_CAPTURING_GROUP_PYTHON=105;
	public static final int NAMED_REFERENCE_CONDITION=106;
	public static final int NAMED_REFERENCE_CONDITION_PERL=107;
	public static final int NAMED_REFERENCE_ONIGURUMA=108;
	public static final int NAMED_REFERENCE_PERL=109;
	public static final int NAMED_REFERENCE_PYTHON=110;
	public static final int NEGATED_CHARACTER_CLASS=111;
	public static final int NEGATIVE_LOOK_AHEAD=112;
	public static final int NEGATIVE_LOOK_BEHIND=113;
	public static final int NEWLINE_CONVENTION_ANY=114;
	public static final int NEWLINE_CONVENTION_ANYCRLF=115;
	public static final int NEWLINE_CONVENTION_BSR_ANYCRLF=116;
	public static final int NEWLINE_CONVENTION_BSR_UNICODE=117;
	public static final int NEWLINE_CONVENTION_CR=118;
	public static final int NEWLINE_CONVENTION_CRLF=119;
	public static final int NEWLINE_CONVENTION_LF=120;
	public static final int NLC=121;
	public static final int NO=122;
	public static final int NON_CAPTURING_GROUP=123;
	public static final int NON_CAPTURING_GROUP_RESET=124;
	public static final int NUC=125;
	public static final int NUMBER=126;
	public static final int NUMBERED_BACKREFERENCE=127;
	public static final int NUMBERED_REFERENCE_ABSOLUTE=128;
	public static final int NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA=129;
	public static final int NUMBERED_REFERENCE_RELATIVE_MINUS=130;
	public static final int NUMBERED_REFERENCE_RELATIVE_PLUS=131;
	public static final int NamedReferenceStartK=132;
	public static final int NewLine=133;
	public static final int NewLineSequence=134;
	public static final int NonAlphaNumeric=135;
	public static final int NonWordBoundary=136;
	public static final int NotDecimalDigit=137;
	public static final int NotHorizontalWhiteSpace=138;
	public static final int NotNewLine=139;
	public static final int NotVerticalWhiteSpace=140;
	public static final int NotWhiteSpace=141;
	public static final int NotWordChar=142;
	public static final int OLC=143;
	public static final int OPTION=144;
	public static final int OPTIONS=145;
	public static final int OPTIONS_NO_START_OPT=146;
	public static final int OPTIONS_UCP=147;
	public static final int OPTIONS_UTF16=148;
	public static final int OPTIONS_UTF8=149;
	public static final int OR=150;
	public static final int OUC=151;
	public static final int OVERALL_RECURSION_CONDITION=152;
	public static final int OneDataUnit=153;
	public static final int OpenBrace=154;
	public static final int OpenParen=155;
	public static final int OtherChar=156;
	public static final int PLC=157;
	public static final int POSIXNamedSet=158;
	public static final int POSIXNegatedNamedSet=159;
	public static final int POSSESSIVE=160;
	public static final int PUC=161;
	public static final int Pipe=162;
	public static final int Plus=163;
	public static final int PreviousMatchInSubject=164;
	public static final int QLC=165;
	public static final int QUANTIFIER=166;
	public static final int QUC=167;
	public static final int QuestionMark=168;
	public static final int Quoted=169;
	public static final int RANGE=170;
	public static final int REFERENCE_CONDITION_ABSOLUTE=171;
	public static final int REFERENCE_CONDITION_RELATIVE_MINUS=172;
	public static final int REFERENCE_CONDITION_RELATIVE_PLUS=173;
	public static final int RELATIVE_NUMBERED_BACKREFERENCE=174;
	public static final int RLC=175;
	public static final int RUC=176;
	public static final int ResetStartMatch=177;
	public static final int SET=178;
	public static final int SLC=179;
	public static final int SPECIFIC_GROUP_RECURSION_CONDITION=180;
	public static final int SPECIFIC_RECURSION_CONDITION=181;
	public static final int START_OF_SUBJECT=182;
	public static final int SUC=183;
	public static final int SingleQuote=184;
	public static final int Star=185;
	public static final int StartOfSubject=186;
	public static final int SubroutineOrNamedReferenceStartG=187;
	public static final int TLC=188;
	public static final int TUC=189;
	public static final int Tab=190;
	public static final int ULC=191;
	public static final int UNSET=192;
	public static final int UUC=193;
	public static final int Underscore=194;
	public static final int UnderscoreAlphaNumerics=195;
	public static final int VLC=196;
	public static final int VUC=197;
	public static final int VerticalWhiteSpace=198;
	public static final int WLC=199;
	public static final int WUC=200;
	public static final int WhiteSpace=201;
	public static final int WordBoundary=202;
	public static final int WordChar=203;
	public static final int XLC=204;
	public static final int XUC=205;
	public static final int YES=206;
	public static final int YLC=207;
	public static final int YUC=208;
	public static final int ZLC=209;
	public static final int ZUC=210;

	  
	  public static final Set<String> namedSet = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("alnum", "alpha", "ascii", "blank", "cntrl", 
	                "digit", "graph", "lower", "print", "punct", "space", "upper", "word", "xdigit")));

	  protected static final Set<String> optionSet = new HashSet<String>(Arrays.asList("NO_START_OPT", "UTF8", "UTF16", "UCP"));
	                
	  public static final Set<String> propertySet = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("C", "Cc", "Cf", "Cn", "Co", "Cs", "L", "Ll", "Lm", 
	                "Lo", "Lt", "Lu", "L", "M", "Mc", "Me", "Mn", "N", "Nd", "Nl", "No", "P", "Pc", "Pd", "Pe", "Pf", 
	                "Pi", "Po", "Ps", "S", "Sc", "Sk", "Sm", "So", "Z", "Zl", "Zp", "Zs", "Xan", "Xps", "Xsp", "Xwd", 
	                "Arabic", "Armenian", "Avestan", "Balinese", "Bamum", "Batak", "Bengali", "Bopomofo", "Brahmi", 
	                "Braille", "Buginese", "Buhid", "Canadian_Aboriginal", "Carian", "Chakma", "Cham", "Cherokee", 
	                "Common", "Coptic", "Cuneiform", "Cypriot", "Cyrillic", "Deseret", "Devanagari", "Egyptian_Hieroglyphs", 
	                "Ethiopic", "Georgian", "Glagolitic", "Gothic", "Greek", "Gujarati", "Gurmukhi", "Han", "Hangul", 
	                "Hanunoo", "Hebrew", "Hiragana", "Imperial_Aramaic", "Inherited", "Inscriptional_Pahlavi", 
	                "Inscriptional_Parthian", "Javanese", "Kaithi", "Kannada", "Katakana", "Kayah_Li", "Kharoshthi", 
	                "Khmer", "Lao", "Latin", "Lepcha", "Limbu", "Linear_B", "Lisu", "Lycian", "Lydian", "Malayalam",
	                "Mandaic", "Meetei_Mayek", "Meroitic_Cursive", "Meroitic_Hieroglyphs", "Miao", "Mongolian", "Myanmar", 
	                "New_Tai_Lue", "Nko", "Ogham", "Old_Italic", "Old_Persian", "Old_South_Arabian", "Old_Turkic", 
	                "Ol_Chiki", "Oriya", "Osmanya", "Phags_Pa", "Phoenician", "Rejang", "Runic", "Samaritan", 
	                "Saurashtra", "Sharada", "Shavian", "Sinhala", "Sora_Sompeng", "Sundanese", "Syloti_Nagri", 
	                "Syriac", "Tagalog", "Tagbanwa", "Tai_Le", "Tai_Tham", "Tai_Viet", "Takri", "Tamil", "Telugu", 
	                "Thaana", "Thai", "Tibetan", "Tifinagh", "Ugaritic", "Vai", "Yi")));
	                
	  private void checkNamedSet(String name) {
	    if(!namedSet.contains(name)) {
	      throw new RuntimeException("unsupported named set: " + name);
	    }
	  }
	  
	  private void checkOption(String name) {
	    if(!namedSet.contains(name)) {
	      throw new RuntimeException("unsupported option: " + name);
	    }
	  }
	  
	  private void checkProperty(String name) {
	    if(!propertySet.contains(name)) {
	      throw new RuntimeException("unsupported character property: " + name);
	    }
	  }


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PCRELexer() {} 
	public PCRELexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PCRELexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "PCRE.g"; }

	// $ANTLR start "Quoted"
	public final void mQuoted() throws RecognitionException {
		try {
			int _type = Quoted;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:719:13: ( '\\\\' NonAlphaNumeric )
			// PCRE.g:719:15: '\\\\' NonAlphaNumeric
			{
			match('\\'); 
			mNonAlphaNumeric(); 

			setText(getText().substring(1));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Quoted"

	// $ANTLR start "BlockQuoted"
	public final void mBlockQuoted() throws RecognitionException {
		try {
			int _type = BlockQuoted;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:710:13: ( '\\\\Q' ( . )* '\\\\E' )
			// PCRE.g:710:15: '\\\\Q' ( . )* '\\\\E'
			{
			match("\\Q"); 

			// PCRE.g:710:21: ( . )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='\\') ) {
					int LA1_1 = input.LA(2);
					if ( (LA1_1=='E') ) {
						alt1=2;
					}
					else if ( ((LA1_1 >= '\u0000' && LA1_1 <= 'D')||(LA1_1 >= 'F' && LA1_1 <= '\uFFFF')) ) {
						alt1=1;
					}

				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// PCRE.g:710:21: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop1;
				}
			}

			match("\\E"); 

			setText(getText().substring(2, getText().length() - 2));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BlockQuoted"

	// $ANTLR start "BellChar"
	public final void mBellChar() throws RecognitionException {
		try {
			int _type = BellChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:724:16: ( '\\\\a' )
			// PCRE.g:724:18: '\\\\a'
			{
			match("\\a"); 

			setText("\u0007");
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BellChar"

	// $ANTLR start "ControlChar"
	public final void mControlChar() throws RecognitionException {
		try {
			int _type = ControlChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken ASCII1=null;

			// PCRE.g:725:16: ( '\\\\c' ASCII )
			// PCRE.g:725:18: '\\\\c' ASCII
			{
			match("\\c"); 

			int ASCII1Start86 = getCharIndex();
			int ASCII1StartLine86 = getLine();
			int ASCII1StartCharPos86 = getCharPositionInLine();
			mASCII(); 
			ASCII1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, ASCII1Start86, getCharIndex()-1);
			ASCII1.setLine(ASCII1StartLine86);
			ASCII1.setCharPositionInLine(ASCII1StartCharPos86);

			setText((ASCII1!=null?ASCII1.getText():null));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ControlChar"

	// $ANTLR start "EscapeChar"
	public final void mEscapeChar() throws RecognitionException {
		try {
			int _type = EscapeChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:726:16: ( '\\\\e' )
			// PCRE.g:726:18: '\\\\e'
			{
			match("\\e"); 

			setText(String.valueOf((char)0x1B));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EscapeChar"

	// $ANTLR start "FormFeed"
	public final void mFormFeed() throws RecognitionException {
		try {
			int _type = FormFeed;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:727:16: ( '\\\\f' )
			// PCRE.g:727:18: '\\\\f'
			{
			match("\\f"); 

			setText(String.valueOf((char)0x0C));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FormFeed"

	// $ANTLR start "NewLine"
	public final void mNewLine() throws RecognitionException {
		try {
			int _type = NewLine;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:728:16: ( '\\\\n' )
			// PCRE.g:728:18: '\\\\n'
			{
			match("\\n"); 

			setText("\n");
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NewLine"

	// $ANTLR start "CarriageReturn"
	public final void mCarriageReturn() throws RecognitionException {
		try {
			int _type = CarriageReturn;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:729:16: ( '\\\\r' )
			// PCRE.g:729:18: '\\\\r'
			{
			match("\\r"); 

			setText("\r");
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CarriageReturn"

	// $ANTLR start "Tab"
	public final void mTab() throws RecognitionException {
		try {
			int _type = Tab;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:730:16: ( '\\\\t' )
			// PCRE.g:730:18: '\\\\t'
			{
			match("\\t"); 

			setText("\t");
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Tab"

	// $ANTLR start "Backslash"
	public final void mBackslash() throws RecognitionException {
		try {
			int _type = Backslash;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:731:16: ( '\\\\' )
			// PCRE.g:731:18: '\\\\'
			{
			match('\\'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Backslash"

	// $ANTLR start "HexChar"
	public final void mHexChar() throws RecognitionException {
		try {
			int _type = HexChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:732:16: ( '\\\\x' ( HexDigit HexDigit | '{' HexDigit HexDigit ( HexDigit )+ '}' ) )
			// PCRE.g:732:18: '\\\\x' ( HexDigit HexDigit | '{' HexDigit HexDigit ( HexDigit )+ '}' )
			{
			match("\\x"); 

			// PCRE.g:732:24: ( HexDigit HexDigit | '{' HexDigit HexDigit ( HexDigit )+ '}' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'F')||(LA3_0 >= 'a' && LA3_0 <= 'f')) ) {
				alt3=1;
			}
			else if ( (LA3_0=='{') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// PCRE.g:732:26: HexDigit HexDigit
					{
					mHexDigit(); 

					mHexDigit(); 


					                           int hex = Integer.valueOf(getText().substring(2), 16);
					                           setText(Character.valueOf((char)hex).toString());
					                         
					}
					break;
				case 2 :
					// PCRE.g:737:26: '{' HexDigit HexDigit ( HexDigit )+ '}'
					{
					match('{'); 
					mHexDigit(); 

					mHexDigit(); 

					// PCRE.g:737:48: ( HexDigit )+
					int cnt2=0;
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'F')||(LA2_0 >= 'a' && LA2_0 <= 'f')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// PCRE.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					match('}'); 

					                           int hex = Integer.valueOf(getText().substring(3, getText().length() - 1), 16);
					                           char[] utf16 = Character.toChars(hex);
					                           setText(new String(utf16));
					                         
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HexChar"

	// $ANTLR start "Dot"
	public final void mDot() throws RecognitionException {
		try {
			int _type = Dot;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:769:25: ( '.' )
			// PCRE.g:769:27: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Dot"

	// $ANTLR start "OneDataUnit"
	public final void mOneDataUnit() throws RecognitionException {
		try {
			int _type = OneDataUnit;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:770:25: ( '\\\\C' )
			// PCRE.g:770:27: '\\\\C'
			{
			match("\\C"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OneDataUnit"

	// $ANTLR start "DecimalDigit"
	public final void mDecimalDigit() throws RecognitionException {
		try {
			int _type = DecimalDigit;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:771:25: ( '\\\\d' )
			// PCRE.g:771:27: '\\\\d'
			{
			match("\\d"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DecimalDigit"

	// $ANTLR start "NotDecimalDigit"
	public final void mNotDecimalDigit() throws RecognitionException {
		try {
			int _type = NotDecimalDigit;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:772:25: ( '\\\\D' )
			// PCRE.g:772:27: '\\\\D'
			{
			match("\\D"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NotDecimalDigit"

	// $ANTLR start "HorizontalWhiteSpace"
	public final void mHorizontalWhiteSpace() throws RecognitionException {
		try {
			int _type = HorizontalWhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:773:25: ( '\\\\h' )
			// PCRE.g:773:27: '\\\\h'
			{
			match("\\h"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HorizontalWhiteSpace"

	// $ANTLR start "NotHorizontalWhiteSpace"
	public final void mNotHorizontalWhiteSpace() throws RecognitionException {
		try {
			int _type = NotHorizontalWhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:774:25: ( '\\\\H' )
			// PCRE.g:774:27: '\\\\H'
			{
			match("\\H"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NotHorizontalWhiteSpace"

	// $ANTLR start "NotNewLine"
	public final void mNotNewLine() throws RecognitionException {
		try {
			int _type = NotNewLine;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:775:25: ( '\\\\N' )
			// PCRE.g:775:27: '\\\\N'
			{
			match("\\N"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NotNewLine"

	// $ANTLR start "CharWithProperty"
	public final void mCharWithProperty() throws RecognitionException {
		try {
			int _type = CharWithProperty;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken UnderscoreAlphaNumerics2=null;

			// PCRE.g:776:25: ( '\\\\p{' UnderscoreAlphaNumerics '}' )
			// PCRE.g:776:27: '\\\\p{' UnderscoreAlphaNumerics '}'
			{
			match("\\p{"); 

			int UnderscoreAlphaNumerics2Start460 = getCharIndex();
			int UnderscoreAlphaNumerics2StartLine460 = getLine();
			int UnderscoreAlphaNumerics2StartCharPos460 = getCharPositionInLine();
			mUnderscoreAlphaNumerics(); 
			UnderscoreAlphaNumerics2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, UnderscoreAlphaNumerics2Start460, getCharIndex()-1);
			UnderscoreAlphaNumerics2.setLine(UnderscoreAlphaNumerics2StartLine460);
			UnderscoreAlphaNumerics2.setCharPositionInLine(UnderscoreAlphaNumerics2StartCharPos460);

			match('}'); 
			checkProperty((UnderscoreAlphaNumerics2!=null?UnderscoreAlphaNumerics2.getText():null));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CharWithProperty"

	// $ANTLR start "CharWithoutProperty"
	public final void mCharWithoutProperty() throws RecognitionException {
		try {
			int _type = CharWithoutProperty;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken UnderscoreAlphaNumerics3=null;

			// PCRE.g:777:25: ( '\\\\P{' UnderscoreAlphaNumerics '}' )
			// PCRE.g:777:27: '\\\\P{' UnderscoreAlphaNumerics '}'
			{
			match("\\P{"); 

			int UnderscoreAlphaNumerics3Start477 = getCharIndex();
			int UnderscoreAlphaNumerics3StartLine477 = getLine();
			int UnderscoreAlphaNumerics3StartCharPos477 = getCharPositionInLine();
			mUnderscoreAlphaNumerics(); 
			UnderscoreAlphaNumerics3 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, UnderscoreAlphaNumerics3Start477, getCharIndex()-1);
			UnderscoreAlphaNumerics3.setLine(UnderscoreAlphaNumerics3StartLine477);
			UnderscoreAlphaNumerics3.setCharPositionInLine(UnderscoreAlphaNumerics3StartCharPos477);

			match('}'); 
			checkProperty((UnderscoreAlphaNumerics3!=null?UnderscoreAlphaNumerics3.getText():null));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CharWithoutProperty"

	// $ANTLR start "NewLineSequence"
	public final void mNewLineSequence() throws RecognitionException {
		try {
			int _type = NewLineSequence;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:778:25: ( '\\\\R' )
			// PCRE.g:778:27: '\\\\R'
			{
			match("\\R"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NewLineSequence"

	// $ANTLR start "WhiteSpace"
	public final void mWhiteSpace() throws RecognitionException {
		try {
			int _type = WhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:779:25: ( '\\\\s' )
			// PCRE.g:779:27: '\\\\s'
			{
			match("\\s"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WhiteSpace"

	// $ANTLR start "NotWhiteSpace"
	public final void mNotWhiteSpace() throws RecognitionException {
		try {
			int _type = NotWhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:780:25: ( '\\\\S' )
			// PCRE.g:780:27: '\\\\S'
			{
			match("\\S"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NotWhiteSpace"

	// $ANTLR start "VerticalWhiteSpace"
	public final void mVerticalWhiteSpace() throws RecognitionException {
		try {
			int _type = VerticalWhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:781:25: ( '\\\\v' )
			// PCRE.g:781:27: '\\\\v'
			{
			match("\\v"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VerticalWhiteSpace"

	// $ANTLR start "NotVerticalWhiteSpace"
	public final void mNotVerticalWhiteSpace() throws RecognitionException {
		try {
			int _type = NotVerticalWhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:782:25: ( '\\\\V' )
			// PCRE.g:782:27: '\\\\V'
			{
			match("\\V"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NotVerticalWhiteSpace"

	// $ANTLR start "WordChar"
	public final void mWordChar() throws RecognitionException {
		try {
			int _type = WordChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:783:25: ( '\\\\w' )
			// PCRE.g:783:27: '\\\\w'
			{
			match("\\w"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WordChar"

	// $ANTLR start "NotWordChar"
	public final void mNotWordChar() throws RecognitionException {
		try {
			int _type = NotWordChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:784:25: ( '\\\\W' )
			// PCRE.g:784:27: '\\\\W'
			{
			match("\\W"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NotWordChar"

	// $ANTLR start "ExtendedUnicodeChar"
	public final void mExtendedUnicodeChar() throws RecognitionException {
		try {
			int _type = ExtendedUnicodeChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:785:25: ( '\\\\X' )
			// PCRE.g:785:27: '\\\\X'
			{
			match("\\X"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ExtendedUnicodeChar"

	// $ANTLR start "CharacterClassStart"
	public final void mCharacterClassStart() throws RecognitionException {
		try {
			int _type = CharacterClassStart;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:813:22: ( '[' )
			// PCRE.g:813:24: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CharacterClassStart"

	// $ANTLR start "CharacterClassEnd"
	public final void mCharacterClassEnd() throws RecognitionException {
		try {
			int _type = CharacterClassEnd;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:814:22: ( ']' )
			// PCRE.g:814:24: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CharacterClassEnd"

	// $ANTLR start "Caret"
	public final void mCaret() throws RecognitionException {
		try {
			int _type = Caret;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:815:22: ( '^' )
			// PCRE.g:815:24: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Caret"

	// $ANTLR start "Hyphen"
	public final void mHyphen() throws RecognitionException {
		try {
			int _type = Hyphen;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:816:22: ( '-' )
			// PCRE.g:816:24: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Hyphen"

	// $ANTLR start "POSIXNamedSet"
	public final void mPOSIXNamedSet() throws RecognitionException {
		try {
			int _type = POSIXNamedSet;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken AlphaNumerics4=null;

			// PCRE.g:817:22: ( '[[:' AlphaNumerics ':]]' )
			// PCRE.g:817:24: '[[:' AlphaNumerics ':]]'
			{
			match("[[:"); 

			int AlphaNumerics4Start683 = getCharIndex();
			int AlphaNumerics4StartLine683 = getLine();
			int AlphaNumerics4StartCharPos683 = getCharPositionInLine();
			mAlphaNumerics(); 
			AlphaNumerics4 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, AlphaNumerics4Start683, getCharIndex()-1);
			AlphaNumerics4.setLine(AlphaNumerics4StartLine683);
			AlphaNumerics4.setCharPositionInLine(AlphaNumerics4StartCharPos683);

			match(":]]"); 

			checkNamedSet((AlphaNumerics4!=null?AlphaNumerics4.getText():null));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POSIXNamedSet"

	// $ANTLR start "POSIXNegatedNamedSet"
	public final void mPOSIXNegatedNamedSet() throws RecognitionException {
		try {
			int _type = POSIXNegatedNamedSet;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken AlphaNumerics5=null;

			// PCRE.g:818:22: ( '[[:^' AlphaNumerics ':]]' )
			// PCRE.g:818:24: '[[:^' AlphaNumerics ':]]'
			{
			match("[[:^"); 

			int AlphaNumerics5Start696 = getCharIndex();
			int AlphaNumerics5StartLine696 = getLine();
			int AlphaNumerics5StartCharPos696 = getCharPositionInLine();
			mAlphaNumerics(); 
			AlphaNumerics5 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, AlphaNumerics5Start696, getCharIndex()-1);
			AlphaNumerics5.setLine(AlphaNumerics5StartLine696);
			AlphaNumerics5.setCharPositionInLine(AlphaNumerics5StartCharPos696);

			match(":]]"); 

			checkNamedSet((AlphaNumerics5!=null?AlphaNumerics5.getText():null));
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POSIXNegatedNamedSet"

	// $ANTLR start "QuestionMark"
	public final void mQuestionMark() throws RecognitionException {
		try {
			int _type = QuestionMark;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:820:14: ( '?' )
			// PCRE.g:820:16: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QuestionMark"

	// $ANTLR start "Plus"
	public final void mPlus() throws RecognitionException {
		try {
			int _type = Plus;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:821:14: ( '+' )
			// PCRE.g:821:16: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Plus"

	// $ANTLR start "Star"
	public final void mStar() throws RecognitionException {
		try {
			int _type = Star;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:822:14: ( '*' )
			// PCRE.g:822:16: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Star"

	// $ANTLR start "OpenBrace"
	public final void mOpenBrace() throws RecognitionException {
		try {
			int _type = OpenBrace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:823:14: ( '{' )
			// PCRE.g:823:16: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OpenBrace"

	// $ANTLR start "CloseBrace"
	public final void mCloseBrace() throws RecognitionException {
		try {
			int _type = CloseBrace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:824:14: ( '}' )
			// PCRE.g:824:16: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CloseBrace"

	// $ANTLR start "Comma"
	public final void mComma() throws RecognitionException {
		try {
			int _type = Comma;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:825:14: ( ',' )
			// PCRE.g:825:16: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Comma"

	// $ANTLR start "WordBoundary"
	public final void mWordBoundary() throws RecognitionException {
		try {
			int _type = WordBoundary;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:841:32: ( '\\\\b' )
			// PCRE.g:841:34: '\\\\b'
			{
			match("\\b"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WordBoundary"

	// $ANTLR start "NonWordBoundary"
	public final void mNonWordBoundary() throws RecognitionException {
		try {
			int _type = NonWordBoundary;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:842:32: ( '\\\\B' )
			// PCRE.g:842:34: '\\\\B'
			{
			match("\\B"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NonWordBoundary"

	// $ANTLR start "StartOfSubject"
	public final void mStartOfSubject() throws RecognitionException {
		try {
			int _type = StartOfSubject;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:843:32: ( '\\\\A' )
			// PCRE.g:843:34: '\\\\A'
			{
			match("\\A"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "StartOfSubject"

	// $ANTLR start "EndOfSubjectOrLine"
	public final void mEndOfSubjectOrLine() throws RecognitionException {
		try {
			int _type = EndOfSubjectOrLine;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:844:32: ( '$' )
			// PCRE.g:844:34: '$'
			{
			match('$'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndOfSubjectOrLine"

	// $ANTLR start "EndOfSubjectOrLineEndOfSubject"
	public final void mEndOfSubjectOrLineEndOfSubject() throws RecognitionException {
		try {
			int _type = EndOfSubjectOrLineEndOfSubject;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:845:32: ( '\\\\Z' )
			// PCRE.g:845:34: '\\\\Z'
			{
			match("\\Z"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndOfSubjectOrLineEndOfSubject"

	// $ANTLR start "EndOfSubject"
	public final void mEndOfSubject() throws RecognitionException {
		try {
			int _type = EndOfSubject;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:846:32: ( '\\\\z' )
			// PCRE.g:846:34: '\\\\z'
			{
			match("\\z"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EndOfSubject"

	// $ANTLR start "PreviousMatchInSubject"
	public final void mPreviousMatchInSubject() throws RecognitionException {
		try {
			int _type = PreviousMatchInSubject;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:847:32: ( '\\\\G' )
			// PCRE.g:847:34: '\\\\G'
			{
			match("\\G"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PreviousMatchInSubject"

	// $ANTLR start "ResetStartMatch"
	public final void mResetStartMatch() throws RecognitionException {
		try {
			int _type = ResetStartMatch;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:852:17: ( '\\\\K' )
			// PCRE.g:852:19: '\\\\K'
			{
			match("\\K"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ResetStartMatch"

	// $ANTLR start "SubroutineOrNamedReferenceStartG"
	public final void mSubroutineOrNamedReferenceStartG() throws RecognitionException {
		try {
			int _type = SubroutineOrNamedReferenceStartG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:854:34: ( '\\\\g' )
			// PCRE.g:854:36: '\\\\g'
			{
			match("\\g"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SubroutineOrNamedReferenceStartG"

	// $ANTLR start "NamedReferenceStartK"
	public final void mNamedReferenceStartK() throws RecognitionException {
		try {
			int _type = NamedReferenceStartK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:855:34: ( '\\\\k' )
			// PCRE.g:855:36: '\\\\k'
			{
			match("\\k"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NamedReferenceStartK"

	// $ANTLR start "Pipe"
	public final void mPipe() throws RecognitionException {
		try {
			int _type = Pipe;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:857:13: ( '|' )
			// PCRE.g:857:15: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Pipe"

	// $ANTLR start "OpenParen"
	public final void mOpenParen() throws RecognitionException {
		try {
			int _type = OpenParen;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:858:13: ( '(' )
			// PCRE.g:858:15: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OpenParen"

	// $ANTLR start "CloseParen"
	public final void mCloseParen() throws RecognitionException {
		try {
			int _type = CloseParen;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:859:13: ( ')' )
			// PCRE.g:859:15: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CloseParen"

	// $ANTLR start "LessThan"
	public final void mLessThan() throws RecognitionException {
		try {
			int _type = LessThan;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:860:13: ( '<' )
			// PCRE.g:860:15: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LessThan"

	// $ANTLR start "GreaterThan"
	public final void mGreaterThan() throws RecognitionException {
		try {
			int _type = GreaterThan;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:861:13: ( '>' )
			// PCRE.g:861:15: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GreaterThan"

	// $ANTLR start "SingleQuote"
	public final void mSingleQuote() throws RecognitionException {
		try {
			int _type = SingleQuote;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:862:13: ( '\\'' )
			// PCRE.g:862:15: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SingleQuote"

	// $ANTLR start "Underscore"
	public final void mUnderscore() throws RecognitionException {
		try {
			int _type = Underscore;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:863:13: ( '_' )
			// PCRE.g:863:15: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Underscore"

	// $ANTLR start "Colon"
	public final void mColon() throws RecognitionException {
		try {
			int _type = Colon;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:864:13: ( ':' )
			// PCRE.g:864:15: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Colon"

	// $ANTLR start "Hash"
	public final void mHash() throws RecognitionException {
		try {
			int _type = Hash;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:865:13: ( '#' )
			// PCRE.g:865:15: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Hash"

	// $ANTLR start "Equals"
	public final void mEquals() throws RecognitionException {
		try {
			int _type = Equals;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:866:13: ( '=' )
			// PCRE.g:866:15: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Equals"

	// $ANTLR start "Exclamation"
	public final void mExclamation() throws RecognitionException {
		try {
			int _type = Exclamation;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:867:13: ( '!' )
			// PCRE.g:867:15: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Exclamation"

	// $ANTLR start "Ampersand"
	public final void mAmpersand() throws RecognitionException {
		try {
			int _type = Ampersand;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:868:13: ( '&' )
			// PCRE.g:868:15: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Ampersand"

	// $ANTLR start "ALC"
	public final void mALC() throws RecognitionException {
		try {
			int _type = ALC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:870:5: ( 'a' )
			// PCRE.g:870:7: 'a'
			{
			match('a'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALC"

	// $ANTLR start "BLC"
	public final void mBLC() throws RecognitionException {
		try {
			int _type = BLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:871:5: ( 'b' )
			// PCRE.g:871:7: 'b'
			{
			match('b'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BLC"

	// $ANTLR start "CLC"
	public final void mCLC() throws RecognitionException {
		try {
			int _type = CLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:872:5: ( 'c' )
			// PCRE.g:872:7: 'c'
			{
			match('c'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLC"

	// $ANTLR start "DLC"
	public final void mDLC() throws RecognitionException {
		try {
			int _type = DLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:873:5: ( 'd' )
			// PCRE.g:873:7: 'd'
			{
			match('d'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DLC"

	// $ANTLR start "ELC"
	public final void mELC() throws RecognitionException {
		try {
			int _type = ELC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:874:5: ( 'e' )
			// PCRE.g:874:7: 'e'
			{
			match('e'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELC"

	// $ANTLR start "FLC"
	public final void mFLC() throws RecognitionException {
		try {
			int _type = FLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:875:5: ( 'f' )
			// PCRE.g:875:7: 'f'
			{
			match('f'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLC"

	// $ANTLR start "GLC"
	public final void mGLC() throws RecognitionException {
		try {
			int _type = GLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:876:5: ( 'g' )
			// PCRE.g:876:7: 'g'
			{
			match('g'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GLC"

	// $ANTLR start "HLC"
	public final void mHLC() throws RecognitionException {
		try {
			int _type = HLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:877:5: ( 'h' )
			// PCRE.g:877:7: 'h'
			{
			match('h'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HLC"

	// $ANTLR start "ILC"
	public final void mILC() throws RecognitionException {
		try {
			int _type = ILC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:878:5: ( 'i' )
			// PCRE.g:878:7: 'i'
			{
			match('i'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ILC"

	// $ANTLR start "JLC"
	public final void mJLC() throws RecognitionException {
		try {
			int _type = JLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:879:5: ( 'j' )
			// PCRE.g:879:7: 'j'
			{
			match('j'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JLC"

	// $ANTLR start "KLC"
	public final void mKLC() throws RecognitionException {
		try {
			int _type = KLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:880:5: ( 'k' )
			// PCRE.g:880:7: 'k'
			{
			match('k'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "KLC"

	// $ANTLR start "LLC"
	public final void mLLC() throws RecognitionException {
		try {
			int _type = LLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:881:5: ( 'l' )
			// PCRE.g:881:7: 'l'
			{
			match('l'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LLC"

	// $ANTLR start "MLC"
	public final void mMLC() throws RecognitionException {
		try {
			int _type = MLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:882:5: ( 'm' )
			// PCRE.g:882:7: 'm'
			{
			match('m'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MLC"

	// $ANTLR start "NLC"
	public final void mNLC() throws RecognitionException {
		try {
			int _type = NLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:883:5: ( 'n' )
			// PCRE.g:883:7: 'n'
			{
			match('n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NLC"

	// $ANTLR start "OLC"
	public final void mOLC() throws RecognitionException {
		try {
			int _type = OLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:884:5: ( 'o' )
			// PCRE.g:884:7: 'o'
			{
			match('o'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OLC"

	// $ANTLR start "PLC"
	public final void mPLC() throws RecognitionException {
		try {
			int _type = PLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:885:5: ( 'p' )
			// PCRE.g:885:7: 'p'
			{
			match('p'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLC"

	// $ANTLR start "QLC"
	public final void mQLC() throws RecognitionException {
		try {
			int _type = QLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:886:5: ( 'q' )
			// PCRE.g:886:7: 'q'
			{
			match('q'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QLC"

	// $ANTLR start "RLC"
	public final void mRLC() throws RecognitionException {
		try {
			int _type = RLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:887:5: ( 'r' )
			// PCRE.g:887:7: 'r'
			{
			match('r'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RLC"

	// $ANTLR start "SLC"
	public final void mSLC() throws RecognitionException {
		try {
			int _type = SLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:888:5: ( 's' )
			// PCRE.g:888:7: 's'
			{
			match('s'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLC"

	// $ANTLR start "TLC"
	public final void mTLC() throws RecognitionException {
		try {
			int _type = TLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:889:5: ( 't' )
			// PCRE.g:889:7: 't'
			{
			match('t'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TLC"

	// $ANTLR start "ULC"
	public final void mULC() throws RecognitionException {
		try {
			int _type = ULC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:890:5: ( 'u' )
			// PCRE.g:890:7: 'u'
			{
			match('u'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ULC"

	// $ANTLR start "VLC"
	public final void mVLC() throws RecognitionException {
		try {
			int _type = VLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:891:5: ( 'v' )
			// PCRE.g:891:7: 'v'
			{
			match('v'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VLC"

	// $ANTLR start "WLC"
	public final void mWLC() throws RecognitionException {
		try {
			int _type = WLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:892:5: ( 'w' )
			// PCRE.g:892:7: 'w'
			{
			match('w'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WLC"

	// $ANTLR start "XLC"
	public final void mXLC() throws RecognitionException {
		try {
			int _type = XLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:893:5: ( 'x' )
			// PCRE.g:893:7: 'x'
			{
			match('x'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XLC"

	// $ANTLR start "YLC"
	public final void mYLC() throws RecognitionException {
		try {
			int _type = YLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:894:5: ( 'y' )
			// PCRE.g:894:7: 'y'
			{
			match('y'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "YLC"

	// $ANTLR start "ZLC"
	public final void mZLC() throws RecognitionException {
		try {
			int _type = ZLC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:895:5: ( 'z' )
			// PCRE.g:895:7: 'z'
			{
			match('z'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ZLC"

	// $ANTLR start "AUC"
	public final void mAUC() throws RecognitionException {
		try {
			int _type = AUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:897:5: ( 'A' )
			// PCRE.g:897:7: 'A'
			{
			match('A'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AUC"

	// $ANTLR start "BUC"
	public final void mBUC() throws RecognitionException {
		try {
			int _type = BUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:898:5: ( 'B' )
			// PCRE.g:898:7: 'B'
			{
			match('B'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BUC"

	// $ANTLR start "CUC"
	public final void mCUC() throws RecognitionException {
		try {
			int _type = CUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:899:5: ( 'C' )
			// PCRE.g:899:7: 'C'
			{
			match('C'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CUC"

	// $ANTLR start "DUC"
	public final void mDUC() throws RecognitionException {
		try {
			int _type = DUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:900:5: ( 'D' )
			// PCRE.g:900:7: 'D'
			{
			match('D'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DUC"

	// $ANTLR start "EUC"
	public final void mEUC() throws RecognitionException {
		try {
			int _type = EUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:901:5: ( 'E' )
			// PCRE.g:901:7: 'E'
			{
			match('E'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EUC"

	// $ANTLR start "FUC"
	public final void mFUC() throws RecognitionException {
		try {
			int _type = FUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:902:5: ( 'F' )
			// PCRE.g:902:7: 'F'
			{
			match('F'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUC"

	// $ANTLR start "GUC"
	public final void mGUC() throws RecognitionException {
		try {
			int _type = GUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:903:5: ( 'G' )
			// PCRE.g:903:7: 'G'
			{
			match('G'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GUC"

	// $ANTLR start "HUC"
	public final void mHUC() throws RecognitionException {
		try {
			int _type = HUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:904:5: ( 'H' )
			// PCRE.g:904:7: 'H'
			{
			match('H'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HUC"

	// $ANTLR start "IUC"
	public final void mIUC() throws RecognitionException {
		try {
			int _type = IUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:905:5: ( 'I' )
			// PCRE.g:905:7: 'I'
			{
			match('I'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IUC"

	// $ANTLR start "JUC"
	public final void mJUC() throws RecognitionException {
		try {
			int _type = JUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:906:5: ( 'J' )
			// PCRE.g:906:7: 'J'
			{
			match('J'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JUC"

	// $ANTLR start "KUC"
	public final void mKUC() throws RecognitionException {
		try {
			int _type = KUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:907:5: ( 'K' )
			// PCRE.g:907:7: 'K'
			{
			match('K'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "KUC"

	// $ANTLR start "LUC"
	public final void mLUC() throws RecognitionException {
		try {
			int _type = LUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:908:5: ( 'L' )
			// PCRE.g:908:7: 'L'
			{
			match('L'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LUC"

	// $ANTLR start "MUC"
	public final void mMUC() throws RecognitionException {
		try {
			int _type = MUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:909:5: ( 'M' )
			// PCRE.g:909:7: 'M'
			{
			match('M'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUC"

	// $ANTLR start "NUC"
	public final void mNUC() throws RecognitionException {
		try {
			int _type = NUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:910:5: ( 'N' )
			// PCRE.g:910:7: 'N'
			{
			match('N'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUC"

	// $ANTLR start "OUC"
	public final void mOUC() throws RecognitionException {
		try {
			int _type = OUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:911:5: ( 'O' )
			// PCRE.g:911:7: 'O'
			{
			match('O'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUC"

	// $ANTLR start "PUC"
	public final void mPUC() throws RecognitionException {
		try {
			int _type = PUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:912:5: ( 'P' )
			// PCRE.g:912:7: 'P'
			{
			match('P'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUC"

	// $ANTLR start "QUC"
	public final void mQUC() throws RecognitionException {
		try {
			int _type = QUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:913:5: ( 'Q' )
			// PCRE.g:913:7: 'Q'
			{
			match('Q'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUC"

	// $ANTLR start "RUC"
	public final void mRUC() throws RecognitionException {
		try {
			int _type = RUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:914:5: ( 'R' )
			// PCRE.g:914:7: 'R'
			{
			match('R'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RUC"

	// $ANTLR start "SUC"
	public final void mSUC() throws RecognitionException {
		try {
			int _type = SUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:915:5: ( 'S' )
			// PCRE.g:915:7: 'S'
			{
			match('S'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUC"

	// $ANTLR start "TUC"
	public final void mTUC() throws RecognitionException {
		try {
			int _type = TUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:916:5: ( 'T' )
			// PCRE.g:916:7: 'T'
			{
			match('T'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TUC"

	// $ANTLR start "UUC"
	public final void mUUC() throws RecognitionException {
		try {
			int _type = UUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:917:5: ( 'U' )
			// PCRE.g:917:7: 'U'
			{
			match('U'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UUC"

	// $ANTLR start "VUC"
	public final void mVUC() throws RecognitionException {
		try {
			int _type = VUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:918:5: ( 'V' )
			// PCRE.g:918:7: 'V'
			{
			match('V'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VUC"

	// $ANTLR start "WUC"
	public final void mWUC() throws RecognitionException {
		try {
			int _type = WUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:919:5: ( 'W' )
			// PCRE.g:919:7: 'W'
			{
			match('W'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WUC"

	// $ANTLR start "XUC"
	public final void mXUC() throws RecognitionException {
		try {
			int _type = XUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:920:5: ( 'X' )
			// PCRE.g:920:7: 'X'
			{
			match('X'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XUC"

	// $ANTLR start "YUC"
	public final void mYUC() throws RecognitionException {
		try {
			int _type = YUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:921:5: ( 'Y' )
			// PCRE.g:921:7: 'Y'
			{
			match('Y'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "YUC"

	// $ANTLR start "ZUC"
	public final void mZUC() throws RecognitionException {
		try {
			int _type = ZUC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:922:5: ( 'Z' )
			// PCRE.g:922:7: 'Z'
			{
			match('Z'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ZUC"

	// $ANTLR start "D1"
	public final void mD1() throws RecognitionException {
		try {
			int _type = D1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:924:4: ( '1' )
			// PCRE.g:924:6: '1'
			{
			match('1'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D1"

	// $ANTLR start "D2"
	public final void mD2() throws RecognitionException {
		try {
			int _type = D2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:925:4: ( '2' )
			// PCRE.g:925:6: '2'
			{
			match('2'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D2"

	// $ANTLR start "D3"
	public final void mD3() throws RecognitionException {
		try {
			int _type = D3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:926:4: ( '3' )
			// PCRE.g:926:6: '3'
			{
			match('3'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D3"

	// $ANTLR start "D4"
	public final void mD4() throws RecognitionException {
		try {
			int _type = D4;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:927:4: ( '4' )
			// PCRE.g:927:6: '4'
			{
			match('4'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D4"

	// $ANTLR start "D5"
	public final void mD5() throws RecognitionException {
		try {
			int _type = D5;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:928:4: ( '5' )
			// PCRE.g:928:6: '5'
			{
			match('5'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D5"

	// $ANTLR start "D6"
	public final void mD6() throws RecognitionException {
		try {
			int _type = D6;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:929:4: ( '6' )
			// PCRE.g:929:6: '6'
			{
			match('6'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D6"

	// $ANTLR start "D7"
	public final void mD7() throws RecognitionException {
		try {
			int _type = D7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:930:4: ( '7' )
			// PCRE.g:930:6: '7'
			{
			match('7'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D7"

	// $ANTLR start "D8"
	public final void mD8() throws RecognitionException {
		try {
			int _type = D8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:931:4: ( '8' )
			// PCRE.g:931:6: '8'
			{
			match('8'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D8"

	// $ANTLR start "D9"
	public final void mD9() throws RecognitionException {
		try {
			int _type = D9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:932:4: ( '9' )
			// PCRE.g:932:6: '9'
			{
			match('9'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D9"

	// $ANTLR start "D0"
	public final void mD0() throws RecognitionException {
		try {
			int _type = D0;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:933:4: ( '0' )
			// PCRE.g:933:6: '0'
			{
			match('0'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D0"

	// $ANTLR start "OtherChar"
	public final void mOtherChar() throws RecognitionException {
		try {
			int _type = OtherChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PCRE.g:935:11: ( . )
			// PCRE.g:935:13: .
			{
			matchAny(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OtherChar"

	// $ANTLR start "UnderscoreAlphaNumerics"
	public final void mUnderscoreAlphaNumerics() throws RecognitionException {
		try {
			// PCRE.g:938:34: ( ( '_' | AlphaNumeric )+ )
			// PCRE.g:938:36: ( '_' | AlphaNumeric )+
			{
			// PCRE.g:938:36: ( '_' | AlphaNumeric )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// PCRE.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UnderscoreAlphaNumerics"

	// $ANTLR start "AlphaNumerics"
	public final void mAlphaNumerics() throws RecognitionException {
		try {
			// PCRE.g:939:34: ( ( AlphaNumeric )+ )
			// PCRE.g:939:36: ( AlphaNumeric )+
			{
			// PCRE.g:939:36: ( AlphaNumeric )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// PCRE.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AlphaNumerics"

	// $ANTLR start "AlphaNumeric"
	public final void mAlphaNumeric() throws RecognitionException {
		try {
			// PCRE.g:940:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
			// PCRE.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AlphaNumeric"

	// $ANTLR start "NonAlphaNumeric"
	public final void mNonAlphaNumeric() throws RecognitionException {
		try {
			// PCRE.g:941:34: (~ AlphaNumeric )
			// PCRE.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '/')||(input.LA(1) >= ':' && input.LA(1) <= '@')||(input.LA(1) >= '[' && input.LA(1) <= '`')||(input.LA(1) >= '{' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NonAlphaNumeric"

	// $ANTLR start "HexDigit"
	public final void mHexDigit() throws RecognitionException {
		try {
			// PCRE.g:942:34: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// PCRE.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HexDigit"

	// $ANTLR start "ASCII"
	public final void mASCII() throws RecognitionException {
		try {
			// PCRE.g:943:34: ( '\\u0000' .. '\\u007F' )
			// PCRE.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\u007F') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASCII"

	@Override
	public void mTokens() throws RecognitionException {
		// PCRE.g:1:8: ( Quoted | BlockQuoted | BellChar | ControlChar | EscapeChar | FormFeed | NewLine | CarriageReturn | Tab | Backslash | HexChar | Dot | OneDataUnit | DecimalDigit | NotDecimalDigit | HorizontalWhiteSpace | NotHorizontalWhiteSpace | NotNewLine | CharWithProperty | CharWithoutProperty | NewLineSequence | WhiteSpace | NotWhiteSpace | VerticalWhiteSpace | NotVerticalWhiteSpace | WordChar | NotWordChar | ExtendedUnicodeChar | CharacterClassStart | CharacterClassEnd | Caret | Hyphen | POSIXNamedSet | POSIXNegatedNamedSet | QuestionMark | Plus | Star | OpenBrace | CloseBrace | Comma | WordBoundary | NonWordBoundary | StartOfSubject | EndOfSubjectOrLine | EndOfSubjectOrLineEndOfSubject | EndOfSubject | PreviousMatchInSubject | ResetStartMatch | SubroutineOrNamedReferenceStartG | NamedReferenceStartK | Pipe | OpenParen | CloseParen | LessThan | GreaterThan | SingleQuote | Underscore | Colon | Hash | Equals | Exclamation | Ampersand | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D0 | OtherChar )
		int alt6=125;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// PCRE.g:1:10: Quoted
				{
				mQuoted(); 

				}
				break;
			case 2 :
				// PCRE.g:1:17: BlockQuoted
				{
				mBlockQuoted(); 

				}
				break;
			case 3 :
				// PCRE.g:1:29: BellChar
				{
				mBellChar(); 

				}
				break;
			case 4 :
				// PCRE.g:1:38: ControlChar
				{
				mControlChar(); 

				}
				break;
			case 5 :
				// PCRE.g:1:50: EscapeChar
				{
				mEscapeChar(); 

				}
				break;
			case 6 :
				// PCRE.g:1:61: FormFeed
				{
				mFormFeed(); 

				}
				break;
			case 7 :
				// PCRE.g:1:70: NewLine
				{
				mNewLine(); 

				}
				break;
			case 8 :
				// PCRE.g:1:78: CarriageReturn
				{
				mCarriageReturn(); 

				}
				break;
			case 9 :
				// PCRE.g:1:93: Tab
				{
				mTab(); 

				}
				break;
			case 10 :
				// PCRE.g:1:97: Backslash
				{
				mBackslash(); 

				}
				break;
			case 11 :
				// PCRE.g:1:107: HexChar
				{
				mHexChar(); 

				}
				break;
			case 12 :
				// PCRE.g:1:115: Dot
				{
				mDot(); 

				}
				break;
			case 13 :
				// PCRE.g:1:119: OneDataUnit
				{
				mOneDataUnit(); 

				}
				break;
			case 14 :
				// PCRE.g:1:131: DecimalDigit
				{
				mDecimalDigit(); 

				}
				break;
			case 15 :
				// PCRE.g:1:144: NotDecimalDigit
				{
				mNotDecimalDigit(); 

				}
				break;
			case 16 :
				// PCRE.g:1:160: HorizontalWhiteSpace
				{
				mHorizontalWhiteSpace(); 

				}
				break;
			case 17 :
				// PCRE.g:1:181: NotHorizontalWhiteSpace
				{
				mNotHorizontalWhiteSpace(); 

				}
				break;
			case 18 :
				// PCRE.g:1:205: NotNewLine
				{
				mNotNewLine(); 

				}
				break;
			case 19 :
				// PCRE.g:1:216: CharWithProperty
				{
				mCharWithProperty(); 

				}
				break;
			case 20 :
				// PCRE.g:1:233: CharWithoutProperty
				{
				mCharWithoutProperty(); 

				}
				break;
			case 21 :
				// PCRE.g:1:253: NewLineSequence
				{
				mNewLineSequence(); 

				}
				break;
			case 22 :
				// PCRE.g:1:269: WhiteSpace
				{
				mWhiteSpace(); 

				}
				break;
			case 23 :
				// PCRE.g:1:280: NotWhiteSpace
				{
				mNotWhiteSpace(); 

				}
				break;
			case 24 :
				// PCRE.g:1:294: VerticalWhiteSpace
				{
				mVerticalWhiteSpace(); 

				}
				break;
			case 25 :
				// PCRE.g:1:313: NotVerticalWhiteSpace
				{
				mNotVerticalWhiteSpace(); 

				}
				break;
			case 26 :
				// PCRE.g:1:335: WordChar
				{
				mWordChar(); 

				}
				break;
			case 27 :
				// PCRE.g:1:344: NotWordChar
				{
				mNotWordChar(); 

				}
				break;
			case 28 :
				// PCRE.g:1:356: ExtendedUnicodeChar
				{
				mExtendedUnicodeChar(); 

				}
				break;
			case 29 :
				// PCRE.g:1:376: CharacterClassStart
				{
				mCharacterClassStart(); 

				}
				break;
			case 30 :
				// PCRE.g:1:396: CharacterClassEnd
				{
				mCharacterClassEnd(); 

				}
				break;
			case 31 :
				// PCRE.g:1:414: Caret
				{
				mCaret(); 

				}
				break;
			case 32 :
				// PCRE.g:1:420: Hyphen
				{
				mHyphen(); 

				}
				break;
			case 33 :
				// PCRE.g:1:427: POSIXNamedSet
				{
				mPOSIXNamedSet(); 

				}
				break;
			case 34 :
				// PCRE.g:1:441: POSIXNegatedNamedSet
				{
				mPOSIXNegatedNamedSet(); 

				}
				break;
			case 35 :
				// PCRE.g:1:462: QuestionMark
				{
				mQuestionMark(); 

				}
				break;
			case 36 :
				// PCRE.g:1:475: Plus
				{
				mPlus(); 

				}
				break;
			case 37 :
				// PCRE.g:1:480: Star
				{
				mStar(); 

				}
				break;
			case 38 :
				// PCRE.g:1:485: OpenBrace
				{
				mOpenBrace(); 

				}
				break;
			case 39 :
				// PCRE.g:1:495: CloseBrace
				{
				mCloseBrace(); 

				}
				break;
			case 40 :
				// PCRE.g:1:506: Comma
				{
				mComma(); 

				}
				break;
			case 41 :
				// PCRE.g:1:512: WordBoundary
				{
				mWordBoundary(); 

				}
				break;
			case 42 :
				// PCRE.g:1:525: NonWordBoundary
				{
				mNonWordBoundary(); 

				}
				break;
			case 43 :
				// PCRE.g:1:541: StartOfSubject
				{
				mStartOfSubject(); 

				}
				break;
			case 44 :
				// PCRE.g:1:556: EndOfSubjectOrLine
				{
				mEndOfSubjectOrLine(); 

				}
				break;
			case 45 :
				// PCRE.g:1:575: EndOfSubjectOrLineEndOfSubject
				{
				mEndOfSubjectOrLineEndOfSubject(); 

				}
				break;
			case 46 :
				// PCRE.g:1:606: EndOfSubject
				{
				mEndOfSubject(); 

				}
				break;
			case 47 :
				// PCRE.g:1:619: PreviousMatchInSubject
				{
				mPreviousMatchInSubject(); 

				}
				break;
			case 48 :
				// PCRE.g:1:642: ResetStartMatch
				{
				mResetStartMatch(); 

				}
				break;
			case 49 :
				// PCRE.g:1:658: SubroutineOrNamedReferenceStartG
				{
				mSubroutineOrNamedReferenceStartG(); 

				}
				break;
			case 50 :
				// PCRE.g:1:691: NamedReferenceStartK
				{
				mNamedReferenceStartK(); 

				}
				break;
			case 51 :
				// PCRE.g:1:712: Pipe
				{
				mPipe(); 

				}
				break;
			case 52 :
				// PCRE.g:1:717: OpenParen
				{
				mOpenParen(); 

				}
				break;
			case 53 :
				// PCRE.g:1:727: CloseParen
				{
				mCloseParen(); 

				}
				break;
			case 54 :
				// PCRE.g:1:738: LessThan
				{
				mLessThan(); 

				}
				break;
			case 55 :
				// PCRE.g:1:747: GreaterThan
				{
				mGreaterThan(); 

				}
				break;
			case 56 :
				// PCRE.g:1:759: SingleQuote
				{
				mSingleQuote(); 

				}
				break;
			case 57 :
				// PCRE.g:1:771: Underscore
				{
				mUnderscore(); 

				}
				break;
			case 58 :
				// PCRE.g:1:782: Colon
				{
				mColon(); 

				}
				break;
			case 59 :
				// PCRE.g:1:788: Hash
				{
				mHash(); 

				}
				break;
			case 60 :
				// PCRE.g:1:793: Equals
				{
				mEquals(); 

				}
				break;
			case 61 :
				// PCRE.g:1:800: Exclamation
				{
				mExclamation(); 

				}
				break;
			case 62 :
				// PCRE.g:1:812: Ampersand
				{
				mAmpersand(); 

				}
				break;
			case 63 :
				// PCRE.g:1:822: ALC
				{
				mALC(); 

				}
				break;
			case 64 :
				// PCRE.g:1:826: BLC
				{
				mBLC(); 

				}
				break;
			case 65 :
				// PCRE.g:1:830: CLC
				{
				mCLC(); 

				}
				break;
			case 66 :
				// PCRE.g:1:834: DLC
				{
				mDLC(); 

				}
				break;
			case 67 :
				// PCRE.g:1:838: ELC
				{
				mELC(); 

				}
				break;
			case 68 :
				// PCRE.g:1:842: FLC
				{
				mFLC(); 

				}
				break;
			case 69 :
				// PCRE.g:1:846: GLC
				{
				mGLC(); 

				}
				break;
			case 70 :
				// PCRE.g:1:850: HLC
				{
				mHLC(); 

				}
				break;
			case 71 :
				// PCRE.g:1:854: ILC
				{
				mILC(); 

				}
				break;
			case 72 :
				// PCRE.g:1:858: JLC
				{
				mJLC(); 

				}
				break;
			case 73 :
				// PCRE.g:1:862: KLC
				{
				mKLC(); 

				}
				break;
			case 74 :
				// PCRE.g:1:866: LLC
				{
				mLLC(); 

				}
				break;
			case 75 :
				// PCRE.g:1:870: MLC
				{
				mMLC(); 

				}
				break;
			case 76 :
				// PCRE.g:1:874: NLC
				{
				mNLC(); 

				}
				break;
			case 77 :
				// PCRE.g:1:878: OLC
				{
				mOLC(); 

				}
				break;
			case 78 :
				// PCRE.g:1:882: PLC
				{
				mPLC(); 

				}
				break;
			case 79 :
				// PCRE.g:1:886: QLC
				{
				mQLC(); 

				}
				break;
			case 80 :
				// PCRE.g:1:890: RLC
				{
				mRLC(); 

				}
				break;
			case 81 :
				// PCRE.g:1:894: SLC
				{
				mSLC(); 

				}
				break;
			case 82 :
				// PCRE.g:1:898: TLC
				{
				mTLC(); 

				}
				break;
			case 83 :
				// PCRE.g:1:902: ULC
				{
				mULC(); 

				}
				break;
			case 84 :
				// PCRE.g:1:906: VLC
				{
				mVLC(); 

				}
				break;
			case 85 :
				// PCRE.g:1:910: WLC
				{
				mWLC(); 

				}
				break;
			case 86 :
				// PCRE.g:1:914: XLC
				{
				mXLC(); 

				}
				break;
			case 87 :
				// PCRE.g:1:918: YLC
				{
				mYLC(); 

				}
				break;
			case 88 :
				// PCRE.g:1:922: ZLC
				{
				mZLC(); 

				}
				break;
			case 89 :
				// PCRE.g:1:926: AUC
				{
				mAUC(); 

				}
				break;
			case 90 :
				// PCRE.g:1:930: BUC
				{
				mBUC(); 

				}
				break;
			case 91 :
				// PCRE.g:1:934: CUC
				{
				mCUC(); 

				}
				break;
			case 92 :
				// PCRE.g:1:938: DUC
				{
				mDUC(); 

				}
				break;
			case 93 :
				// PCRE.g:1:942: EUC
				{
				mEUC(); 

				}
				break;
			case 94 :
				// PCRE.g:1:946: FUC
				{
				mFUC(); 

				}
				break;
			case 95 :
				// PCRE.g:1:950: GUC
				{
				mGUC(); 

				}
				break;
			case 96 :
				// PCRE.g:1:954: HUC
				{
				mHUC(); 

				}
				break;
			case 97 :
				// PCRE.g:1:958: IUC
				{
				mIUC(); 

				}
				break;
			case 98 :
				// PCRE.g:1:962: JUC
				{
				mJUC(); 

				}
				break;
			case 99 :
				// PCRE.g:1:966: KUC
				{
				mKUC(); 

				}
				break;
			case 100 :
				// PCRE.g:1:970: LUC
				{
				mLUC(); 

				}
				break;
			case 101 :
				// PCRE.g:1:974: MUC
				{
				mMUC(); 

				}
				break;
			case 102 :
				// PCRE.g:1:978: NUC
				{
				mNUC(); 

				}
				break;
			case 103 :
				// PCRE.g:1:982: OUC
				{
				mOUC(); 

				}
				break;
			case 104 :
				// PCRE.g:1:986: PUC
				{
				mPUC(); 

				}
				break;
			case 105 :
				// PCRE.g:1:990: QUC
				{
				mQUC(); 

				}
				break;
			case 106 :
				// PCRE.g:1:994: RUC
				{
				mRUC(); 

				}
				break;
			case 107 :
				// PCRE.g:1:998: SUC
				{
				mSUC(); 

				}
				break;
			case 108 :
				// PCRE.g:1:1002: TUC
				{
				mTUC(); 

				}
				break;
			case 109 :
				// PCRE.g:1:1006: UUC
				{
				mUUC(); 

				}
				break;
			case 110 :
				// PCRE.g:1:1010: VUC
				{
				mVUC(); 

				}
				break;
			case 111 :
				// PCRE.g:1:1014: WUC
				{
				mWUC(); 

				}
				break;
			case 112 :
				// PCRE.g:1:1018: XUC
				{
				mXUC(); 

				}
				break;
			case 113 :
				// PCRE.g:1:1022: YUC
				{
				mYUC(); 

				}
				break;
			case 114 :
				// PCRE.g:1:1026: ZUC
				{
				mZUC(); 

				}
				break;
			case 115 :
				// PCRE.g:1:1030: D1
				{
				mD1(); 

				}
				break;
			case 116 :
				// PCRE.g:1:1033: D2
				{
				mD2(); 

				}
				break;
			case 117 :
				// PCRE.g:1:1036: D3
				{
				mD3(); 

				}
				break;
			case 118 :
				// PCRE.g:1:1039: D4
				{
				mD4(); 

				}
				break;
			case 119 :
				// PCRE.g:1:1042: D5
				{
				mD5(); 

				}
				break;
			case 120 :
				// PCRE.g:1:1045: D6
				{
				mD6(); 

				}
				break;
			case 121 :
				// PCRE.g:1:1048: D7
				{
				mD7(); 

				}
				break;
			case 122 :
				// PCRE.g:1:1051: D8
				{
				mD8(); 

				}
				break;
			case 123 :
				// PCRE.g:1:1054: D9
				{
				mD9(); 

				}
				break;
			case 124 :
				// PCRE.g:1:1057: D0
				{
				mD0(); 

				}
				break;
			case 125 :
				// PCRE.g:1:1060: OtherChar
				{
				mOtherChar(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\1\uffff\1\174\1\uffff\1\177\u00d3\uffff";
	static final String DFA6_eofS =
		"\u00d7\uffff";
	static final String DFA6_minS =
		"\2\0\1\uffff\1\133\172\uffff\1\72\125\uffff\1\60\2\uffff";
	static final String DFA6_maxS =
		"\2\uffff\1\uffff\1\133\172\uffff\1\72\125\uffff\1\172\2\uffff";
	static final String DFA6_acceptS =
		"\2\uffff\1\14\1\uffff\1\36\1\37\1\40\1\43\1\44\1\45\1\46\1\47\1\50\1\54"+
		"\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100"+
		"\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114"+
		"\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130"+
		"\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144"+
		"\1\145\1\146\1\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160"+
		"\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\170\1\171\1\172\1\173\1\174"+
		"\1\175\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\13\1\15\1\16\1\17\1\20\1\21"+
		"\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\51\1\52\1\53"+
		"\1\55\1\56\1\57\1\60\1\61\1\62\1\1\1\12\1\14\1\uffff\1\35\1\36\1\37\1"+
		"\40\1\43\1\44\1\45\1\46\1\47\1\50\1\54\1\63\1\64\1\65\1\66\1\67\1\70\1"+
		"\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105"+
		"\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
		"\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\135"+
		"\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\145\1\146\1\147\1\150\1\151"+
		"\1\152\1\153\1\154\1\155\1\156\1\157\1\160\1\161\1\162\1\163\1\164\1\165"+
		"\1\166\1\167\1\170\1\171\1\172\1\173\1\174\1\uffff\1\42\1\41";
	static final String DFA6_specialS =
		"\1\1\1\0\u00d5\uffff}>";
	static final String[] DFA6_transitionS = {
			"\41\130\1\30\1\130\1\26\1\15\1\130\1\31\1\23\1\17\1\20\1\11\1\10\1\14"+
			"\1\6\1\2\1\130\1\127\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125"+
			"\1\126\1\25\1\130\1\21\1\27\1\22\1\7\1\130\1\64\1\65\1\66\1\67\1\70\1"+
			"\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105"+
			"\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\3\1\1\1\4\1\5\1\24"+
			"\1\130\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1"+
			"\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
			"\1\12\1\16\1\13\uff82\130",
			"\60\173\12\uffff\7\173\1\164\1\163\1\142\1\144\2\uffff\1\167\1\146\2"+
			"\uffff\1\170\2\uffff\1\147\1\uffff\1\151\1\131\1\152\1\154\2\uffff\1"+
			"\156\1\160\1\161\1\uffff\1\165\6\173\1\132\1\162\1\133\1\143\1\134\1"+
			"\135\1\171\1\145\2\uffff\1\172\2\uffff\1\136\1\uffff\1\150\1\uffff\1"+
			"\137\1\153\1\140\1\uffff\1\155\1\157\1\141\1\uffff\1\166\uff85\173",
			"",
			"\1\176",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00d4",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\u00d6\7\uffff\32\u00d6\3\uffff\1\u00d5\2\uffff\32\u00d6",
			"",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( Quoted | BlockQuoted | BellChar | ControlChar | EscapeChar | FormFeed | NewLine | CarriageReturn | Tab | Backslash | HexChar | Dot | OneDataUnit | DecimalDigit | NotDecimalDigit | HorizontalWhiteSpace | NotHorizontalWhiteSpace | NotNewLine | CharWithProperty | CharWithoutProperty | NewLineSequence | WhiteSpace | NotWhiteSpace | VerticalWhiteSpace | NotVerticalWhiteSpace | WordChar | NotWordChar | ExtendedUnicodeChar | CharacterClassStart | CharacterClassEnd | Caret | Hyphen | POSIXNamedSet | POSIXNegatedNamedSet | QuestionMark | Plus | Star | OpenBrace | CloseBrace | Comma | WordBoundary | NonWordBoundary | StartOfSubject | EndOfSubjectOrLine | EndOfSubjectOrLineEndOfSubject | EndOfSubject | PreviousMatchInSubject | ResetStartMatch | SubroutineOrNamedReferenceStartG | NamedReferenceStartK | Pipe | OpenParen | CloseParen | LessThan | GreaterThan | SingleQuote | Underscore | Colon | Hash | Equals | Exclamation | Ampersand | ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D0 | OtherChar );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_1 = input.LA(1);
						s = -1;
						if ( (LA6_1=='Q') ) {s = 89;}
						else if ( (LA6_1=='a') ) {s = 90;}
						else if ( (LA6_1=='c') ) {s = 91;}
						else if ( (LA6_1=='e') ) {s = 92;}
						else if ( (LA6_1=='f') ) {s = 93;}
						else if ( (LA6_1=='n') ) {s = 94;}
						else if ( (LA6_1=='r') ) {s = 95;}
						else if ( (LA6_1=='t') ) {s = 96;}
						else if ( (LA6_1=='x') ) {s = 97;}
						else if ( (LA6_1=='C') ) {s = 98;}
						else if ( (LA6_1=='d') ) {s = 99;}
						else if ( (LA6_1=='D') ) {s = 100;}
						else if ( (LA6_1=='h') ) {s = 101;}
						else if ( (LA6_1=='H') ) {s = 102;}
						else if ( (LA6_1=='N') ) {s = 103;}
						else if ( (LA6_1=='p') ) {s = 104;}
						else if ( (LA6_1=='P') ) {s = 105;}
						else if ( (LA6_1=='R') ) {s = 106;}
						else if ( (LA6_1=='s') ) {s = 107;}
						else if ( (LA6_1=='S') ) {s = 108;}
						else if ( (LA6_1=='v') ) {s = 109;}
						else if ( (LA6_1=='V') ) {s = 110;}
						else if ( (LA6_1=='w') ) {s = 111;}
						else if ( (LA6_1=='W') ) {s = 112;}
						else if ( (LA6_1=='X') ) {s = 113;}
						else if ( (LA6_1=='b') ) {s = 114;}
						else if ( (LA6_1=='B') ) {s = 115;}
						else if ( (LA6_1=='A') ) {s = 116;}
						else if ( (LA6_1=='Z') ) {s = 117;}
						else if ( (LA6_1=='z') ) {s = 118;}
						else if ( (LA6_1=='G') ) {s = 119;}
						else if ( (LA6_1=='K') ) {s = 120;}
						else if ( (LA6_1=='g') ) {s = 121;}
						else if ( (LA6_1=='k') ) {s = 122;}
						else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '/')||(LA6_1 >= ':' && LA6_1 <= '@')||(LA6_1 >= '[' && LA6_1 <= '`')||(LA6_1 >= '{' && LA6_1 <= '\uFFFF')) ) {s = 123;}
						else s = 124;
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0=='\\') ) {s = 1;}
						else if ( (LA6_0=='.') ) {s = 2;}
						else if ( (LA6_0=='[') ) {s = 3;}
						else if ( (LA6_0==']') ) {s = 4;}
						else if ( (LA6_0=='^') ) {s = 5;}
						else if ( (LA6_0=='-') ) {s = 6;}
						else if ( (LA6_0=='?') ) {s = 7;}
						else if ( (LA6_0=='+') ) {s = 8;}
						else if ( (LA6_0=='*') ) {s = 9;}
						else if ( (LA6_0=='{') ) {s = 10;}
						else if ( (LA6_0=='}') ) {s = 11;}
						else if ( (LA6_0==',') ) {s = 12;}
						else if ( (LA6_0=='$') ) {s = 13;}
						else if ( (LA6_0=='|') ) {s = 14;}
						else if ( (LA6_0=='(') ) {s = 15;}
						else if ( (LA6_0==')') ) {s = 16;}
						else if ( (LA6_0=='<') ) {s = 17;}
						else if ( (LA6_0=='>') ) {s = 18;}
						else if ( (LA6_0=='\'') ) {s = 19;}
						else if ( (LA6_0=='_') ) {s = 20;}
						else if ( (LA6_0==':') ) {s = 21;}
						else if ( (LA6_0=='#') ) {s = 22;}
						else if ( (LA6_0=='=') ) {s = 23;}
						else if ( (LA6_0=='!') ) {s = 24;}
						else if ( (LA6_0=='&') ) {s = 25;}
						else if ( (LA6_0=='a') ) {s = 26;}
						else if ( (LA6_0=='b') ) {s = 27;}
						else if ( (LA6_0=='c') ) {s = 28;}
						else if ( (LA6_0=='d') ) {s = 29;}
						else if ( (LA6_0=='e') ) {s = 30;}
						else if ( (LA6_0=='f') ) {s = 31;}
						else if ( (LA6_0=='g') ) {s = 32;}
						else if ( (LA6_0=='h') ) {s = 33;}
						else if ( (LA6_0=='i') ) {s = 34;}
						else if ( (LA6_0=='j') ) {s = 35;}
						else if ( (LA6_0=='k') ) {s = 36;}
						else if ( (LA6_0=='l') ) {s = 37;}
						else if ( (LA6_0=='m') ) {s = 38;}
						else if ( (LA6_0=='n') ) {s = 39;}
						else if ( (LA6_0=='o') ) {s = 40;}
						else if ( (LA6_0=='p') ) {s = 41;}
						else if ( (LA6_0=='q') ) {s = 42;}
						else if ( (LA6_0=='r') ) {s = 43;}
						else if ( (LA6_0=='s') ) {s = 44;}
						else if ( (LA6_0=='t') ) {s = 45;}
						else if ( (LA6_0=='u') ) {s = 46;}
						else if ( (LA6_0=='v') ) {s = 47;}
						else if ( (LA6_0=='w') ) {s = 48;}
						else if ( (LA6_0=='x') ) {s = 49;}
						else if ( (LA6_0=='y') ) {s = 50;}
						else if ( (LA6_0=='z') ) {s = 51;}
						else if ( (LA6_0=='A') ) {s = 52;}
						else if ( (LA6_0=='B') ) {s = 53;}
						else if ( (LA6_0=='C') ) {s = 54;}
						else if ( (LA6_0=='D') ) {s = 55;}
						else if ( (LA6_0=='E') ) {s = 56;}
						else if ( (LA6_0=='F') ) {s = 57;}
						else if ( (LA6_0=='G') ) {s = 58;}
						else if ( (LA6_0=='H') ) {s = 59;}
						else if ( (LA6_0=='I') ) {s = 60;}
						else if ( (LA6_0=='J') ) {s = 61;}
						else if ( (LA6_0=='K') ) {s = 62;}
						else if ( (LA6_0=='L') ) {s = 63;}
						else if ( (LA6_0=='M') ) {s = 64;}
						else if ( (LA6_0=='N') ) {s = 65;}
						else if ( (LA6_0=='O') ) {s = 66;}
						else if ( (LA6_0=='P') ) {s = 67;}
						else if ( (LA6_0=='Q') ) {s = 68;}
						else if ( (LA6_0=='R') ) {s = 69;}
						else if ( (LA6_0=='S') ) {s = 70;}
						else if ( (LA6_0=='T') ) {s = 71;}
						else if ( (LA6_0=='U') ) {s = 72;}
						else if ( (LA6_0=='V') ) {s = 73;}
						else if ( (LA6_0=='W') ) {s = 74;}
						else if ( (LA6_0=='X') ) {s = 75;}
						else if ( (LA6_0=='Y') ) {s = 76;}
						else if ( (LA6_0=='Z') ) {s = 77;}
						else if ( (LA6_0=='1') ) {s = 78;}
						else if ( (LA6_0=='2') ) {s = 79;}
						else if ( (LA6_0=='3') ) {s = 80;}
						else if ( (LA6_0=='4') ) {s = 81;}
						else if ( (LA6_0=='5') ) {s = 82;}
						else if ( (LA6_0=='6') ) {s = 83;}
						else if ( (LA6_0=='7') ) {s = 84;}
						else if ( (LA6_0=='8') ) {s = 85;}
						else if ( (LA6_0=='9') ) {s = 86;}
						else if ( (LA6_0=='0') ) {s = 87;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ' ')||LA6_0=='\"'||LA6_0=='%'||LA6_0=='/'||LA6_0==';'||LA6_0=='@'||LA6_0=='`'||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 88;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 6, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
