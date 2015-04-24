// $ANTLR 3.5.2 PCRE.g 2014-07-20 13:43:39

  package pcre;

  import java.util.Map;
import java.util.TreeMap;

import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

import metric.FeatureDictionary;


@SuppressWarnings("all")
public class PCREParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALC", "ALTERNATIVE", "ANY", "ASCII", 
		"ASSERT", "ATOMIC_GROUP", "AUC", "AlphaNumeric", "AlphaNumerics", "Ampersand", 
		"BACKTACK_CONTROL_ACCEPT", "BACKTACK_CONTROL_COMMIT", "BACKTACK_CONTROL_FAIL", 
		"BACKTACK_CONTROL_MARK_NAME", "BACKTACK_CONTROL_PRUNE", "BACKTACK_CONTROL_PRUNE_NAME", 
		"BACKTACK_CONTROL_SKIP", "BACKTACK_CONTROL_SKIP_NAME", "BACKTACK_CONTROL_THEN", 
		"BACKTACK_CONTROL_THEN_NAME", "BLC", "BUC", "Backslash", "BellChar", "BlockQuoted", 
		"CALLOUT", "CAPTURING_GROUP", "CHARACTER_CLASS", "CLC", "COMMENT", "CUC", 
		"Caret", "CarriageReturn", "CharWithProperty", "CharWithoutProperty", 
		"CharacterClassEnd", "CharacterClassStart", "CloseBrace", "CloseParen", 
		"Colon", "Comma", "ControlChar", "D0", "D1", "D2", "D3", "D4", "D5", "D6", 
		"D7", "D8", "D9", "DEFINE", "DLC", "DUC", "DecimalDigit", "Dot", "ELC", 
		"ELEMENT", "EUC", "EndOfSubject", "EndOfSubjectOrLine", "EndOfSubjectOrLineEndOfSubject", 
		"Equals", "EscapeChar", "Exclamation", "ExtendedUnicodeChar", "FLC", "FUC", 
		"FormFeed", "GLC", "GREEDY", "GUC", "GreaterThan", "HLC", "HUC", "Hash", 
		"HexChar", "HexDigit", "HorizontalWhiteSpace", "Hyphen", "ILC", "IUC", 
		"JLC", "JUC", "KLC", "KUC", "LAZY", "LITERAL", "LLC", "LOOK_AHEAD", "LOOK_BEHIND", 
		"LUC", "LessThan", "MLC", "MUC", "NAME", "NAMED_BACKREFERENCE_NET", "NAMED_BACKREFERENCE_PERL", 
		"NAMED_BACKREFERENCE_PYTHON", "NAMED_CAPTURING_GROUP_PERL", "NAMED_CAPTURING_GROUP_PYTHON", 
		"NAMED_REFERENCE_CONDITION", "NAMED_REFERENCE_CONDITION_PERL", "NAMED_REFERENCE_ONIGURUMA", 
		"NAMED_REFERENCE_PERL", "NAMED_REFERENCE_PYTHON", "NEGATED_CHARACTER_CLASS", 
		"NEGATIVE_LOOK_AHEAD", "NEGATIVE_LOOK_BEHIND", "NEWLINE_CONVENTION_ANY", 
		"NEWLINE_CONVENTION_ANYCRLF", "NEWLINE_CONVENTION_BSR_ANYCRLF", "NEWLINE_CONVENTION_BSR_UNICODE", 
		"NEWLINE_CONVENTION_CR", "NEWLINE_CONVENTION_CRLF", "NEWLINE_CONVENTION_LF", 
		"NLC", "NO", "NON_CAPTURING_GROUP", "NON_CAPTURING_GROUP_RESET", "NUC", 
		"NUMBER", "NUMBERED_BACKREFERENCE", "NUMBERED_REFERENCE_ABSOLUTE", "NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA", 
		"NUMBERED_REFERENCE_RELATIVE_MINUS", "NUMBERED_REFERENCE_RELATIVE_PLUS", 
		"NamedReferenceStartK", "NewLine", "NewLineSequence", "NonAlphaNumeric", 
		"NonWordBoundary", "NotDecimalDigit", "NotHorizontalWhiteSpace", "NotNewLine", 
		"NotVerticalWhiteSpace", "NotWhiteSpace", "NotWordChar", "OLC", "OPTION", 
		"OPTIONS", "OPTIONS_NO_START_OPT", "OPTIONS_UCP", "OPTIONS_UTF16", "OPTIONS_UTF8", 
		"OR", "OUC", "OVERALL_RECURSION_CONDITION", "OneDataUnit", "OpenBrace", 
		"OpenParen", "OtherChar", "PLC", "POSIXNamedSet", "POSIXNegatedNamedSet", 
		"POSSESSIVE", "PUC", "Pipe", "Plus", "PreviousMatchInSubject", "QLC", 
		"QUANTIFIER", "QUC", "QuestionMark", "Quoted", "RANGE", "REFERENCE_CONDITION_ABSOLUTE", 
		"REFERENCE_CONDITION_RELATIVE_MINUS", "REFERENCE_CONDITION_RELATIVE_PLUS", 
		"RELATIVE_NUMBERED_BACKREFERENCE", "RLC", "RUC", "ResetStartMatch", "SET", 
		"SLC", "SPECIFIC_GROUP_RECURSION_CONDITION", "SPECIFIC_RECURSION_CONDITION", 
		"START_OF_SUBJECT", "SUC", "SingleQuote", "Star", "StartOfSubject", "SubroutineOrNamedReferenceStartG", 
		"TLC", "TUC", "Tab", "ULC", "UNSET", "UUC", "Underscore", "UnderscoreAlphaNumerics", 
		"VLC", "VUC", "VerticalWhiteSpace", "WLC", "WUC", "WhiteSpace", "WordBoundary", 
		"WordChar", "XLC", "XUC", "YES", "YLC", "YUC", "ZLC", "ZUC","REPETITION_TYPE"
	};
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
	public static final int REPETITION_TYPE=211;
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PCREParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PCREParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[300+1];


	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return PCREParser.tokenNames; }
	@Override public String getGrammarFileName() { return "PCRE.g"; }



	  public static final String HUGE_NUMBER = String.valueOf(Integer.MAX_VALUE);
	  
	  protected Map<Integer, ParserRuleReturnScope> captureReturns = new TreeMap<Integer, ParserRuleReturnScope>();
	  protected Map<String, ParserRuleReturnScope> namedReturns = new TreeMap<String, ParserRuleReturnScope>();
	  
	  private boolean insideCharacterClass = false;
	      
	  private void addNumberedMatchGroup(ParserRuleReturnScope value) {
	    int group = captureReturns.size() + 1;
	    captureReturns.put(group, value);
	  }
	  
	  private void addNamedMatchGroup(String name, ParserRuleReturnScope value) {
	    namedReturns.put(name, value);
	  }


	public static class parse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// PCRE.g:204:1: parse : regex EOF -> regex ;
	public final PCREParser.parse_return parse() throws RecognitionException {
		PCREParser.parse_return retval = new PCREParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

		CommonTree root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope regex1 =null;

		CommonTree EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// PCRE.g:205:2: ( regex EOF -> regex )
			// PCRE.g:205:4: regex EOF
			{
			pushFollow(FOLLOW_regex_in_parse473);
			regex1=regex();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_regex.add(regex1.getTree());
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse475); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: regex
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 205:14: -> regex
			{
				adaptor.addChild(root_0, stream_regex.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "parse"


	public static class regex_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "regex"
	// PCRE.g:212:1: regex : ( first_alternative -> first_alternative ) ( ( '|' alternative )+ -> ^( OR first_alternative ( alternative )+ ) )? ;
	public final PCREParser.regex_return regex() throws RecognitionException {
		PCREParser.regex_return retval = new PCREParser.regex_return();
		retval.start = input.LT(1);
		int regex_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal4=null;
		ParserRuleReturnScope first_alternative3 =null;
		ParserRuleReturnScope alternative5 =null;

		CommonTree char_literal4_tree=null;
		RewriteRuleTokenStream stream_Pipe=new RewriteRuleTokenStream(adaptor,"token Pipe");
		RewriteRuleSubtreeStream stream_first_alternative=new RewriteRuleSubtreeStream(adaptor,"rule first_alternative");
		RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// PCRE.g:213:2: ( ( first_alternative -> first_alternative ) ( ( '|' alternative )+ -> ^( OR first_alternative ( alternative )+ ) )? )
			// PCRE.g:213:4: ( first_alternative -> first_alternative ) ( ( '|' alternative )+ -> ^( OR first_alternative ( alternative )+ ) )?
			{
			// PCRE.g:213:4: ( first_alternative -> first_alternative )
			// PCRE.g:213:5: first_alternative
			{
			pushFollow(FOLLOW_first_alternative_in_regex498);
			first_alternative3=first_alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_first_alternative.add(first_alternative3.getTree());
			// AST REWRITE
			// elements: first_alternative
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 213:23: -> first_alternative
			{
				adaptor.addChild(root_0, stream_first_alternative.nextTree());
			}


			retval.tree = root_0;
			}

			}

			// PCRE.g:213:45: ( ( '|' alternative )+ -> ^( OR first_alternative ( alternative )+ ) )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Pipe) ) {
				int LA2_1 = input.LA(2);
				if ( (synpred2_PCRE()) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// PCRE.g:213:46: ( '|' alternative )+
					{
					// PCRE.g:213:46: ( '|' alternative )+
					int cnt1=0;
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==Pipe) ) {
							int LA1_2 = input.LA(2);
							if ( (synpred1_PCRE()) ) {
								alt1=1;
							}

						}

						switch (alt1) {
						case 1 :
							// PCRE.g:213:47: '|' alternative
							{
							char_literal4=(Token)match(input,Pipe,FOLLOW_Pipe_in_regex507); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal4);

							pushFollow(FOLLOW_alternative_in_regex509);
							alternative5=alternative();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_alternative.add(alternative5.getTree());
							}
							break;

						default :
							if ( cnt1 >= 1 ) break loop1;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(1, input);
							throw eee;
						}
						cnt1++;
					}

					// AST REWRITE
					// elements: alternative, first_alternative
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 213:65: -> ^( OR first_alternative ( alternative )+ )
					{
						// PCRE.g:213:68: ^( OR first_alternative ( alternative )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OR, "OR"), root_1);
						adaptor.addChild(root_1, stream_first_alternative.nextTree());
						if ( !(stream_alternative.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_alternative.hasNext() ) {
							adaptor.addChild(root_1, stream_alternative.nextTree());
						}
						stream_alternative.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, regex_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "regex"


	public static class first_alternative_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "first_alternative"
	// PCRE.g:216:1: first_alternative : alternative ;
	public final PCREParser.first_alternative_return first_alternative() throws RecognitionException {
		PCREParser.first_alternative_return retval = new PCREParser.first_alternative_return();
		retval.start = input.LT(1);
		int first_alternative_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope alternative6 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// PCRE.g:217:2: ( alternative )
			// PCRE.g:217:4: alternative
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_alternative_in_first_alternative535);
			alternative6=alternative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, alternative6.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, first_alternative_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "first_alternative"


	public static class alternative_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alternative"
	// PCRE.g:220:1: alternative : ( element )* -> ^( ALTERNATIVE ( element )* ) ;
	public final PCREParser.alternative_return alternative() throws RecognitionException {
		PCREParser.alternative_return retval = new PCREParser.alternative_return();
		retval.start = input.LT(1);
		int alternative_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope element7 =null;

		RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// PCRE.g:221:2: ( ( element )* -> ^( ALTERNATIVE ( element )* ) )
			// PCRE.g:221:4: ( element )*
			{
			// PCRE.g:221:4: ( element )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ALC||LA3_0==AUC||LA3_0==Ampersand||(LA3_0 >= BLC && LA3_0 <= BlockQuoted)||LA3_0==CLC||(LA3_0 >= CUC && LA3_0 <= CloseBrace)||(LA3_0 >= Colon && LA3_0 <= D9)||(LA3_0 >= DLC && LA3_0 <= ELC)||(LA3_0 >= EUC && LA3_0 <= GLC)||(LA3_0 >= GUC && LA3_0 <= HexChar)||(LA3_0 >= HorizontalWhiteSpace && LA3_0 <= KUC)||LA3_0==LLC||(LA3_0 >= LUC && LA3_0 <= MUC)||LA3_0==NLC||LA3_0==NUC||(LA3_0 >= NamedReferenceStartK && LA3_0 <= NewLineSequence)||(LA3_0 >= NonWordBoundary && LA3_0 <= OLC)||LA3_0==OUC||(LA3_0 >= OneDataUnit && LA3_0 <= POSIXNegatedNamedSet)||LA3_0==PUC||(LA3_0 >= PreviousMatchInSubject && LA3_0 <= QLC)||LA3_0==QUC||LA3_0==Quoted||(LA3_0 >= RLC && LA3_0 <= ResetStartMatch)||LA3_0==SLC||(LA3_0 >= SUC && LA3_0 <= SingleQuote)||(LA3_0 >= StartOfSubject && LA3_0 <= ULC)||(LA3_0 >= UUC && LA3_0 <= Underscore)||(LA3_0 >= VLC && LA3_0 <= XUC)||(LA3_0 >= YLC && LA3_0 <= ZUC)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// PCRE.g:221:4: element
					{
					pushFollow(FOLLOW_element_in_alternative546);
					element7=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_element.add(element7.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			// AST REWRITE
			// elements: element
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 221:13: -> ^( ALTERNATIVE ( element )* )
			{
				// PCRE.g:221:16: ^( ALTERNATIVE ( element )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALTERNATIVE, "ALTERNATIVE"), root_1);
				// PCRE.g:221:30: ( element )*
				while ( stream_element.hasNext() ) {
					adaptor.addChild(root_1, stream_element.nextTree());
				}
				stream_element.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, alternative_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "alternative"


	public static class element_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "element"
	// PCRE.g:224:1: element : atom ( quantifier )? -> ^( ELEMENT atom ( quantifier )? ) ;
	public final PCREParser.element_return element() throws RecognitionException {
		PCREParser.element_return retval = new PCREParser.element_return();
		retval.start = input.LT(1);
		int element_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope atom8 =null;
		ParserRuleReturnScope quantifier9 =null;

		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_quantifier=new RewriteRuleSubtreeStream(adaptor,"rule quantifier");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// PCRE.g:225:2: ( atom ( quantifier )? -> ^( ELEMENT atom ( quantifier )? ) )
			// PCRE.g:225:4: atom ( quantifier )?
			{
			pushFollow(FOLLOW_atom_in_element567);
			atom8=atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_atom.add(atom8.getTree());
			// PCRE.g:225:9: ( quantifier )?
			int alt4=2;
			alt4 = dfa4.predict(input);
			switch (alt4) {
				case 1 :
					// PCRE.g:225:9: quantifier
					{
					pushFollow(FOLLOW_quantifier_in_element569);
					quantifier9=quantifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier.add(quantifier9.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: quantifier, atom
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 225:21: -> ^( ELEMENT atom ( quantifier )? )
			{
				// PCRE.g:225:24: ^( ELEMENT atom ( quantifier )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELEMENT, "ELEMENT"), root_1);
				adaptor.addChild(root_1, stream_atom.nextTree());
				// PCRE.g:225:39: ( quantifier )?
				if ( stream_quantifier.hasNext() ) {
					adaptor.addChild(root_1, stream_quantifier.nextTree());
				}
				stream_quantifier.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, element_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "element"


	public static class quantifier_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "quantifier"
	// PCRE.g:246:1: quantifier : ( '?' quantifier_type -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[\"1\"] quantifier_type ) | '+' quantifier_type -> ^( QUANTIFIER NUMBER[\"1\"] NUMBER[HUGE_NUMBER] quantifier_type ) | '*' quantifier_type -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[HUGE_NUMBER] quantifier_type ) | '{' number '}' quantifier_type -> ^( QUANTIFIER number number quantifier_type ) | '{' number ',' '}' quantifier_type -> ^( QUANTIFIER number NUMBER[HUGE_NUMBER] quantifier_type ) | '{' number ',' number '}' quantifier_type -> ^( QUANTIFIER number number quantifier_type ) );
	public final PCREParser.quantifier_return quantifier() throws RecognitionException {
		PCREParser.quantifier_return retval = new PCREParser.quantifier_return();
		retval.start = input.LT(1);
		int quantifier_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal10=null;
		Token char_literal12=null;
		Token char_literal14=null;
		Token char_literal16=null;
		Token char_literal18=null;
		Token char_literal20=null;
		Token char_literal22=null;
		Token char_literal23=null;
		Token char_literal25=null;
		Token char_literal27=null;
		Token char_literal29=null;
		ParserRuleReturnScope quantifier_type11 =null;
		ParserRuleReturnScope quantifier_type13 =null;
		ParserRuleReturnScope quantifier_type15 =null;
		ParserRuleReturnScope number17 =null;
		ParserRuleReturnScope quantifier_type19 =null;
		ParserRuleReturnScope number21 =null;
		ParserRuleReturnScope quantifier_type24 =null;
		ParserRuleReturnScope number26 =null;
		ParserRuleReturnScope number28 =null;
		ParserRuleReturnScope quantifier_type30 =null;

		CommonTree char_literal10_tree=null;
		CommonTree char_literal12_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree char_literal16_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree char_literal20_tree=null;
		CommonTree char_literal22_tree=null;
		CommonTree char_literal23_tree=null;
		CommonTree char_literal25_tree=null;
		CommonTree char_literal27_tree=null;
		CommonTree char_literal29_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_OpenBrace=new RewriteRuleTokenStream(adaptor,"token OpenBrace");
		RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
		RewriteRuleTokenStream stream_CloseBrace=new RewriteRuleTokenStream(adaptor,"token CloseBrace");
		RewriteRuleSubtreeStream stream_number=new RewriteRuleSubtreeStream(adaptor,"rule number");
		RewriteRuleSubtreeStream stream_quantifier_type=new RewriteRuleSubtreeStream(adaptor,"rule quantifier_type");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// PCRE.g:247:2: ( '?' quantifier_type -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[\"1\"] quantifier_type ) | '+' quantifier_type -> ^( QUANTIFIER NUMBER[\"1\"] NUMBER[HUGE_NUMBER] quantifier_type ) | '*' quantifier_type -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[HUGE_NUMBER] quantifier_type ) | '{' number '}' quantifier_type -> ^( QUANTIFIER number number quantifier_type ) | '{' number ',' '}' quantifier_type -> ^( QUANTIFIER number NUMBER[HUGE_NUMBER] quantifier_type ) | '{' number ',' number '}' quantifier_type -> ^( QUANTIFIER number number quantifier_type ) )
			int alt5=6;
			alt5 = dfa5.predict(input);
			switch (alt5) {
				case 1 :
					// PCRE.g:247:4: '?' quantifier_type
					{
					char_literal10=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_quantifier610); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal10);

					pushFollow(FOLLOW_quantifier_type_in_quantifier612);
					quantifier_type11=quantifier_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier_type.add(quantifier_type11.getTree());
					// AST REWRITE
					// elements: quantifier_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 247:46: -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[\"1\"] quantifier_type )
					{
						// PCRE.g:247:49: ^( QUANTIFIER NUMBER[\"0\"] NUMBER[\"1\"] quantifier_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUANTIFIER, "QUANTIFIER"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, "0"));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, "1"));
						String repetitionType = FeatureDictionary.REP_QUESTIONABLE;
						adaptor.addChild(root_1, (CommonTree)adaptor.create(REPETITION_TYPE, repetitionType));
						adaptor.addChild(root_1, stream_quantifier_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:248:4: '+' quantifier_type
					{
					char_literal12=(Token)match(input,Plus,FOLLOW_Plus_in_quantifier661); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(char_literal12);

					pushFollow(FOLLOW_quantifier_type_in_quantifier663);
					quantifier_type13=quantifier_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier_type.add(quantifier_type13.getTree());
					// AST REWRITE
					// elements: quantifier_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 248:46: -> ^( QUANTIFIER NUMBER[\"1\"] NUMBER[HUGE_NUMBER] quantifier_type )
					{
						// PCRE.g:248:49: ^( QUANTIFIER NUMBER[\"1\"] NUMBER[HUGE_NUMBER] quantifier_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUANTIFIER, "QUANTIFIER"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, "1"));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, HUGE_NUMBER));
						String repetitionType = FeatureDictionary.REP_ADDITIONAL;
						adaptor.addChild(root_1, (CommonTree)adaptor.create(REPETITION_TYPE, repetitionType));
						adaptor.addChild(root_1, stream_quantifier_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:249:4: '*' quantifier_type
					{
					char_literal14=(Token)match(input,Star,FOLLOW_Star_in_quantifier704); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal14);

					pushFollow(FOLLOW_quantifier_type_in_quantifier706);
					quantifier_type15=quantifier_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier_type.add(quantifier_type15.getTree());
					// AST REWRITE
					// elements: quantifier_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 249:46: -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[HUGE_NUMBER] quantifier_type )
					{
						// PCRE.g:249:49: ^( QUANTIFIER NUMBER[\"0\"] NUMBER[HUGE_NUMBER] quantifier_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUANTIFIER, "QUANTIFIER"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, "0"));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, HUGE_NUMBER));
						String repetitionType = FeatureDictionary.REP_KLEENISH;
						adaptor.addChild(root_1, (CommonTree)adaptor.create(REPETITION_TYPE, repetitionType));
						adaptor.addChild(root_1, stream_quantifier_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:250:4: '{' number '}' quantifier_type
					{
					char_literal16=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_quantifier747); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal16);

					pushFollow(FOLLOW_number_in_quantifier749);
					number17=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number17.getTree());
					char_literal18=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_quantifier751); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal18);

					pushFollow(FOLLOW_quantifier_type_in_quantifier753);
					quantifier_type19=quantifier_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier_type.add(quantifier_type19.getTree());
					// AST REWRITE
					// elements: number, quantifier_type, number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 250:46: -> ^( QUANTIFIER number number quantifier_type )
					{
						// PCRE.g:250:49: ^( QUANTIFIER number number quantifier_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUANTIFIER, "QUANTIFIER"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_1, stream_number.nextTree());
						String repetitionType = FeatureDictionary.REP_SINGLEEXACTLY;
						adaptor.addChild(root_1, (CommonTree)adaptor.create(REPETITION_TYPE, repetitionType));
						adaptor.addChild(root_1, stream_quantifier_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:251:4: '{' number ',' '}' quantifier_type
					{
					char_literal20=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_quantifier799); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal20);

					pushFollow(FOLLOW_number_in_quantifier801);
					number21=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number21.getTree());
					char_literal22=(Token)match(input,Comma,FOLLOW_Comma_in_quantifier803); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal22);

					char_literal23=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_quantifier805); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal23);

					pushFollow(FOLLOW_quantifier_type_in_quantifier807);
					quantifier_type24=quantifier_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier_type.add(quantifier_type24.getTree());
					// AST REWRITE
					// elements: number, quantifier_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 251:46: -> ^( QUANTIFIER number NUMBER[HUGE_NUMBER] quantifier_type )
					{
						// PCRE.g:251:49: ^( QUANTIFIER number NUMBER[HUGE_NUMBER] quantifier_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUANTIFIER, "QUANTIFIER"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, HUGE_NUMBER));
						String repetitionType = FeatureDictionary.REP_LOWERBOUNDED;
						adaptor.addChild(root_1, (CommonTree)adaptor.create(REPETITION_TYPE, repetitionType));
						adaptor.addChild(root_1, stream_quantifier_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:252:4: '{' number ',' number '}' quantifier_type
					{
					char_literal25=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_quantifier837); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal25);

					pushFollow(FOLLOW_number_in_quantifier839);
					number26=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number26.getTree());
					char_literal27=(Token)match(input,Comma,FOLLOW_Comma_in_quantifier841); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(char_literal27);

					pushFollow(FOLLOW_number_in_quantifier843);
					number28=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number28.getTree());
					char_literal29=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_quantifier845); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal29);

					pushFollow(FOLLOW_quantifier_type_in_quantifier847);
					quantifier_type30=quantifier_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_quantifier_type.add(quantifier_type30.getTree());
					// AST REWRITE
					// elements: quantifier_type, number, number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 252:46: -> ^( QUANTIFIER number number quantifier_type )
					{
						// PCRE.g:252:49: ^( QUANTIFIER number number quantifier_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUANTIFIER, "QUANTIFIER"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_1, stream_number.nextTree());
						String repetitionType = FeatureDictionary.REP_DOUBLEBOUNDED;
						adaptor.addChild(root_1, (CommonTree)adaptor.create(REPETITION_TYPE, repetitionType));
						adaptor.addChild(root_1, stream_quantifier_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, quantifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "quantifier"


	public static class quantifier_type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "quantifier_type"
	// PCRE.g:255:1: quantifier_type : ( '+' -> POSSESSIVE | '?' -> LAZY | -> GREEDY );
	public final PCREParser.quantifier_type_return quantifier_type() throws RecognitionException {
		PCREParser.quantifier_type_return retval = new PCREParser.quantifier_type_return();
		retval.start = input.LT(1);
		int quantifier_type_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal31=null;
		Token char_literal32=null;

		CommonTree char_literal31_tree=null;
		CommonTree char_literal32_tree=null;
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// PCRE.g:256:2: ( '+' -> POSSESSIVE | '?' -> LAZY | -> GREEDY )
			int alt6=3;
			switch ( input.LA(1) ) {
			case Plus:
				{
				alt6=1;
				}
				break;
			case QuestionMark:
				{
				alt6=2;
				}
				break;
			case EOF:
			case ALC:
			case AUC:
			case Ampersand:
			case BLC:
			case BUC:
			case Backslash:
			case BellChar:
			case BlockQuoted:
			case CLC:
			case CUC:
			case Caret:
			case CarriageReturn:
			case CharWithProperty:
			case CharWithoutProperty:
			case CharacterClassEnd:
			case CharacterClassStart:
			case CloseBrace:
			case CloseParen:
			case Colon:
			case Comma:
			case ControlChar:
			case D0:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case DLC:
			case DUC:
			case DecimalDigit:
			case Dot:
			case ELC:
			case EUC:
			case EndOfSubject:
			case EndOfSubjectOrLine:
			case EndOfSubjectOrLineEndOfSubject:
			case Equals:
			case EscapeChar:
			case Exclamation:
			case ExtendedUnicodeChar:
			case FLC:
			case FUC:
			case FormFeed:
			case GLC:
			case GUC:
			case GreaterThan:
			case HLC:
			case HUC:
			case Hash:
			case HexChar:
			case HorizontalWhiteSpace:
			case Hyphen:
			case ILC:
			case IUC:
			case JLC:
			case JUC:
			case KLC:
			case KUC:
			case LLC:
			case LUC:
			case LessThan:
			case MLC:
			case MUC:
			case NLC:
			case NUC:
			case NamedReferenceStartK:
			case NewLine:
			case NewLineSequence:
			case NonWordBoundary:
			case NotDecimalDigit:
			case NotHorizontalWhiteSpace:
			case NotNewLine:
			case NotVerticalWhiteSpace:
			case NotWhiteSpace:
			case NotWordChar:
			case OLC:
			case OUC:
			case OneDataUnit:
			case OpenBrace:
			case OpenParen:
			case OtherChar:
			case PLC:
			case POSIXNamedSet:
			case POSIXNegatedNamedSet:
			case PUC:
			case Pipe:
			case PreviousMatchInSubject:
			case QLC:
			case QUC:
			case Quoted:
			case RLC:
			case RUC:
			case ResetStartMatch:
			case SLC:
			case SUC:
			case SingleQuote:
			case StartOfSubject:
			case SubroutineOrNamedReferenceStartG:
			case TLC:
			case TUC:
			case Tab:
			case ULC:
			case UUC:
			case Underscore:
			case VLC:
			case VUC:
			case VerticalWhiteSpace:
			case WLC:
			case WUC:
			case WhiteSpace:
			case WordBoundary:
			case WordChar:
			case XLC:
			case XUC:
			case YLC:
			case YUC:
			case ZLC:
			case ZUC:
				{
				alt6=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// PCRE.g:256:4: '+'
					{
					char_literal31=(Token)match(input,Plus,FOLLOW_Plus_in_quantifier_type888); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(char_literal31);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 256:18: -> POSSESSIVE
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(POSSESSIVE, "POSSESSIVE"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:257:4: '?'
					{
					char_literal32=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_quantifier_type908); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal32);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 257:18: -> LAZY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LAZY, "LAZY"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:258:18: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 258:18: -> GREEDY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(GREEDY, "GREEDY"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, quantifier_type_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "quantifier_type"


	public static class character_class_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "character_class"
	// PCRE.g:287:1: character_class : ( '[' '^' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']' -> ^( NEGATED_CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* ) | '[' '^' CharacterClassEnd ( cc_atom )* ']' -> ^( NEGATED_CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* ) | '[' '^' ( cc_atom )+ ']' -> ^( NEGATED_CHARACTER_CLASS ( cc_atom )+ ) | '[' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']' -> ^( CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* ) | '[' CharacterClassEnd ( cc_atom )* ']' -> ^( CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* ) | '[' ( cc_atom )+ ']' -> ^( CHARACTER_CLASS ( cc_atom )+ ) );
	public final PCREParser.character_class_return character_class() throws RecognitionException {
		PCREParser.character_class_return retval = new PCREParser.character_class_return();
		retval.start = input.LT(1);
		int character_class_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal33=null;
		Token char_literal34=null;
		Token CharacterClassEnd35=null;
		Token Hyphen36=null;
		Token char_literal38=null;
		Token char_literal39=null;
		Token char_literal40=null;
		Token CharacterClassEnd41=null;
		Token char_literal43=null;
		Token char_literal44=null;
		Token char_literal45=null;
		Token char_literal47=null;
		Token char_literal48=null;
		Token CharacterClassEnd49=null;
		Token Hyphen50=null;
		Token char_literal52=null;
		Token char_literal53=null;
		Token CharacterClassEnd54=null;
		Token char_literal56=null;
		Token char_literal57=null;
		Token char_literal59=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope cc_atom37 =null;
		ParserRuleReturnScope cc_atom42 =null;
		ParserRuleReturnScope cc_atom46 =null;
		ParserRuleReturnScope cc_atom51 =null;
		ParserRuleReturnScope cc_atom55 =null;
		ParserRuleReturnScope cc_atom58 =null;

		CommonTree char_literal33_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree CharacterClassEnd35_tree=null;
		CommonTree Hyphen36_tree=null;
		CommonTree char_literal38_tree=null;
		CommonTree char_literal39_tree=null;
		CommonTree char_literal40_tree=null;
		CommonTree CharacterClassEnd41_tree=null;
		CommonTree char_literal43_tree=null;
		CommonTree char_literal44_tree=null;
		CommonTree char_literal45_tree=null;
		CommonTree char_literal47_tree=null;
		CommonTree char_literal48_tree=null;
		CommonTree CharacterClassEnd49_tree=null;
		CommonTree Hyphen50_tree=null;
		CommonTree char_literal52_tree=null;
		CommonTree char_literal53_tree=null;
		CommonTree CharacterClassEnd54_tree=null;
		CommonTree char_literal56_tree=null;
		CommonTree char_literal57_tree=null;
		CommonTree char_literal59_tree=null;
		RewriteRuleTokenStream stream_CharacterClassEnd=new RewriteRuleTokenStream(adaptor,"token CharacterClassEnd");
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleTokenStream stream_Caret=new RewriteRuleTokenStream(adaptor,"token Caret");
		RewriteRuleTokenStream stream_CharacterClassStart=new RewriteRuleTokenStream(adaptor,"token CharacterClassStart");
		RewriteRuleSubtreeStream stream_cc_atom=new RewriteRuleSubtreeStream(adaptor,"rule cc_atom");
		RewriteRuleSubtreeStream stream_cc_atom_end_range=new RewriteRuleSubtreeStream(adaptor,"rule cc_atom_end_range");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// PCRE.g:288:2: ( '[' '^' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']' -> ^( NEGATED_CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* ) | '[' '^' CharacterClassEnd ( cc_atom )* ']' -> ^( NEGATED_CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* ) | '[' '^' ( cc_atom )+ ']' -> ^( NEGATED_CHARACTER_CLASS ( cc_atom )+ ) | '[' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']' -> ^( CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* ) | '[' CharacterClassEnd ( cc_atom )* ']' -> ^( CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* ) | '[' ( cc_atom )+ ']' -> ^( CHARACTER_CLASS ( cc_atom )+ ) )
			int alt13=6;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==CharacterClassStart) ) {
				int LA13_1 = input.LA(2);
				if ( (synpred13_PCRE()) ) {
					alt13=1;
				}
				else if ( (synpred15_PCRE()) ) {
					alt13=2;
				}
				else if ( (synpred17_PCRE()) ) {
					alt13=3;
				}
				else if ( (synpred19_PCRE()) ) {
					alt13=4;
				}
				else if ( (synpred21_PCRE()) ) {
					alt13=5;
				}
				else if ( (true) ) {
					alt13=6;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// PCRE.g:288:4: '[' '^' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']'
					{
					char_literal33=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class968); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(char_literal33);

					if ( state.backtracking==0 ) {insideCharacterClass=true;}
					char_literal34=(Token)match(input,Caret,FOLLOW_Caret_in_character_class972); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Caret.add(char_literal34);

					CharacterClassEnd35=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class974); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(CharacterClassEnd35);

					Hyphen36=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_character_class976); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen36);

					pushFollow(FOLLOW_cc_atom_end_range_in_character_class980);
					a=cc_atom_end_range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cc_atom_end_range.add(a.getTree());
					// PCRE.g:288:86: ( cc_atom )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==ALC||LA7_0==AUC||LA7_0==Ampersand||(LA7_0 >= BLC && LA7_0 <= BlockQuoted)||LA7_0==CLC||(LA7_0 >= CUC && LA7_0 <= CharWithoutProperty)||(LA7_0 >= CharacterClassStart && LA7_0 <= D9)||(LA7_0 >= DLC && LA7_0 <= ELC)||LA7_0==EUC||LA7_0==EndOfSubjectOrLine||(LA7_0 >= Equals && LA7_0 <= Exclamation)||(LA7_0 >= FLC && LA7_0 <= GLC)||(LA7_0 >= GUC && LA7_0 <= HexChar)||(LA7_0 >= HorizontalWhiteSpace && LA7_0 <= KUC)||LA7_0==LLC||(LA7_0 >= LUC && LA7_0 <= MUC)||LA7_0==NLC||LA7_0==NUC||(LA7_0 >= NewLine && LA7_0 <= NewLineSequence)||(LA7_0 >= NotDecimalDigit && LA7_0 <= OLC)||LA7_0==OUC||(LA7_0 >= OpenBrace && LA7_0 <= POSIXNegatedNamedSet)||(LA7_0 >= PUC && LA7_0 <= Plus)||LA7_0==QLC||(LA7_0 >= QUC && LA7_0 <= Quoted)||(LA7_0 >= RLC && LA7_0 <= RUC)||LA7_0==SLC||(LA7_0 >= SUC && LA7_0 <= Star)||(LA7_0 >= TLC && LA7_0 <= ULC)||(LA7_0 >= UUC && LA7_0 <= Underscore)||(LA7_0 >= VLC && LA7_0 <= XUC)||(LA7_0 >= YLC && LA7_0 <= ZUC)) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// PCRE.g:288:86: cc_atom
							{
							pushFollow(FOLLOW_cc_atom_in_character_class982);
							cc_atom37=cc_atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom37.getTree());
							}
							break;

						default :
							break loop7;
						}
					}

					char_literal38=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class985); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(char_literal38);

					if ( state.backtracking==0 ) {insideCharacterClass=false;}
					// AST REWRITE
					// elements: cc_atom, cc_atom_end_range
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 288:129: -> ^( NEGATED_CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* )
					{
						// PCRE.g:288:132: ^( NEGATED_CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEGATED_CHARACTER_CLASS, "NEGATED_CHARACTER_CLASS"), root_1);
						// PCRE.g:288:158: ^( RANGE LITERAL[\"]\"] cc_atom_end_range )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_2);
						adaptor.addChild(root_2, (CommonTree)adaptor.create(LITERAL, "]"));
						adaptor.addChild(root_2, stream_cc_atom_end_range.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:288:198: ( cc_atom )*
						while ( stream_cc_atom.hasNext() ) {
							adaptor.addChild(root_1, stream_cc_atom.nextTree());
						}
						stream_cc_atom.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:289:4: '[' '^' CharacterClassEnd ( cc_atom )* ']'
					{
					char_literal39=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class1010); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(char_literal39);

					if ( state.backtracking==0 ) {insideCharacterClass=true;}
					char_literal40=(Token)match(input,Caret,FOLLOW_Caret_in_character_class1014); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Caret.add(char_literal40);

					CharacterClassEnd41=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1016); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(CharacterClassEnd41);

					// PCRE.g:289:59: ( cc_atom )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==ALC||LA8_0==AUC||LA8_0==Ampersand||(LA8_0 >= BLC && LA8_0 <= BlockQuoted)||LA8_0==CLC||(LA8_0 >= CUC && LA8_0 <= CharWithoutProperty)||(LA8_0 >= CharacterClassStart && LA8_0 <= D9)||(LA8_0 >= DLC && LA8_0 <= ELC)||LA8_0==EUC||LA8_0==EndOfSubjectOrLine||(LA8_0 >= Equals && LA8_0 <= Exclamation)||(LA8_0 >= FLC && LA8_0 <= GLC)||(LA8_0 >= GUC && LA8_0 <= HexChar)||(LA8_0 >= HorizontalWhiteSpace && LA8_0 <= KUC)||LA8_0==LLC||(LA8_0 >= LUC && LA8_0 <= MUC)||LA8_0==NLC||LA8_0==NUC||(LA8_0 >= NewLine && LA8_0 <= NewLineSequence)||(LA8_0 >= NotDecimalDigit && LA8_0 <= OLC)||LA8_0==OUC||(LA8_0 >= OpenBrace && LA8_0 <= POSIXNegatedNamedSet)||(LA8_0 >= PUC && LA8_0 <= Plus)||LA8_0==QLC||(LA8_0 >= QUC && LA8_0 <= Quoted)||(LA8_0 >= RLC && LA8_0 <= RUC)||LA8_0==SLC||(LA8_0 >= SUC && LA8_0 <= Star)||(LA8_0 >= TLC && LA8_0 <= ULC)||(LA8_0 >= UUC && LA8_0 <= Underscore)||(LA8_0 >= VLC && LA8_0 <= XUC)||(LA8_0 >= YLC && LA8_0 <= ZUC)) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// PCRE.g:289:59: cc_atom
							{
							pushFollow(FOLLOW_cc_atom_in_character_class1018);
							cc_atom42=cc_atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom42.getTree());
							}
							break;

						default :
							break loop8;
						}
					}

					char_literal43=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1021); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(char_literal43);

					if ( state.backtracking==0 ) {insideCharacterClass=false;}
					// AST REWRITE
					// elements: cc_atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 289:129: -> ^( NEGATED_CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* )
					{
						// PCRE.g:289:132: ^( NEGATED_CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEGATED_CHARACTER_CLASS, "NEGATED_CHARACTER_CLASS"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(LITERAL, "]"));
						// PCRE.g:289:171: ( cc_atom )*
						while ( stream_cc_atom.hasNext() ) {
							adaptor.addChild(root_1, stream_cc_atom.nextTree());
						}
						stream_cc_atom.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:290:4: '[' '^' ( cc_atom )+ ']'
					{
					char_literal44=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class1067); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(char_literal44);

					if ( state.backtracking==0 ) {insideCharacterClass=true;}
					char_literal45=(Token)match(input,Caret,FOLLOW_Caret_in_character_class1071); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Caret.add(char_literal45);

					// PCRE.g:290:41: ( cc_atom )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==ALC||LA9_0==AUC||LA9_0==Ampersand||(LA9_0 >= BLC && LA9_0 <= BlockQuoted)||LA9_0==CLC||(LA9_0 >= CUC && LA9_0 <= CharWithoutProperty)||(LA9_0 >= CharacterClassStart && LA9_0 <= D9)||(LA9_0 >= DLC && LA9_0 <= ELC)||LA9_0==EUC||LA9_0==EndOfSubjectOrLine||(LA9_0 >= Equals && LA9_0 <= Exclamation)||(LA9_0 >= FLC && LA9_0 <= GLC)||(LA9_0 >= GUC && LA9_0 <= HexChar)||(LA9_0 >= HorizontalWhiteSpace && LA9_0 <= KUC)||LA9_0==LLC||(LA9_0 >= LUC && LA9_0 <= MUC)||LA9_0==NLC||LA9_0==NUC||(LA9_0 >= NewLine && LA9_0 <= NewLineSequence)||(LA9_0 >= NotDecimalDigit && LA9_0 <= OLC)||LA9_0==OUC||(LA9_0 >= OpenBrace && LA9_0 <= POSIXNegatedNamedSet)||(LA9_0 >= PUC && LA9_0 <= Plus)||LA9_0==QLC||(LA9_0 >= QUC && LA9_0 <= Quoted)||(LA9_0 >= RLC && LA9_0 <= RUC)||LA9_0==SLC||(LA9_0 >= SUC && LA9_0 <= Star)||(LA9_0 >= TLC && LA9_0 <= ULC)||(LA9_0 >= UUC && LA9_0 <= Underscore)||(LA9_0 >= VLC && LA9_0 <= XUC)||(LA9_0 >= YLC && LA9_0 <= ZUC)) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// PCRE.g:290:41: cc_atom
							{
							pushFollow(FOLLOW_cc_atom_in_character_class1073);
							cc_atom46=cc_atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom46.getTree());
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

					char_literal47=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1076); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(char_literal47);

					if ( state.backtracking==0 ) {insideCharacterClass=false;}
					// AST REWRITE
					// elements: cc_atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 290:129: -> ^( NEGATED_CHARACTER_CLASS ( cc_atom )+ )
					{
						// PCRE.g:290:132: ^( NEGATED_CHARACTER_CLASS ( cc_atom )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEGATED_CHARACTER_CLASS, "NEGATED_CHARACTER_CLASS"), root_1);
						if ( !(stream_cc_atom.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_cc_atom.hasNext() ) {
							adaptor.addChild(root_1, stream_cc_atom.nextTree());
						}
						stream_cc_atom.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:291:4: '[' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']'
					{
					char_literal48=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class1137); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(char_literal48);

					if ( state.backtracking==0 ) {insideCharacterClass=true;}
					CharacterClassEnd49=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1141); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(CharacterClassEnd49);

					Hyphen50=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_character_class1143); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen50);

					pushFollow(FOLLOW_cc_atom_end_range_in_character_class1147);
					a=cc_atom_end_range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cc_atom_end_range.add(a.getTree());
					// PCRE.g:291:82: ( cc_atom )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==ALC||LA10_0==AUC||LA10_0==Ampersand||(LA10_0 >= BLC && LA10_0 <= BlockQuoted)||LA10_0==CLC||(LA10_0 >= CUC && LA10_0 <= CharWithoutProperty)||(LA10_0 >= CharacterClassStart && LA10_0 <= D9)||(LA10_0 >= DLC && LA10_0 <= ELC)||LA10_0==EUC||LA10_0==EndOfSubjectOrLine||(LA10_0 >= Equals && LA10_0 <= Exclamation)||(LA10_0 >= FLC && LA10_0 <= GLC)||(LA10_0 >= GUC && LA10_0 <= HexChar)||(LA10_0 >= HorizontalWhiteSpace && LA10_0 <= KUC)||LA10_0==LLC||(LA10_0 >= LUC && LA10_0 <= MUC)||LA10_0==NLC||LA10_0==NUC||(LA10_0 >= NewLine && LA10_0 <= NewLineSequence)||(LA10_0 >= NotDecimalDigit && LA10_0 <= OLC)||LA10_0==OUC||(LA10_0 >= OpenBrace && LA10_0 <= POSIXNegatedNamedSet)||(LA10_0 >= PUC && LA10_0 <= Plus)||LA10_0==QLC||(LA10_0 >= QUC && LA10_0 <= Quoted)||(LA10_0 >= RLC && LA10_0 <= RUC)||LA10_0==SLC||(LA10_0 >= SUC && LA10_0 <= Star)||(LA10_0 >= TLC && LA10_0 <= ULC)||(LA10_0 >= UUC && LA10_0 <= Underscore)||(LA10_0 >= VLC && LA10_0 <= XUC)||(LA10_0 >= YLC && LA10_0 <= ZUC)) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// PCRE.g:291:82: cc_atom
							{
							pushFollow(FOLLOW_cc_atom_in_character_class1149);
							cc_atom51=cc_atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom51.getTree());
							}
							break;

						default :
							break loop10;
						}
					}

					char_literal52=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1152); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(char_literal52);

					if ( state.backtracking==0 ) {insideCharacterClass=false;}
					// AST REWRITE
					// elements: cc_atom, cc_atom_end_range
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 291:129: -> ^( CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* )
					{
						// PCRE.g:291:132: ^( CHARACTER_CLASS ^( RANGE LITERAL[\"]\"] cc_atom_end_range ) ( cc_atom )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHARACTER_CLASS, "CHARACTER_CLASS"), root_1);
						// PCRE.g:291:150: ^( RANGE LITERAL[\"]\"] cc_atom_end_range )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_2);
						adaptor.addChild(root_2, (CommonTree)adaptor.create(LITERAL, "]"));
						adaptor.addChild(root_2, stream_cc_atom_end_range.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:291:190: ( cc_atom )*
						while ( stream_cc_atom.hasNext() ) {
							adaptor.addChild(root_1, stream_cc_atom.nextTree());
						}
						stream_cc_atom.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:292:4: '[' CharacterClassEnd ( cc_atom )* ']'
					{
					char_literal53=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class1181); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(char_literal53);

					if ( state.backtracking==0 ) {insideCharacterClass=true;}
					CharacterClassEnd54=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1185); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(CharacterClassEnd54);

					// PCRE.g:292:55: ( cc_atom )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==ALC||LA11_0==AUC||LA11_0==Ampersand||(LA11_0 >= BLC && LA11_0 <= BlockQuoted)||LA11_0==CLC||(LA11_0 >= CUC && LA11_0 <= CharWithoutProperty)||(LA11_0 >= CharacterClassStart && LA11_0 <= D9)||(LA11_0 >= DLC && LA11_0 <= ELC)||LA11_0==EUC||LA11_0==EndOfSubjectOrLine||(LA11_0 >= Equals && LA11_0 <= Exclamation)||(LA11_0 >= FLC && LA11_0 <= GLC)||(LA11_0 >= GUC && LA11_0 <= HexChar)||(LA11_0 >= HorizontalWhiteSpace && LA11_0 <= KUC)||LA11_0==LLC||(LA11_0 >= LUC && LA11_0 <= MUC)||LA11_0==NLC||LA11_0==NUC||(LA11_0 >= NewLine && LA11_0 <= NewLineSequence)||(LA11_0 >= NotDecimalDigit && LA11_0 <= OLC)||LA11_0==OUC||(LA11_0 >= OpenBrace && LA11_0 <= POSIXNegatedNamedSet)||(LA11_0 >= PUC && LA11_0 <= Plus)||LA11_0==QLC||(LA11_0 >= QUC && LA11_0 <= Quoted)||(LA11_0 >= RLC && LA11_0 <= RUC)||LA11_0==SLC||(LA11_0 >= SUC && LA11_0 <= Star)||(LA11_0 >= TLC && LA11_0 <= ULC)||(LA11_0 >= UUC && LA11_0 <= Underscore)||(LA11_0 >= VLC && LA11_0 <= XUC)||(LA11_0 >= YLC && LA11_0 <= ZUC)) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// PCRE.g:292:55: cc_atom
							{
							pushFollow(FOLLOW_cc_atom_in_character_class1187);
							cc_atom55=cc_atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom55.getTree());
							}
							break;

						default :
							break loop11;
						}
					}

					char_literal56=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1190); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(char_literal56);

					if ( state.backtracking==0 ) {insideCharacterClass=false;}
					// AST REWRITE
					// elements: cc_atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 292:129: -> ^( CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* )
					{
						// PCRE.g:292:132: ^( CHARACTER_CLASS LITERAL[\"]\"] ( cc_atom )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHARACTER_CLASS, "CHARACTER_CLASS"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(LITERAL, "]"));
						// PCRE.g:292:163: ( cc_atom )*
						while ( stream_cc_atom.hasNext() ) {
							adaptor.addChild(root_1, stream_cc_atom.nextTree());
						}
						stream_cc_atom.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:293:4: '[' ( cc_atom )+ ']'
					{
					char_literal57=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_character_class1240); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(char_literal57);

					if ( state.backtracking==0 ) {insideCharacterClass=true;}
					// PCRE.g:293:37: ( cc_atom )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==ALC||LA12_0==AUC||LA12_0==Ampersand||(LA12_0 >= BLC && LA12_0 <= BlockQuoted)||LA12_0==CLC||(LA12_0 >= CUC && LA12_0 <= CharWithoutProperty)||(LA12_0 >= CharacterClassStart && LA12_0 <= D9)||(LA12_0 >= DLC && LA12_0 <= ELC)||LA12_0==EUC||LA12_0==EndOfSubjectOrLine||(LA12_0 >= Equals && LA12_0 <= Exclamation)||(LA12_0 >= FLC && LA12_0 <= GLC)||(LA12_0 >= GUC && LA12_0 <= HexChar)||(LA12_0 >= HorizontalWhiteSpace && LA12_0 <= KUC)||LA12_0==LLC||(LA12_0 >= LUC && LA12_0 <= MUC)||LA12_0==NLC||LA12_0==NUC||(LA12_0 >= NewLine && LA12_0 <= NewLineSequence)||(LA12_0 >= NotDecimalDigit && LA12_0 <= OLC)||LA12_0==OUC||(LA12_0 >= OpenBrace && LA12_0 <= POSIXNegatedNamedSet)||(LA12_0 >= PUC && LA12_0 <= Plus)||LA12_0==QLC||(LA12_0 >= QUC && LA12_0 <= Quoted)||(LA12_0 >= RLC && LA12_0 <= RUC)||LA12_0==SLC||(LA12_0 >= SUC && LA12_0 <= Star)||(LA12_0 >= TLC && LA12_0 <= ULC)||(LA12_0 >= UUC && LA12_0 <= Underscore)||(LA12_0 >= VLC && LA12_0 <= XUC)||(LA12_0 >= YLC && LA12_0 <= ZUC)) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// PCRE.g:293:37: cc_atom
							{
							pushFollow(FOLLOW_cc_atom_in_character_class1244);
							cc_atom58=cc_atom();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cc_atom.add(cc_atom58.getTree());
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					char_literal59=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_character_class1247); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(char_literal59);

					if ( state.backtracking==0 ) {insideCharacterClass=false;}
					// AST REWRITE
					// elements: cc_atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 293:129: -> ^( CHARACTER_CLASS ( cc_atom )+ )
					{
						// PCRE.g:293:132: ^( CHARACTER_CLASS ( cc_atom )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHARACTER_CLASS, "CHARACTER_CLASS"), root_1);
						if ( !(stream_cc_atom.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_cc_atom.hasNext() ) {
							adaptor.addChild(root_1, stream_cc_atom.nextTree());
						}
						stream_cc_atom.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, character_class_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "character_class"


	public static class cc_atom_end_range_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cc_atom_end_range"
	// PCRE.g:296:1: cc_atom_end_range : cc_atom ;
	public final PCREParser.cc_atom_end_range_return cc_atom_end_range() throws RecognitionException {
		PCREParser.cc_atom_end_range_return retval = new PCREParser.cc_atom_end_range_return();
		retval.start = input.LT(1);
		int cc_atom_end_range_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope cc_atom60 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// PCRE.g:297:2: ( cc_atom )
			// PCRE.g:297:4: cc_atom
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cc_atom_in_cc_atom_end_range1318);
			cc_atom60=cc_atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cc_atom60.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, cc_atom_end_range_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "cc_atom_end_range"


	public static class backreference_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "backreference"
	// PCRE.g:311:1: backreference : ( backreference_or_octal | '\\\\g' number -> ^( NUMBERED_BACKREFERENCE number ) | '\\\\g' '{' number '}' -> ^( NUMBERED_BACKREFERENCE number ) | '\\\\g' '{' '-' number '}' -> ^( RELATIVE_NUMBERED_BACKREFERENCE number ) | '\\\\k' '<' name '>' -> ^( NAMED_BACKREFERENCE_PERL name ) | '\\\\k' '\\'' name '\\'' -> ^( NAMED_BACKREFERENCE_PERL name ) | '\\\\g' '{' name '}' -> ^( NAMED_BACKREFERENCE_PERL name ) | '\\\\k' '{' name '}' -> ^( NAMED_BACKREFERENCE_NET name ) | '(' '?' 'P' '=' name ')' -> ^( NAMED_BACKREFERENCE_PYTHON name ) );
	public final PCREParser.backreference_return backreference() throws RecognitionException {
		PCREParser.backreference_return retval = new PCREParser.backreference_return();
		retval.start = input.LT(1);
		int backreference_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal62=null;
		Token string_literal64=null;
		Token char_literal65=null;
		Token char_literal67=null;
		Token string_literal68=null;
		Token char_literal69=null;
		Token char_literal70=null;
		Token char_literal72=null;
		Token string_literal73=null;
		Token char_literal74=null;
		Token char_literal76=null;
		Token string_literal77=null;
		Token char_literal78=null;
		Token char_literal80=null;
		Token string_literal81=null;
		Token char_literal82=null;
		Token char_literal84=null;
		Token string_literal85=null;
		Token char_literal86=null;
		Token char_literal88=null;
		Token char_literal89=null;
		Token char_literal90=null;
		Token char_literal91=null;
		Token char_literal92=null;
		Token char_literal94=null;
		ParserRuleReturnScope backreference_or_octal61 =null;
		ParserRuleReturnScope number63 =null;
		ParserRuleReturnScope number66 =null;
		ParserRuleReturnScope number71 =null;
		ParserRuleReturnScope name75 =null;
		ParserRuleReturnScope name79 =null;
		ParserRuleReturnScope name83 =null;
		ParserRuleReturnScope name87 =null;
		ParserRuleReturnScope name93 =null;

		CommonTree string_literal62_tree=null;
		CommonTree string_literal64_tree=null;
		CommonTree char_literal65_tree=null;
		CommonTree char_literal67_tree=null;
		CommonTree string_literal68_tree=null;
		CommonTree char_literal69_tree=null;
		CommonTree char_literal70_tree=null;
		CommonTree char_literal72_tree=null;
		CommonTree string_literal73_tree=null;
		CommonTree char_literal74_tree=null;
		CommonTree char_literal76_tree=null;
		CommonTree string_literal77_tree=null;
		CommonTree char_literal78_tree=null;
		CommonTree char_literal80_tree=null;
		CommonTree string_literal81_tree=null;
		CommonTree char_literal82_tree=null;
		CommonTree char_literal84_tree=null;
		CommonTree string_literal85_tree=null;
		CommonTree char_literal86_tree=null;
		CommonTree char_literal88_tree=null;
		CommonTree char_literal89_tree=null;
		CommonTree char_literal90_tree=null;
		CommonTree char_literal91_tree=null;
		CommonTree char_literal92_tree=null;
		CommonTree char_literal94_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleTokenStream stream_OpenBrace=new RewriteRuleTokenStream(adaptor,"token OpenBrace");
		RewriteRuleTokenStream stream_CloseBrace=new RewriteRuleTokenStream(adaptor,"token CloseBrace");
		RewriteRuleTokenStream stream_SubroutineOrNamedReferenceStartG=new RewriteRuleTokenStream(adaptor,"token SubroutineOrNamedReferenceStartG");
		RewriteRuleTokenStream stream_LessThan=new RewriteRuleTokenStream(adaptor,"token LessThan");
		RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
		RewriteRuleTokenStream stream_GreaterThan=new RewriteRuleTokenStream(adaptor,"token GreaterThan");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_NamedReferenceStartK=new RewriteRuleTokenStream(adaptor,"token NamedReferenceStartK");
		RewriteRuleTokenStream stream_SingleQuote=new RewriteRuleTokenStream(adaptor,"token SingleQuote");
		RewriteRuleTokenStream stream_PUC=new RewriteRuleTokenStream(adaptor,"token PUC");
		RewriteRuleSubtreeStream stream_number=new RewriteRuleSubtreeStream(adaptor,"rule number");
		RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// PCRE.g:312:2: ( backreference_or_octal | '\\\\g' number -> ^( NUMBERED_BACKREFERENCE number ) | '\\\\g' '{' number '}' -> ^( NUMBERED_BACKREFERENCE number ) | '\\\\g' '{' '-' number '}' -> ^( RELATIVE_NUMBERED_BACKREFERENCE number ) | '\\\\k' '<' name '>' -> ^( NAMED_BACKREFERENCE_PERL name ) | '\\\\k' '\\'' name '\\'' -> ^( NAMED_BACKREFERENCE_PERL name ) | '\\\\g' '{' name '}' -> ^( NAMED_BACKREFERENCE_PERL name ) | '\\\\k' '{' name '}' -> ^( NAMED_BACKREFERENCE_NET name ) | '(' '?' 'P' '=' name ')' -> ^( NAMED_BACKREFERENCE_PYTHON name ) )
			int alt14=9;
			switch ( input.LA(1) ) {
			case Backslash:
				{
				alt14=1;
				}
				break;
			case SubroutineOrNamedReferenceStartG:
				{
				int LA14_2 = input.LA(2);
				if ( (LA14_2==OpenBrace) ) {
					switch ( input.LA(3) ) {
					case Hyphen:
						{
						alt14=4;
						}
						break;
					case D0:
					case D1:
					case D2:
					case D3:
					case D4:
					case D5:
					case D6:
					case D7:
					case D8:
					case D9:
						{
						alt14=3;
						}
						break;
					case ALC:
					case AUC:
					case BLC:
					case BUC:
					case CLC:
					case CUC:
					case DLC:
					case DUC:
					case ELC:
					case EUC:
					case FLC:
					case FUC:
					case GLC:
					case GUC:
					case HLC:
					case HUC:
					case ILC:
					case IUC:
					case JLC:
					case JUC:
					case KLC:
					case KUC:
					case LLC:
					case LUC:
					case MLC:
					case MUC:
					case NLC:
					case NUC:
					case OLC:
					case OUC:
					case PLC:
					case PUC:
					case QLC:
					case QUC:
					case RLC:
					case RUC:
					case SLC:
					case SUC:
					case TLC:
					case TUC:
					case ULC:
					case UUC:
					case Underscore:
					case VLC:
					case VUC:
					case WLC:
					case WUC:
					case XLC:
					case XUC:
					case YLC:
					case YUC:
					case ZLC:
					case ZUC:
						{
						alt14=7;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 14, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( ((LA14_2 >= D0 && LA14_2 <= D9)) ) {
					alt14=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NamedReferenceStartK:
				{
				switch ( input.LA(2) ) {
				case LessThan:
					{
					alt14=5;
					}
					break;
				case SingleQuote:
					{
					alt14=6;
					}
					break;
				case OpenBrace:
					{
					alt14=8;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case OpenParen:
				{
				alt14=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// PCRE.g:312:4: backreference_or_octal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_backreference_or_octal_in_backreference1340);
					backreference_or_octal61=backreference_or_octal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, backreference_or_octal61.getTree());

					}
					break;
				case 2 :
					// PCRE.g:313:4: '\\\\g' number
					{
					string_literal62=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1345); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal62);

					pushFollow(FOLLOW_number_in_backreference1347);
					number63=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number63.getTree());
					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 313:29: -> ^( NUMBERED_BACKREFERENCE number )
					{
						// PCRE.g:313:32: ^( NUMBERED_BACKREFERENCE number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_BACKREFERENCE, "NUMBERED_BACKREFERENCE"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:314:4: '\\\\g' '{' number '}'
					{
					string_literal64=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1372); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal64);

					char_literal65=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_backreference1374); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal65);

					pushFollow(FOLLOW_number_in_backreference1376);
					number66=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number66.getTree());
					char_literal67=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_backreference1378); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal67);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 314:29: -> ^( NUMBERED_BACKREFERENCE number )
					{
						// PCRE.g:314:32: ^( NUMBERED_BACKREFERENCE number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_BACKREFERENCE, "NUMBERED_BACKREFERENCE"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:315:4: '\\\\g' '{' '-' number '}'
					{
					string_literal68=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1395); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal68);

					char_literal69=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_backreference1397); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal69);

					char_literal70=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_backreference1399); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal70);

					pushFollow(FOLLOW_number_in_backreference1401);
					number71=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number71.getTree());
					char_literal72=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_backreference1403); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal72);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 315:29: -> ^( RELATIVE_NUMBERED_BACKREFERENCE number )
					{
						// PCRE.g:315:32: ^( RELATIVE_NUMBERED_BACKREFERENCE number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RELATIVE_NUMBERED_BACKREFERENCE, "RELATIVE_NUMBERED_BACKREFERENCE"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:316:4: '\\\\k' '<' name '>'
					{
					string_literal73=(Token)match(input,NamedReferenceStartK,FOLLOW_NamedReferenceStartK_in_backreference1416); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NamedReferenceStartK.add(string_literal73);

					char_literal74=(Token)match(input,LessThan,FOLLOW_LessThan_in_backreference1418); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal74);

					pushFollow(FOLLOW_name_in_backreference1420);
					name75=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name75.getTree());
					char_literal76=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_backreference1422); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal76);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 316:29: -> ^( NAMED_BACKREFERENCE_PERL name )
					{
						// PCRE.g:316:32: ^( NAMED_BACKREFERENCE_PERL name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_BACKREFERENCE_PERL, "NAMED_BACKREFERENCE_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:317:4: '\\\\k' '\\'' name '\\''
					{
					string_literal77=(Token)match(input,NamedReferenceStartK,FOLLOW_NamedReferenceStartK_in_backreference1441); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NamedReferenceStartK.add(string_literal77);

					char_literal78=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_backreference1443); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal78);

					pushFollow(FOLLOW_name_in_backreference1445);
					name79=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name79.getTree());
					char_literal80=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_backreference1447); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal80);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 317:29: -> ^( NAMED_BACKREFERENCE_PERL name )
					{
						// PCRE.g:317:32: ^( NAMED_BACKREFERENCE_PERL name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_BACKREFERENCE_PERL, "NAMED_BACKREFERENCE_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:318:4: '\\\\g' '{' name '}'
					{
					string_literal81=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1464); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal81);

					char_literal82=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_backreference1466); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal82);

					pushFollow(FOLLOW_name_in_backreference1468);
					name83=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name83.getTree());
					char_literal84=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_backreference1470); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal84);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 318:29: -> ^( NAMED_BACKREFERENCE_PERL name )
					{
						// PCRE.g:318:32: ^( NAMED_BACKREFERENCE_PERL name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_BACKREFERENCE_PERL, "NAMED_BACKREFERENCE_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// PCRE.g:319:4: '\\\\k' '{' name '}'
					{
					string_literal85=(Token)match(input,NamedReferenceStartK,FOLLOW_NamedReferenceStartK_in_backreference1489); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NamedReferenceStartK.add(string_literal85);

					char_literal86=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_backreference1491); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(char_literal86);

					pushFollow(FOLLOW_name_in_backreference1493);
					name87=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name87.getTree());
					char_literal88=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_backreference1495); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(char_literal88);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 319:29: -> ^( NAMED_BACKREFERENCE_NET name )
					{
						// PCRE.g:319:32: ^( NAMED_BACKREFERENCE_NET name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_BACKREFERENCE_NET, "NAMED_BACKREFERENCE_NET"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// PCRE.g:320:4: '(' '?' 'P' '=' name ')'
					{
					char_literal89=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backreference1514); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal89);

					char_literal90=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_backreference1516); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal90);

					char_literal91=(Token)match(input,PUC,FOLLOW_PUC_in_backreference1518); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal91);

					char_literal92=(Token)match(input,Equals,FOLLOW_Equals_in_backreference1520); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Equals.add(char_literal92);

					pushFollow(FOLLOW_name_in_backreference1522);
					name93=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name93.getTree());
					char_literal94=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backreference1524); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal94);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 320:29: -> ^( NAMED_BACKREFERENCE_PYTHON name )
					{
						// PCRE.g:320:32: ^( NAMED_BACKREFERENCE_PYTHON name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_BACKREFERENCE_PYTHON, "NAMED_BACKREFERENCE_PYTHON"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, backreference_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "backreference"


	public static class backreference_or_octal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "backreference_or_octal"
	// PCRE.g:323:1: backreference_or_octal : ( octal_char | Backslash digit -> ^( NUMBERED_BACKREFERENCE NUMBER[$digit.text] ) );
	public final PCREParser.backreference_or_octal_return backreference_or_octal() throws RecognitionException {
		PCREParser.backreference_or_octal_return retval = new PCREParser.backreference_or_octal_return();
		retval.start = input.LT(1);
		int backreference_or_octal_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Backslash96=null;
		ParserRuleReturnScope octal_char95 =null;
		ParserRuleReturnScope digit97 =null;

		CommonTree Backslash96_tree=null;
		RewriteRuleTokenStream stream_Backslash=new RewriteRuleTokenStream(adaptor,"token Backslash");
		RewriteRuleSubtreeStream stream_digit=new RewriteRuleSubtreeStream(adaptor,"rule digit");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// PCRE.g:324:2: ( octal_char | Backslash digit -> ^( NUMBERED_BACKREFERENCE NUMBER[$digit.text] ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==Backslash) ) {
				switch ( input.LA(2) ) {
				case D0:
					{
					int LA15_2 = input.LA(3);
					if ( ((LA15_2 >= D0 && LA15_2 <= D7)) ) {
						int LA15_8 = input.LA(4);
						if ( (synpred31_PCRE()) ) {
							alt15=1;
						}
						else if ( (true) ) {
							alt15=2;
						}

					}
					else if ( (LA15_2==EOF||LA15_2==ALC||LA15_2==AUC||LA15_2==Ampersand||(LA15_2 >= BLC && LA15_2 <= BlockQuoted)||LA15_2==CLC||(LA15_2 >= CUC && LA15_2 <= ControlChar)||(LA15_2 >= D8 && LA15_2 <= D9)||(LA15_2 >= DLC && LA15_2 <= ELC)||(LA15_2 >= EUC && LA15_2 <= GLC)||(LA15_2 >= GUC && LA15_2 <= HexChar)||(LA15_2 >= HorizontalWhiteSpace && LA15_2 <= KUC)||LA15_2==LLC||(LA15_2 >= LUC && LA15_2 <= MUC)||LA15_2==NLC||LA15_2==NUC||(LA15_2 >= NamedReferenceStartK && LA15_2 <= NewLineSequence)||(LA15_2 >= NonWordBoundary && LA15_2 <= OLC)||LA15_2==OUC||(LA15_2 >= OneDataUnit && LA15_2 <= POSIXNegatedNamedSet)||(LA15_2 >= PUC && LA15_2 <= QLC)||(LA15_2 >= QUC && LA15_2 <= Quoted)||(LA15_2 >= RLC && LA15_2 <= ResetStartMatch)||LA15_2==SLC||(LA15_2 >= SUC && LA15_2 <= ULC)||(LA15_2 >= UUC && LA15_2 <= Underscore)||(LA15_2 >= VLC && LA15_2 <= XUC)||(LA15_2 >= YLC && LA15_2 <= ZUC)) ) {
						alt15=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 15, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D1:
					{
					int LA15_3 = input.LA(3);
					if ( ((LA15_3 >= D0 && LA15_3 <= D7)) ) {
						int LA15_9 = input.LA(4);
						if ( (synpred31_PCRE()) ) {
							alt15=1;
						}
						else if ( (true) ) {
							alt15=2;
						}

					}
					else if ( (LA15_3==EOF||LA15_3==ALC||LA15_3==AUC||LA15_3==Ampersand||(LA15_3 >= BLC && LA15_3 <= BlockQuoted)||LA15_3==CLC||(LA15_3 >= CUC && LA15_3 <= ControlChar)||(LA15_3 >= D8 && LA15_3 <= D9)||(LA15_3 >= DLC && LA15_3 <= ELC)||(LA15_3 >= EUC && LA15_3 <= GLC)||(LA15_3 >= GUC && LA15_3 <= HexChar)||(LA15_3 >= HorizontalWhiteSpace && LA15_3 <= KUC)||LA15_3==LLC||(LA15_3 >= LUC && LA15_3 <= MUC)||LA15_3==NLC||LA15_3==NUC||(LA15_3 >= NamedReferenceStartK && LA15_3 <= NewLineSequence)||(LA15_3 >= NonWordBoundary && LA15_3 <= OLC)||LA15_3==OUC||(LA15_3 >= OneDataUnit && LA15_3 <= POSIXNegatedNamedSet)||(LA15_3 >= PUC && LA15_3 <= QLC)||(LA15_3 >= QUC && LA15_3 <= Quoted)||(LA15_3 >= RLC && LA15_3 <= ResetStartMatch)||LA15_3==SLC||(LA15_3 >= SUC && LA15_3 <= ULC)||(LA15_3 >= UUC && LA15_3 <= Underscore)||(LA15_3 >= VLC && LA15_3 <= XUC)||(LA15_3 >= YLC && LA15_3 <= ZUC)) ) {
						alt15=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 15, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D2:
					{
					int LA15_4 = input.LA(3);
					if ( ((LA15_4 >= D0 && LA15_4 <= D7)) ) {
						int LA15_10 = input.LA(4);
						if ( (synpred31_PCRE()) ) {
							alt15=1;
						}
						else if ( (true) ) {
							alt15=2;
						}

					}
					else if ( (LA15_4==EOF||LA15_4==ALC||LA15_4==AUC||LA15_4==Ampersand||(LA15_4 >= BLC && LA15_4 <= BlockQuoted)||LA15_4==CLC||(LA15_4 >= CUC && LA15_4 <= ControlChar)||(LA15_4 >= D8 && LA15_4 <= D9)||(LA15_4 >= DLC && LA15_4 <= ELC)||(LA15_4 >= EUC && LA15_4 <= GLC)||(LA15_4 >= GUC && LA15_4 <= HexChar)||(LA15_4 >= HorizontalWhiteSpace && LA15_4 <= KUC)||LA15_4==LLC||(LA15_4 >= LUC && LA15_4 <= MUC)||LA15_4==NLC||LA15_4==NUC||(LA15_4 >= NamedReferenceStartK && LA15_4 <= NewLineSequence)||(LA15_4 >= NonWordBoundary && LA15_4 <= OLC)||LA15_4==OUC||(LA15_4 >= OneDataUnit && LA15_4 <= POSIXNegatedNamedSet)||(LA15_4 >= PUC && LA15_4 <= QLC)||(LA15_4 >= QUC && LA15_4 <= Quoted)||(LA15_4 >= RLC && LA15_4 <= ResetStartMatch)||LA15_4==SLC||(LA15_4 >= SUC && LA15_4 <= ULC)||(LA15_4 >= UUC && LA15_4 <= Underscore)||(LA15_4 >= VLC && LA15_4 <= XUC)||(LA15_4 >= YLC && LA15_4 <= ZUC)) ) {
						alt15=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 15, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D3:
					{
					int LA15_5 = input.LA(3);
					if ( ((LA15_5 >= D0 && LA15_5 <= D7)) ) {
						int LA15_11 = input.LA(4);
						if ( (synpred31_PCRE()) ) {
							alt15=1;
						}
						else if ( (true) ) {
							alt15=2;
						}

					}
					else if ( (LA15_5==EOF||LA15_5==ALC||LA15_5==AUC||LA15_5==Ampersand||(LA15_5 >= BLC && LA15_5 <= BlockQuoted)||LA15_5==CLC||(LA15_5 >= CUC && LA15_5 <= ControlChar)||(LA15_5 >= D8 && LA15_5 <= D9)||(LA15_5 >= DLC && LA15_5 <= ELC)||(LA15_5 >= EUC && LA15_5 <= GLC)||(LA15_5 >= GUC && LA15_5 <= HexChar)||(LA15_5 >= HorizontalWhiteSpace && LA15_5 <= KUC)||LA15_5==LLC||(LA15_5 >= LUC && LA15_5 <= MUC)||LA15_5==NLC||LA15_5==NUC||(LA15_5 >= NamedReferenceStartK && LA15_5 <= NewLineSequence)||(LA15_5 >= NonWordBoundary && LA15_5 <= OLC)||LA15_5==OUC||(LA15_5 >= OneDataUnit && LA15_5 <= POSIXNegatedNamedSet)||(LA15_5 >= PUC && LA15_5 <= QLC)||(LA15_5 >= QUC && LA15_5 <= Quoted)||(LA15_5 >= RLC && LA15_5 <= ResetStartMatch)||LA15_5==SLC||(LA15_5 >= SUC && LA15_5 <= ULC)||(LA15_5 >= UUC && LA15_5 <= Underscore)||(LA15_5 >= VLC && LA15_5 <= XUC)||(LA15_5 >= YLC && LA15_5 <= ZUC)) ) {
						alt15=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 15, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D4:
				case D5:
				case D6:
				case D7:
					{
					int LA15_6 = input.LA(3);
					if ( ((LA15_6 >= D0 && LA15_6 <= D7)) ) {
						int LA15_12 = input.LA(4);
						if ( (synpred31_PCRE()) ) {
							alt15=1;
						}
						else if ( (true) ) {
							alt15=2;
						}

					}
					else if ( (LA15_6==EOF||LA15_6==ALC||LA15_6==AUC||LA15_6==Ampersand||(LA15_6 >= BLC && LA15_6 <= BlockQuoted)||LA15_6==CLC||(LA15_6 >= CUC && LA15_6 <= ControlChar)||(LA15_6 >= D8 && LA15_6 <= D9)||(LA15_6 >= DLC && LA15_6 <= ELC)||(LA15_6 >= EUC && LA15_6 <= GLC)||(LA15_6 >= GUC && LA15_6 <= HexChar)||(LA15_6 >= HorizontalWhiteSpace && LA15_6 <= KUC)||LA15_6==LLC||(LA15_6 >= LUC && LA15_6 <= MUC)||LA15_6==NLC||LA15_6==NUC||(LA15_6 >= NamedReferenceStartK && LA15_6 <= NewLineSequence)||(LA15_6 >= NonWordBoundary && LA15_6 <= OLC)||LA15_6==OUC||(LA15_6 >= OneDataUnit && LA15_6 <= POSIXNegatedNamedSet)||(LA15_6 >= PUC && LA15_6 <= QLC)||(LA15_6 >= QUC && LA15_6 <= Quoted)||(LA15_6 >= RLC && LA15_6 <= ResetStartMatch)||LA15_6==SLC||(LA15_6 >= SUC && LA15_6 <= ULC)||(LA15_6 >= UUC && LA15_6 <= Underscore)||(LA15_6 >= VLC && LA15_6 <= XUC)||(LA15_6 >= YLC && LA15_6 <= ZUC)) ) {
						alt15=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 15, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D8:
				case D9:
					{
					alt15=2;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// PCRE.g:324:4: octal_char
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_octal_char_in_backreference_or_octal1543);
					octal_char95=octal_char();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, octal_char95.getTree());

					}
					break;
				case 2 :
					// PCRE.g:325:4: Backslash digit
					{
					Backslash96=(Token)match(input,Backslash,FOLLOW_Backslash_in_backreference_or_octal1548); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Backslash.add(Backslash96);

					pushFollow(FOLLOW_digit_in_backreference_or_octal1550);
					digit97=digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_digit.add(digit97.getTree());
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 325:20: -> ^( NUMBERED_BACKREFERENCE NUMBER[$digit.text] )
					{
						// PCRE.g:325:23: ^( NUMBERED_BACKREFERENCE NUMBER[$digit.text] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_BACKREFERENCE, "NUMBERED_BACKREFERENCE"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, (digit97!=null?input.toString(digit97.start,digit97.stop):null)));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, backreference_or_octal_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "backreference_or_octal"


	public static class capture_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "capture"
	// PCRE.g:341:1: capture : ( '(' '?' '<' name '>' regex ')' -> ^( NAMED_CAPTURING_GROUP_PERL name regex ) | '(' '?' '\\'' name '\\'' regex ')' -> ^( NAMED_CAPTURING_GROUP_PERL name regex ) | '(' '?' 'P' '<' name '>' regex ')' -> ^( NAMED_CAPTURING_GROUP_PYTHON name regex ) | '(' regex ')' -> ^( CAPTURING_GROUP regex ) );
	public final PCREParser.capture_return capture() throws RecognitionException {
		PCREParser.capture_return retval = new PCREParser.capture_return();
		retval.start = input.LT(1);
		int capture_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal98=null;
		Token char_literal99=null;
		Token char_literal100=null;
		Token char_literal102=null;
		Token char_literal104=null;
		Token char_literal105=null;
		Token char_literal106=null;
		Token char_literal107=null;
		Token char_literal109=null;
		Token char_literal111=null;
		Token char_literal112=null;
		Token char_literal113=null;
		Token char_literal114=null;
		Token char_literal115=null;
		Token char_literal117=null;
		Token char_literal119=null;
		Token char_literal120=null;
		Token char_literal122=null;
		ParserRuleReturnScope name101 =null;
		ParserRuleReturnScope regex103 =null;
		ParserRuleReturnScope name108 =null;
		ParserRuleReturnScope regex110 =null;
		ParserRuleReturnScope name116 =null;
		ParserRuleReturnScope regex118 =null;
		ParserRuleReturnScope regex121 =null;

		CommonTree char_literal98_tree=null;
		CommonTree char_literal99_tree=null;
		CommonTree char_literal100_tree=null;
		CommonTree char_literal102_tree=null;
		CommonTree char_literal104_tree=null;
		CommonTree char_literal105_tree=null;
		CommonTree char_literal106_tree=null;
		CommonTree char_literal107_tree=null;
		CommonTree char_literal109_tree=null;
		CommonTree char_literal111_tree=null;
		CommonTree char_literal112_tree=null;
		CommonTree char_literal113_tree=null;
		CommonTree char_literal114_tree=null;
		CommonTree char_literal115_tree=null;
		CommonTree char_literal117_tree=null;
		CommonTree char_literal119_tree=null;
		CommonTree char_literal120_tree=null;
		CommonTree char_literal122_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_LessThan=new RewriteRuleTokenStream(adaptor,"token LessThan");
		RewriteRuleTokenStream stream_GreaterThan=new RewriteRuleTokenStream(adaptor,"token GreaterThan");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_SingleQuote=new RewriteRuleTokenStream(adaptor,"token SingleQuote");
		RewriteRuleTokenStream stream_PUC=new RewriteRuleTokenStream(adaptor,"token PUC");
		RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
		RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// PCRE.g:342:2: ( '(' '?' '<' name '>' regex ')' -> ^( NAMED_CAPTURING_GROUP_PERL name regex ) | '(' '?' '\\'' name '\\'' regex ')' -> ^( NAMED_CAPTURING_GROUP_PERL name regex ) | '(' '?' 'P' '<' name '>' regex ')' -> ^( NAMED_CAPTURING_GROUP_PYTHON name regex ) | '(' regex ')' -> ^( CAPTURING_GROUP regex ) )
			int alt16=4;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==OpenParen) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==QuestionMark) ) {
					switch ( input.LA(3) ) {
					case LessThan:
						{
						alt16=1;
						}
						break;
					case SingleQuote:
						{
						alt16=2;
						}
						break;
					case PUC:
						{
						alt16=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 16, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA16_1==ALC||LA16_1==AUC||LA16_1==Ampersand||(LA16_1 >= BLC && LA16_1 <= BlockQuoted)||LA16_1==CLC||(LA16_1 >= CUC && LA16_1 <= D9)||(LA16_1 >= DLC && LA16_1 <= ELC)||(LA16_1 >= EUC && LA16_1 <= GLC)||(LA16_1 >= GUC && LA16_1 <= HexChar)||(LA16_1 >= HorizontalWhiteSpace && LA16_1 <= KUC)||LA16_1==LLC||(LA16_1 >= LUC && LA16_1 <= MUC)||LA16_1==NLC||LA16_1==NUC||(LA16_1 >= NamedReferenceStartK && LA16_1 <= NewLineSequence)||(LA16_1 >= NonWordBoundary && LA16_1 <= OLC)||LA16_1==OUC||(LA16_1 >= OneDataUnit && LA16_1 <= POSIXNegatedNamedSet)||(LA16_1 >= PUC && LA16_1 <= Pipe)||(LA16_1 >= PreviousMatchInSubject && LA16_1 <= QLC)||LA16_1==QUC||LA16_1==Quoted||(LA16_1 >= RLC && LA16_1 <= ResetStartMatch)||LA16_1==SLC||(LA16_1 >= SUC && LA16_1 <= SingleQuote)||(LA16_1 >= StartOfSubject && LA16_1 <= ULC)||(LA16_1 >= UUC && LA16_1 <= Underscore)||(LA16_1 >= VLC && LA16_1 <= XUC)||(LA16_1 >= YLC && LA16_1 <= ZUC)) ) {
					alt16=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// PCRE.g:342:4: '(' '?' '<' name '>' regex ')'
					{
					char_literal98=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_capture1583); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal98);

					if ( state.backtracking==0 ) {addNumberedMatchGroup(retval);}
					char_literal99=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_capture1587); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal99);

					char_literal100=(Token)match(input,LessThan,FOLLOW_LessThan_in_capture1589); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal100);

					pushFollow(FOLLOW_name_in_capture1591);
					name101=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name101.getTree());
					char_literal102=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_capture1593); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal102);

					if ( state.backtracking==0 ) {addNamedMatchGroup((name101!=null?input.toString(name101.start,name101.stop):null), retval);}
					pushFollow(FOLLOW_regex_in_capture1597);
					regex103=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex103.getTree());
					char_literal104=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_capture1599); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal104);

					// AST REWRITE
					// elements: name, regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 342:114: -> ^( NAMED_CAPTURING_GROUP_PERL name regex )
					{
						// PCRE.g:342:117: ^( NAMED_CAPTURING_GROUP_PERL name regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_CAPTURING_GROUP_PERL, "NAMED_CAPTURING_GROUP_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:343:4: '(' '?' '\\'' name '\\'' regex ')'
					{
					char_literal105=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_capture1618); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal105);

					if ( state.backtracking==0 ) {addNumberedMatchGroup(retval);}
					char_literal106=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_capture1622); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal106);

					char_literal107=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_capture1623); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal107);

					pushFollow(FOLLOW_name_in_capture1625);
					name108=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name108.getTree());
					char_literal109=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_capture1627); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal109);

					if ( state.backtracking==0 ) {addNamedMatchGroup((name108!=null?input.toString(name108.start,name108.stop):null), retval);}
					pushFollow(FOLLOW_regex_in_capture1631);
					regex110=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex110.getTree());
					char_literal111=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_capture1633); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal111);

					// AST REWRITE
					// elements: name, regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 343:114: -> ^( NAMED_CAPTURING_GROUP_PERL name regex )
					{
						// PCRE.g:343:117: ^( NAMED_CAPTURING_GROUP_PERL name regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_CAPTURING_GROUP_PERL, "NAMED_CAPTURING_GROUP_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:344:4: '(' '?' 'P' '<' name '>' regex ')'
					{
					char_literal112=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_capture1652); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal112);

					if ( state.backtracking==0 ) {addNumberedMatchGroup(retval);}
					char_literal113=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_capture1656); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal113);

					char_literal114=(Token)match(input,PUC,FOLLOW_PUC_in_capture1658); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal114);

					char_literal115=(Token)match(input,LessThan,FOLLOW_LessThan_in_capture1660); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal115);

					pushFollow(FOLLOW_name_in_capture1662);
					name116=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name116.getTree());
					char_literal117=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_capture1664); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal117);

					if ( state.backtracking==0 ) {addNamedMatchGroup((name116!=null?input.toString(name116.start,name116.stop):null), retval);}
					pushFollow(FOLLOW_regex_in_capture1668);
					regex118=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex118.getTree());
					char_literal119=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_capture1670); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal119);

					// AST REWRITE
					// elements: name, regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 344:114: -> ^( NAMED_CAPTURING_GROUP_PYTHON name regex )
					{
						// PCRE.g:344:117: ^( NAMED_CAPTURING_GROUP_PYTHON name regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_CAPTURING_GROUP_PYTHON, "NAMED_CAPTURING_GROUP_PYTHON"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:345:4: '(' regex ')'
					{
					char_literal120=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_capture1685); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal120);

					if ( state.backtracking==0 ) {addNumberedMatchGroup(retval);}
					pushFollow(FOLLOW_regex_in_capture1689);
					regex121=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex121.getTree());
					char_literal122=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_capture1691); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal122);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 345:114: -> ^( CAPTURING_GROUP regex )
					{
						// PCRE.g:345:117: ^( CAPTURING_GROUP regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAPTURING_GROUP, "CAPTURING_GROUP"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, capture_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "capture"


	public static class non_capture_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "non_capture"
	// PCRE.g:348:1: non_capture : ( '(' '?' ':' regex ')' -> ^( NON_CAPTURING_GROUP regex ) | '(' '?' '|' regex ')' -> ^( NON_CAPTURING_GROUP_RESET regex ) | '(' '?' '>' regex ')' -> ^( ATOMIC_GROUP regex ) );
	public final PCREParser.non_capture_return non_capture() throws RecognitionException {
		PCREParser.non_capture_return retval = new PCREParser.non_capture_return();
		retval.start = input.LT(1);
		int non_capture_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal123=null;
		Token char_literal124=null;
		Token char_literal125=null;
		Token char_literal127=null;
		Token char_literal128=null;
		Token char_literal129=null;
		Token char_literal130=null;
		Token char_literal132=null;
		Token char_literal133=null;
		Token char_literal134=null;
		Token char_literal135=null;
		Token char_literal137=null;
		ParserRuleReturnScope regex126 =null;
		ParserRuleReturnScope regex131 =null;
		ParserRuleReturnScope regex136 =null;

		CommonTree char_literal123_tree=null;
		CommonTree char_literal124_tree=null;
		CommonTree char_literal125_tree=null;
		CommonTree char_literal127_tree=null;
		CommonTree char_literal128_tree=null;
		CommonTree char_literal129_tree=null;
		CommonTree char_literal130_tree=null;
		CommonTree char_literal132_tree=null;
		CommonTree char_literal133_tree=null;
		CommonTree char_literal134_tree=null;
		CommonTree char_literal135_tree=null;
		CommonTree char_literal137_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_GreaterThan=new RewriteRuleTokenStream(adaptor,"token GreaterThan");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
		RewriteRuleTokenStream stream_Pipe=new RewriteRuleTokenStream(adaptor,"token Pipe");
		RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// PCRE.g:349:2: ( '(' '?' ':' regex ')' -> ^( NON_CAPTURING_GROUP regex ) | '(' '?' '|' regex ')' -> ^( NON_CAPTURING_GROUP_RESET regex ) | '(' '?' '>' regex ')' -> ^( ATOMIC_GROUP regex ) )
			int alt17=3;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==OpenParen) ) {
				int LA17_1 = input.LA(2);
				if ( (LA17_1==QuestionMark) ) {
					switch ( input.LA(3) ) {
					case Colon:
						{
						alt17=1;
						}
						break;
					case Pipe:
						{
						alt17=2;
						}
						break;
					case GreaterThan:
						{
						alt17=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 17, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// PCRE.g:349:4: '(' '?' ':' regex ')'
					{
					char_literal123=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_non_capture1773); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal123);

					char_literal124=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_non_capture1775); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal124);

					char_literal125=(Token)match(input,Colon,FOLLOW_Colon_in_non_capture1777); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Colon.add(char_literal125);

					pushFollow(FOLLOW_regex_in_non_capture1779);
					regex126=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex126.getTree());
					char_literal127=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_non_capture1781); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal127);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 349:26: -> ^( NON_CAPTURING_GROUP regex )
					{
						// PCRE.g:349:29: ^( NON_CAPTURING_GROUP regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NON_CAPTURING_GROUP, "NON_CAPTURING_GROUP"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:350:4: '(' '?' '|' regex ')'
					{
					char_literal128=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_non_capture1794); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal128);

					char_literal129=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_non_capture1796); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal129);

					char_literal130=(Token)match(input,Pipe,FOLLOW_Pipe_in_non_capture1798); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Pipe.add(char_literal130);

					pushFollow(FOLLOW_regex_in_non_capture1800);
					regex131=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex131.getTree());
					char_literal132=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_non_capture1802); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal132);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 350:26: -> ^( NON_CAPTURING_GROUP_RESET regex )
					{
						// PCRE.g:350:29: ^( NON_CAPTURING_GROUP_RESET regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NON_CAPTURING_GROUP_RESET, "NON_CAPTURING_GROUP_RESET"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:351:4: '(' '?' '>' regex ')'
					{
					char_literal133=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_non_capture1815); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal133);

					char_literal134=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_non_capture1817); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal134);

					char_literal135=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_non_capture1819); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal135);

					pushFollow(FOLLOW_regex_in_non_capture1821);
					regex136=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex136.getTree());
					char_literal137=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_non_capture1823); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal137);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 351:26: -> ^( ATOMIC_GROUP regex )
					{
						// PCRE.g:351:29: ^( ATOMIC_GROUP regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOMIC_GROUP, "ATOMIC_GROUP"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, non_capture_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "non_capture"


	public static class comment_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "comment"
	// PCRE.g:357:1: comment : '(' '?' '#' non_close_parens ')' -> COMMENT[$non_close_parens.text] ;
	public final PCREParser.comment_return comment() throws RecognitionException {
		PCREParser.comment_return retval = new PCREParser.comment_return();
		retval.start = input.LT(1);
		int comment_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal138=null;
		Token char_literal139=null;
		Token char_literal140=null;
		Token char_literal142=null;
		ParserRuleReturnScope non_close_parens141 =null;

		CommonTree char_literal138_tree=null;
		CommonTree char_literal139_tree=null;
		CommonTree char_literal140_tree=null;
		CommonTree char_literal142_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Hash=new RewriteRuleTokenStream(adaptor,"token Hash");
		RewriteRuleSubtreeStream stream_non_close_parens=new RewriteRuleSubtreeStream(adaptor,"rule non_close_parens");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// PCRE.g:358:2: ( '(' '?' '#' non_close_parens ')' -> COMMENT[$non_close_parens.text] )
			// PCRE.g:358:4: '(' '?' '#' non_close_parens ')'
			{
			char_literal138=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_comment1845); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OpenParen.add(char_literal138);

			char_literal139=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_comment1847); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal139);

			char_literal140=(Token)match(input,Hash,FOLLOW_Hash_in_comment1849); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Hash.add(char_literal140);

			pushFollow(FOLLOW_non_close_parens_in_comment1851);
			non_close_parens141=non_close_parens();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_non_close_parens.add(non_close_parens141.getTree());
			char_literal142=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_comment1853); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CloseParen.add(char_literal142);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 358:37: -> COMMENT[$non_close_parens.text]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(COMMENT, (non_close_parens141!=null?input.toString(non_close_parens141.start,non_close_parens141.stop):null)));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, comment_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "comment"


	public static class option_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "option"
	// PCRE.g:378:1: option : ( '(' '?' s= option_flags '-' u= option_flags ')' -> ^( OPTIONS ^( SET $s) ^( UNSET $u) ) | '(' '?' option_flags ')' -> ^( OPTIONS ^( SET option_flags ) UNSET ) | '(' '?' '-' option_flags ')' -> ^( OPTIONS SET ^( UNSET option_flags ) ) | '(' '*' 'N' 'O' '_' 'S' 'T' 'A' 'R' 'T' '_' 'O' 'P' 'T' ')' -> OPTIONS_NO_START_OPT | '(' '*' 'U' 'T' 'F' '8' ')' -> OPTIONS_UTF8 | '(' '*' 'U' 'T' 'F' '1' '6' ')' -> OPTIONS_UTF16 | '(' '*' 'U' 'C' 'P' ')' -> OPTIONS_UCP );
	public final PCREParser.option_return option() throws RecognitionException {
		PCREParser.option_return retval = new PCREParser.option_return();
		retval.start = input.LT(1);
		int option_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal143=null;
		Token char_literal144=null;
		Token char_literal145=null;
		Token char_literal146=null;
		Token char_literal147=null;
		Token char_literal148=null;
		Token char_literal150=null;
		Token char_literal151=null;
		Token char_literal152=null;
		Token char_literal153=null;
		Token char_literal155=null;
		Token char_literal156=null;
		Token char_literal157=null;
		Token char_literal158=null;
		Token char_literal159=null;
		Token char_literal160=null;
		Token char_literal161=null;
		Token char_literal162=null;
		Token char_literal163=null;
		Token char_literal164=null;
		Token char_literal165=null;
		Token char_literal166=null;
		Token char_literal167=null;
		Token char_literal168=null;
		Token char_literal169=null;
		Token char_literal170=null;
		Token char_literal171=null;
		Token char_literal172=null;
		Token char_literal173=null;
		Token char_literal174=null;
		Token char_literal175=null;
		Token char_literal176=null;
		Token char_literal177=null;
		Token char_literal178=null;
		Token char_literal179=null;
		Token char_literal180=null;
		Token char_literal181=null;
		Token char_literal182=null;
		Token char_literal183=null;
		Token char_literal184=null;
		Token char_literal185=null;
		Token char_literal186=null;
		Token char_literal187=null;
		Token char_literal188=null;
		Token char_literal189=null;
		Token char_literal190=null;
		Token char_literal191=null;
		ParserRuleReturnScope s =null;
		ParserRuleReturnScope u =null;
		ParserRuleReturnScope option_flags149 =null;
		ParserRuleReturnScope option_flags154 =null;

		CommonTree char_literal143_tree=null;
		CommonTree char_literal144_tree=null;
		CommonTree char_literal145_tree=null;
		CommonTree char_literal146_tree=null;
		CommonTree char_literal147_tree=null;
		CommonTree char_literal148_tree=null;
		CommonTree char_literal150_tree=null;
		CommonTree char_literal151_tree=null;
		CommonTree char_literal152_tree=null;
		CommonTree char_literal153_tree=null;
		CommonTree char_literal155_tree=null;
		CommonTree char_literal156_tree=null;
		CommonTree char_literal157_tree=null;
		CommonTree char_literal158_tree=null;
		CommonTree char_literal159_tree=null;
		CommonTree char_literal160_tree=null;
		CommonTree char_literal161_tree=null;
		CommonTree char_literal162_tree=null;
		CommonTree char_literal163_tree=null;
		CommonTree char_literal164_tree=null;
		CommonTree char_literal165_tree=null;
		CommonTree char_literal166_tree=null;
		CommonTree char_literal167_tree=null;
		CommonTree char_literal168_tree=null;
		CommonTree char_literal169_tree=null;
		CommonTree char_literal170_tree=null;
		CommonTree char_literal171_tree=null;
		CommonTree char_literal172_tree=null;
		CommonTree char_literal173_tree=null;
		CommonTree char_literal174_tree=null;
		CommonTree char_literal175_tree=null;
		CommonTree char_literal176_tree=null;
		CommonTree char_literal177_tree=null;
		CommonTree char_literal178_tree=null;
		CommonTree char_literal179_tree=null;
		CommonTree char_literal180_tree=null;
		CommonTree char_literal181_tree=null;
		CommonTree char_literal182_tree=null;
		CommonTree char_literal183_tree=null;
		CommonTree char_literal184_tree=null;
		CommonTree char_literal185_tree=null;
		CommonTree char_literal186_tree=null;
		CommonTree char_literal187_tree=null;
		CommonTree char_literal188_tree=null;
		CommonTree char_literal189_tree=null;
		CommonTree char_literal190_tree=null;
		CommonTree char_literal191_tree=null;
		RewriteRuleTokenStream stream_SUC=new RewriteRuleTokenStream(adaptor,"token SUC");
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_RUC=new RewriteRuleTokenStream(adaptor,"token RUC");
		RewriteRuleTokenStream stream_UUC=new RewriteRuleTokenStream(adaptor,"token UUC");
		RewriteRuleTokenStream stream_TUC=new RewriteRuleTokenStream(adaptor,"token TUC");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleTokenStream stream_D1=new RewriteRuleTokenStream(adaptor,"token D1");
		RewriteRuleTokenStream stream_AUC=new RewriteRuleTokenStream(adaptor,"token AUC");
		RewriteRuleTokenStream stream_CUC=new RewriteRuleTokenStream(adaptor,"token CUC");
		RewriteRuleTokenStream stream_D6=new RewriteRuleTokenStream(adaptor,"token D6");
		RewriteRuleTokenStream stream_D8=new RewriteRuleTokenStream(adaptor,"token D8");
		RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
		RewriteRuleTokenStream stream_FUC=new RewriteRuleTokenStream(adaptor,"token FUC");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_Underscore=new RewriteRuleTokenStream(adaptor,"token Underscore");
		RewriteRuleTokenStream stream_OUC=new RewriteRuleTokenStream(adaptor,"token OUC");
		RewriteRuleTokenStream stream_NUC=new RewriteRuleTokenStream(adaptor,"token NUC");
		RewriteRuleTokenStream stream_PUC=new RewriteRuleTokenStream(adaptor,"token PUC");
		RewriteRuleSubtreeStream stream_option_flags=new RewriteRuleSubtreeStream(adaptor,"rule option_flags");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// PCRE.g:379:2: ( '(' '?' s= option_flags '-' u= option_flags ')' -> ^( OPTIONS ^( SET $s) ^( UNSET $u) ) | '(' '?' option_flags ')' -> ^( OPTIONS ^( SET option_flags ) UNSET ) | '(' '?' '-' option_flags ')' -> ^( OPTIONS SET ^( UNSET option_flags ) ) | '(' '*' 'N' 'O' '_' 'S' 'T' 'A' 'R' 'T' '_' 'O' 'P' 'T' ')' -> OPTIONS_NO_START_OPT | '(' '*' 'U' 'T' 'F' '8' ')' -> OPTIONS_UTF8 | '(' '*' 'U' 'T' 'F' '1' '6' ')' -> OPTIONS_UTF16 | '(' '*' 'U' 'C' 'P' ')' -> OPTIONS_UCP )
			int alt18=7;
			alt18 = dfa18.predict(input);
			switch (alt18) {
				case 1 :
					// PCRE.g:379:4: '(' '?' s= option_flags '-' u= option_flags ')'
					{
					char_literal143=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option1886); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal143);

					char_literal144=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_option1888); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal144);

					pushFollow(FOLLOW_option_flags_in_option1892);
					s=option_flags();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_option_flags.add(s.getTree());
					char_literal145=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_option1894); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal145);

					pushFollow(FOLLOW_option_flags_in_option1898);
					u=option_flags();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_option_flags.add(u.getTree());
					char_literal146=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option1900); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal146);

					// AST REWRITE
					// elements: s, u
					// token labels: 
					// rule labels: s, u, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.getTree():null);
					RewriteRuleSubtreeStream stream_u=new RewriteRuleSubtreeStream(adaptor,"rule u",u!=null?u.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 379:64: -> ^( OPTIONS ^( SET $s) ^( UNSET $u) )
					{
						// PCRE.g:379:67: ^( OPTIONS ^( SET $s) ^( UNSET $u) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONS, "OPTIONS"), root_1);
						// PCRE.g:379:77: ^( SET $s)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SET, "SET"), root_2);
						adaptor.addChild(root_2, stream_s.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:379:87: ^( UNSET $u)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNSET, "UNSET"), root_2);
						adaptor.addChild(root_2, stream_u.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:380:4: '(' '?' option_flags ')'
					{
					char_literal147=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option1939); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal147);

					char_literal148=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_option1941); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal148);

					pushFollow(FOLLOW_option_flags_in_option1943);
					option_flags149=option_flags();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_option_flags.add(option_flags149.getTree());
					char_literal150=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option1945); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal150);

					// AST REWRITE
					// elements: option_flags
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 380:64: -> ^( OPTIONS ^( SET option_flags ) UNSET )
					{
						// PCRE.g:380:67: ^( OPTIONS ^( SET option_flags ) UNSET )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONS, "OPTIONS"), root_1);
						// PCRE.g:380:77: ^( SET option_flags )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SET, "SET"), root_2);
						adaptor.addChild(root_2, stream_option_flags.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, (CommonTree)adaptor.create(UNSET, "UNSET"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:381:4: '(' '?' '-' option_flags ')'
					{
					char_literal151=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option1999); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal151);

					char_literal152=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_option2001); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal152);

					char_literal153=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_option2003); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal153);

					pushFollow(FOLLOW_option_flags_in_option2005);
					option_flags154=option_flags();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_option_flags.add(option_flags154.getTree());
					char_literal155=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option2007); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal155);

					// AST REWRITE
					// elements: option_flags
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 381:64: -> ^( OPTIONS SET ^( UNSET option_flags ) )
					{
						// PCRE.g:381:67: ^( OPTIONS SET ^( UNSET option_flags ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONS, "OPTIONS"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(SET, "SET"));
						// PCRE.g:381:81: ^( UNSET option_flags )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNSET, "UNSET"), root_2);
						adaptor.addChild(root_2, stream_option_flags.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:382:4: '(' '*' 'N' 'O' '_' 'S' 'T' 'A' 'R' 'T' '_' 'O' 'P' 'T' ')'
					{
					char_literal156=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option2057); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal156);

					char_literal157=(Token)match(input,Star,FOLLOW_Star_in_option2059); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal157);

					char_literal158=(Token)match(input,NUC,FOLLOW_NUC_in_option2061); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal158);

					char_literal159=(Token)match(input,OUC,FOLLOW_OUC_in_option2063); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OUC.add(char_literal159);

					char_literal160=(Token)match(input,Underscore,FOLLOW_Underscore_in_option2065); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Underscore.add(char_literal160);

					char_literal161=(Token)match(input,SUC,FOLLOW_SUC_in_option2067); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SUC.add(char_literal161);

					char_literal162=(Token)match(input,TUC,FOLLOW_TUC_in_option2069); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal162);

					char_literal163=(Token)match(input,AUC,FOLLOW_AUC_in_option2071); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal163);

					char_literal164=(Token)match(input,RUC,FOLLOW_RUC_in_option2073); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal164);

					char_literal165=(Token)match(input,TUC,FOLLOW_TUC_in_option2075); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal165);

					char_literal166=(Token)match(input,Underscore,FOLLOW_Underscore_in_option2077); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Underscore.add(char_literal166);

					char_literal167=(Token)match(input,OUC,FOLLOW_OUC_in_option2079); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OUC.add(char_literal167);

					char_literal168=(Token)match(input,PUC,FOLLOW_PUC_in_option2081); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal168);

					char_literal169=(Token)match(input,TUC,FOLLOW_TUC_in_option2083); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal169);

					char_literal170=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option2085); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal170);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 382:64: -> OPTIONS_NO_START_OPT
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTIONS_NO_START_OPT, "OPTIONS_NO_START_OPT"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:383:4: '(' '*' 'U' 'T' 'F' '8' ')'
					{
					char_literal171=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option2094); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal171);

					char_literal172=(Token)match(input,Star,FOLLOW_Star_in_option2096); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal172);

					char_literal173=(Token)match(input,UUC,FOLLOW_UUC_in_option2098); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal173);

					char_literal174=(Token)match(input,TUC,FOLLOW_TUC_in_option2100); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal174);

					char_literal175=(Token)match(input,FUC,FOLLOW_FUC_in_option2102); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal175);

					char_literal176=(Token)match(input,D8,FOLLOW_D8_in_option2104); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_D8.add(char_literal176);

					char_literal177=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option2106); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal177);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 383:64: -> OPTIONS_UTF8
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTIONS_UTF8, "OPTIONS_UTF8"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:384:4: '(' '*' 'U' 'T' 'F' '1' '6' ')'
					{
					char_literal178=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option2147); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal178);

					char_literal179=(Token)match(input,Star,FOLLOW_Star_in_option2149); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal179);

					char_literal180=(Token)match(input,UUC,FOLLOW_UUC_in_option2151); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal180);

					char_literal181=(Token)match(input,TUC,FOLLOW_TUC_in_option2153); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal181);

					char_literal182=(Token)match(input,FUC,FOLLOW_FUC_in_option2155); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal182);

					char_literal183=(Token)match(input,D1,FOLLOW_D1_in_option2157); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_D1.add(char_literal183);

					char_literal184=(Token)match(input,D6,FOLLOW_D6_in_option2159); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_D6.add(char_literal184);

					char_literal185=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option2161); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal185);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 384:64: -> OPTIONS_UTF16
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTIONS_UTF16, "OPTIONS_UTF16"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:385:4: '(' '*' 'U' 'C' 'P' ')'
					{
					char_literal186=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_option2198); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal186);

					char_literal187=(Token)match(input,Star,FOLLOW_Star_in_option2200); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal187);

					char_literal188=(Token)match(input,UUC,FOLLOW_UUC_in_option2202); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal188);

					char_literal189=(Token)match(input,CUC,FOLLOW_CUC_in_option2204); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal189);

					char_literal190=(Token)match(input,PUC,FOLLOW_PUC_in_option2206); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal190);

					char_literal191=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_option2208); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal191);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 385:64: -> OPTIONS_UCP
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTIONS_UCP, "OPTIONS_UCP"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, option_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "option"


	public static class option_flags_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "option_flags"
	// PCRE.g:388:1: option_flags : ( option_flag )+ ;
	public final PCREParser.option_flags_return option_flags() throws RecognitionException {
		PCREParser.option_flags_return retval = new PCREParser.option_flags_return();
		retval.start = input.LT(1);
		int option_flags_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope option_flag192 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// PCRE.g:389:2: ( ( option_flag )+ )
			// PCRE.g:389:4: ( option_flag )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// PCRE.g:389:4: ( option_flag )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==ILC||LA19_0==JUC||LA19_0==MLC||LA19_0==SLC||LA19_0==UUC||LA19_0==XLC) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// PCRE.g:389:4: option_flag
					{
					pushFollow(FOLLOW_option_flag_in_option_flags2259);
					option_flag192=option_flag();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_flag192.getTree());

					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 16, option_flags_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "option_flags"


	public static class option_flag_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "option_flag"
	// PCRE.g:392:1: option_flag : ( 'i' -> OPTION[\"i\"] | 'J' -> OPTION[\"J\"] | 'm' -> OPTION[\"m\"] | 's' -> OPTION[\"s\"] | 'U' -> OPTION[\"U\"] | 'x' -> OPTION[\"x\"] );
	public final PCREParser.option_flag_return option_flag() throws RecognitionException {
		PCREParser.option_flag_return retval = new PCREParser.option_flag_return();
		retval.start = input.LT(1);
		int option_flag_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal193=null;
		Token char_literal194=null;
		Token char_literal195=null;
		Token char_literal196=null;
		Token char_literal197=null;
		Token char_literal198=null;

		CommonTree char_literal193_tree=null;
		CommonTree char_literal194_tree=null;
		CommonTree char_literal195_tree=null;
		CommonTree char_literal196_tree=null;
		CommonTree char_literal197_tree=null;
		CommonTree char_literal198_tree=null;
		RewriteRuleTokenStream stream_ILC=new RewriteRuleTokenStream(adaptor,"token ILC");
		RewriteRuleTokenStream stream_UUC=new RewriteRuleTokenStream(adaptor,"token UUC");
		RewriteRuleTokenStream stream_MLC=new RewriteRuleTokenStream(adaptor,"token MLC");
		RewriteRuleTokenStream stream_JUC=new RewriteRuleTokenStream(adaptor,"token JUC");
		RewriteRuleTokenStream stream_SLC=new RewriteRuleTokenStream(adaptor,"token SLC");
		RewriteRuleTokenStream stream_XLC=new RewriteRuleTokenStream(adaptor,"token XLC");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// PCRE.g:393:2: ( 'i' -> OPTION[\"i\"] | 'J' -> OPTION[\"J\"] | 'm' -> OPTION[\"m\"] | 's' -> OPTION[\"s\"] | 'U' -> OPTION[\"U\"] | 'x' -> OPTION[\"x\"] )
			int alt20=6;
			switch ( input.LA(1) ) {
			case ILC:
				{
				alt20=1;
				}
				break;
			case JUC:
				{
				alt20=2;
				}
				break;
			case MLC:
				{
				alt20=3;
				}
				break;
			case SLC:
				{
				alt20=4;
				}
				break;
			case UUC:
				{
				alt20=5;
				}
				break;
			case XLC:
				{
				alt20=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// PCRE.g:393:4: 'i'
					{
					char_literal193=(Token)match(input,ILC,FOLLOW_ILC_in_option_flag2271); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ILC.add(char_literal193);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 393:8: -> OPTION[\"i\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTION, "i"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:394:4: 'J'
					{
					char_literal194=(Token)match(input,JUC,FOLLOW_JUC_in_option_flag2281); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_JUC.add(char_literal194);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 394:8: -> OPTION[\"J\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTION, "J"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:395:4: 'm'
					{
					char_literal195=(Token)match(input,MLC,FOLLOW_MLC_in_option_flag2291); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MLC.add(char_literal195);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 395:8: -> OPTION[\"m\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTION, "m"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:396:4: 's'
					{
					char_literal196=(Token)match(input,SLC,FOLLOW_SLC_in_option_flag2301); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SLC.add(char_literal196);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 396:8: -> OPTION[\"s\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTION, "s"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:397:4: 'U'
					{
					char_literal197=(Token)match(input,UUC,FOLLOW_UUC_in_option_flag2311); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal197);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 397:8: -> OPTION[\"U\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTION, "U"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:398:4: 'x'
					{
					char_literal198=(Token)match(input,XLC,FOLLOW_XLC_in_option_flag2321); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_XLC.add(char_literal198);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 398:8: -> OPTION[\"x\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OPTION, "x"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, option_flag_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "option_flag"


	public static class look_around_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "look_around"
	// PCRE.g:409:1: look_around : ( '(' '?' '=' regex ')' -> ^( LOOK_AHEAD regex ) | '(' '?' '!' regex ')' -> ^( NEGATIVE_LOOK_AHEAD regex ) | '(' '?' '<' '=' regex ')' -> ^( LOOK_BEHIND regex ) | '(' '?' '<' '!' regex ')' -> ^( NEGATIVE_LOOK_BEHIND regex ) );
	public final PCREParser.look_around_return look_around() throws RecognitionException {
		PCREParser.look_around_return retval = new PCREParser.look_around_return();
		retval.start = input.LT(1);
		int look_around_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal199=null;
		Token char_literal200=null;
		Token char_literal201=null;
		Token char_literal203=null;
		Token char_literal204=null;
		Token char_literal205=null;
		Token char_literal206=null;
		Token char_literal208=null;
		Token char_literal209=null;
		Token char_literal210=null;
		Token char_literal211=null;
		Token char_literal212=null;
		Token char_literal214=null;
		Token char_literal215=null;
		Token char_literal216=null;
		Token char_literal217=null;
		Token char_literal218=null;
		Token char_literal220=null;
		ParserRuleReturnScope regex202 =null;
		ParserRuleReturnScope regex207 =null;
		ParserRuleReturnScope regex213 =null;
		ParserRuleReturnScope regex219 =null;

		CommonTree char_literal199_tree=null;
		CommonTree char_literal200_tree=null;
		CommonTree char_literal201_tree=null;
		CommonTree char_literal203_tree=null;
		CommonTree char_literal204_tree=null;
		CommonTree char_literal205_tree=null;
		CommonTree char_literal206_tree=null;
		CommonTree char_literal208_tree=null;
		CommonTree char_literal209_tree=null;
		CommonTree char_literal210_tree=null;
		CommonTree char_literal211_tree=null;
		CommonTree char_literal212_tree=null;
		CommonTree char_literal214_tree=null;
		CommonTree char_literal215_tree=null;
		CommonTree char_literal216_tree=null;
		CommonTree char_literal217_tree=null;
		CommonTree char_literal218_tree=null;
		CommonTree char_literal220_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
		RewriteRuleTokenStream stream_LessThan=new RewriteRuleTokenStream(adaptor,"token LessThan");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Exclamation=new RewriteRuleTokenStream(adaptor,"token Exclamation");
		RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

			// PCRE.g:410:2: ( '(' '?' '=' regex ')' -> ^( LOOK_AHEAD regex ) | '(' '?' '!' regex ')' -> ^( NEGATIVE_LOOK_AHEAD regex ) | '(' '?' '<' '=' regex ')' -> ^( LOOK_BEHIND regex ) | '(' '?' '<' '!' regex ')' -> ^( NEGATIVE_LOOK_BEHIND regex ) )
			int alt21=4;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==OpenParen) ) {
				int LA21_1 = input.LA(2);
				if ( (LA21_1==QuestionMark) ) {
					switch ( input.LA(3) ) {
					case Equals:
						{
						alt21=1;
						}
						break;
					case Exclamation:
						{
						alt21=2;
						}
						break;
					case LessThan:
						{
						int LA21_5 = input.LA(4);
						if ( (LA21_5==Equals) ) {
							alt21=3;
						}
						else if ( (LA21_5==Exclamation) ) {
							alt21=4;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 21, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 21, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// PCRE.g:410:4: '(' '?' '=' regex ')'
					{
					char_literal199=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_look_around2345); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal199);

					char_literal200=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_look_around2347); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal200);

					char_literal201=(Token)match(input,Equals,FOLLOW_Equals_in_look_around2349); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Equals.add(char_literal201);

					pushFollow(FOLLOW_regex_in_look_around2351);
					regex202=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex202.getTree());
					char_literal203=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_look_around2353); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal203);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 410:30: -> ^( LOOK_AHEAD regex )
					{
						// PCRE.g:410:33: ^( LOOK_AHEAD regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOOK_AHEAD, "LOOK_AHEAD"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:411:4: '(' '?' '!' regex ')'
					{
					char_literal204=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_look_around2370); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal204);

					char_literal205=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_look_around2372); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal205);

					char_literal206=(Token)match(input,Exclamation,FOLLOW_Exclamation_in_look_around2374); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Exclamation.add(char_literal206);

					pushFollow(FOLLOW_regex_in_look_around2376);
					regex207=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex207.getTree());
					char_literal208=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_look_around2378); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal208);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 411:30: -> ^( NEGATIVE_LOOK_AHEAD regex )
					{
						// PCRE.g:411:33: ^( NEGATIVE_LOOK_AHEAD regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEGATIVE_LOOK_AHEAD, "NEGATIVE_LOOK_AHEAD"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:412:4: '(' '?' '<' '=' regex ')'
					{
					char_literal209=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_look_around2395); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal209);

					char_literal210=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_look_around2397); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal210);

					char_literal211=(Token)match(input,LessThan,FOLLOW_LessThan_in_look_around2399); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal211);

					char_literal212=(Token)match(input,Equals,FOLLOW_Equals_in_look_around2401); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Equals.add(char_literal212);

					pushFollow(FOLLOW_regex_in_look_around2403);
					regex213=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex213.getTree());
					char_literal214=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_look_around2405); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal214);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 412:30: -> ^( LOOK_BEHIND regex )
					{
						// PCRE.g:412:33: ^( LOOK_BEHIND regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOOK_BEHIND, "LOOK_BEHIND"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:413:4: '(' '?' '<' '!' regex ')'
					{
					char_literal215=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_look_around2418); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal215);

					char_literal216=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_look_around2420); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal216);

					char_literal217=(Token)match(input,LessThan,FOLLOW_LessThan_in_look_around2422); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal217);

					char_literal218=(Token)match(input,Exclamation,FOLLOW_Exclamation_in_look_around2424); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Exclamation.add(char_literal218);

					pushFollow(FOLLOW_regex_in_look_around2426);
					regex219=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(regex219.getTree());
					char_literal220=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_look_around2428); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal220);

					// AST REWRITE
					// elements: regex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 413:30: -> ^( NEGATIVE_LOOK_BEHIND regex )
					{
						// PCRE.g:413:33: ^( NEGATIVE_LOOK_BEHIND regex )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEGATIVE_LOOK_BEHIND, "NEGATIVE_LOOK_BEHIND"), root_1);
						adaptor.addChild(root_1, stream_regex.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 18, look_around_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "look_around"


	public static class subroutine_reference_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "subroutine_reference"
	// PCRE.g:432:1: subroutine_reference : ( '(' '?' 'R' ')' -> ^( NUMBERED_REFERENCE_ABSOLUTE NUMBER[\"0\"] ) | '(' '?' number ')' -> ^( NUMBERED_REFERENCE_ABSOLUTE number ) | '(' '?' '+' number ')' -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number ) | '(' '?' '-' number ')' -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number ) | '(' '?' '&' name ')' -> ^( NAMED_REFERENCE_PERL name ) | '(' '?' 'P' '>' name ')' -> ^( NAMED_REFERENCE_PYTHON name ) | '\\\\g' '<' name '>' -> ^( NAMED_REFERENCE_ONIGURUMA name ) | '\\\\g' '\\'' name '\\'' -> ^( NAMED_REFERENCE_ONIGURUMA name ) | '\\\\g' '<' number '>' -> ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number ) | '\\\\g' '\\'' number '\\'' -> ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number ) | '\\\\g' '<' '+' number '>' -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number ) | '\\\\g' '\\'' '+' number '\\'' -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number ) | '\\\\g' '<' '-' number '>' -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number ) | '\\\\g' '\\'' '-' number '\\'' -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number ) );
	public final PCREParser.subroutine_reference_return subroutine_reference() throws RecognitionException {
		PCREParser.subroutine_reference_return retval = new PCREParser.subroutine_reference_return();
		retval.start = input.LT(1);
		int subroutine_reference_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal221=null;
		Token char_literal222=null;
		Token char_literal223=null;
		Token char_literal224=null;
		Token char_literal225=null;
		Token char_literal226=null;
		Token char_literal228=null;
		Token char_literal229=null;
		Token char_literal230=null;
		Token char_literal231=null;
		Token char_literal233=null;
		Token char_literal234=null;
		Token char_literal235=null;
		Token char_literal236=null;
		Token char_literal238=null;
		Token char_literal239=null;
		Token char_literal240=null;
		Token char_literal241=null;
		Token char_literal243=null;
		Token char_literal244=null;
		Token char_literal245=null;
		Token char_literal246=null;
		Token char_literal247=null;
		Token char_literal249=null;
		Token string_literal250=null;
		Token char_literal251=null;
		Token char_literal253=null;
		Token string_literal254=null;
		Token char_literal255=null;
		Token char_literal257=null;
		Token string_literal258=null;
		Token char_literal259=null;
		Token char_literal261=null;
		Token string_literal262=null;
		Token char_literal263=null;
		Token char_literal265=null;
		Token string_literal266=null;
		Token char_literal267=null;
		Token char_literal268=null;
		Token char_literal270=null;
		Token string_literal271=null;
		Token char_literal272=null;
		Token char_literal273=null;
		Token char_literal275=null;
		Token string_literal276=null;
		Token char_literal277=null;
		Token char_literal278=null;
		Token char_literal280=null;
		Token string_literal281=null;
		Token char_literal282=null;
		Token char_literal283=null;
		Token char_literal285=null;
		ParserRuleReturnScope number227 =null;
		ParserRuleReturnScope number232 =null;
		ParserRuleReturnScope number237 =null;
		ParserRuleReturnScope name242 =null;
		ParserRuleReturnScope name248 =null;
		ParserRuleReturnScope name252 =null;
		ParserRuleReturnScope name256 =null;
		ParserRuleReturnScope number260 =null;
		ParserRuleReturnScope number264 =null;
		ParserRuleReturnScope number269 =null;
		ParserRuleReturnScope number274 =null;
		ParserRuleReturnScope number279 =null;
		ParserRuleReturnScope number284 =null;

		CommonTree char_literal221_tree=null;
		CommonTree char_literal222_tree=null;
		CommonTree char_literal223_tree=null;
		CommonTree char_literal224_tree=null;
		CommonTree char_literal225_tree=null;
		CommonTree char_literal226_tree=null;
		CommonTree char_literal228_tree=null;
		CommonTree char_literal229_tree=null;
		CommonTree char_literal230_tree=null;
		CommonTree char_literal231_tree=null;
		CommonTree char_literal233_tree=null;
		CommonTree char_literal234_tree=null;
		CommonTree char_literal235_tree=null;
		CommonTree char_literal236_tree=null;
		CommonTree char_literal238_tree=null;
		CommonTree char_literal239_tree=null;
		CommonTree char_literal240_tree=null;
		CommonTree char_literal241_tree=null;
		CommonTree char_literal243_tree=null;
		CommonTree char_literal244_tree=null;
		CommonTree char_literal245_tree=null;
		CommonTree char_literal246_tree=null;
		CommonTree char_literal247_tree=null;
		CommonTree char_literal249_tree=null;
		CommonTree string_literal250_tree=null;
		CommonTree char_literal251_tree=null;
		CommonTree char_literal253_tree=null;
		CommonTree string_literal254_tree=null;
		CommonTree char_literal255_tree=null;
		CommonTree char_literal257_tree=null;
		CommonTree string_literal258_tree=null;
		CommonTree char_literal259_tree=null;
		CommonTree char_literal261_tree=null;
		CommonTree string_literal262_tree=null;
		CommonTree char_literal263_tree=null;
		CommonTree char_literal265_tree=null;
		CommonTree string_literal266_tree=null;
		CommonTree char_literal267_tree=null;
		CommonTree char_literal268_tree=null;
		CommonTree char_literal270_tree=null;
		CommonTree string_literal271_tree=null;
		CommonTree char_literal272_tree=null;
		CommonTree char_literal273_tree=null;
		CommonTree char_literal275_tree=null;
		CommonTree string_literal276_tree=null;
		CommonTree char_literal277_tree=null;
		CommonTree char_literal278_tree=null;
		CommonTree char_literal280_tree=null;
		CommonTree string_literal281_tree=null;
		CommonTree char_literal282_tree=null;
		CommonTree char_literal283_tree=null;
		CommonTree char_literal285_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_RUC=new RewriteRuleTokenStream(adaptor,"token RUC");
		RewriteRuleTokenStream stream_LessThan=new RewriteRuleTokenStream(adaptor,"token LessThan");
		RewriteRuleTokenStream stream_GreaterThan=new RewriteRuleTokenStream(adaptor,"token GreaterThan");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleTokenStream stream_SingleQuote=new RewriteRuleTokenStream(adaptor,"token SingleQuote");
		RewriteRuleTokenStream stream_Ampersand=new RewriteRuleTokenStream(adaptor,"token Ampersand");
		RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
		RewriteRuleTokenStream stream_SubroutineOrNamedReferenceStartG=new RewriteRuleTokenStream(adaptor,"token SubroutineOrNamedReferenceStartG");
		RewriteRuleTokenStream stream_PUC=new RewriteRuleTokenStream(adaptor,"token PUC");
		RewriteRuleSubtreeStream stream_number=new RewriteRuleSubtreeStream(adaptor,"rule number");
		RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

			// PCRE.g:433:2: ( '(' '?' 'R' ')' -> ^( NUMBERED_REFERENCE_ABSOLUTE NUMBER[\"0\"] ) | '(' '?' number ')' -> ^( NUMBERED_REFERENCE_ABSOLUTE number ) | '(' '?' '+' number ')' -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number ) | '(' '?' '-' number ')' -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number ) | '(' '?' '&' name ')' -> ^( NAMED_REFERENCE_PERL name ) | '(' '?' 'P' '>' name ')' -> ^( NAMED_REFERENCE_PYTHON name ) | '\\\\g' '<' name '>' -> ^( NAMED_REFERENCE_ONIGURUMA name ) | '\\\\g' '\\'' name '\\'' -> ^( NAMED_REFERENCE_ONIGURUMA name ) | '\\\\g' '<' number '>' -> ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number ) | '\\\\g' '\\'' number '\\'' -> ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number ) | '\\\\g' '<' '+' number '>' -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number ) | '\\\\g' '\\'' '+' number '\\'' -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number ) | '\\\\g' '<' '-' number '>' -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number ) | '\\\\g' '\\'' '-' number '\\'' -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number ) )
			int alt22=14;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==OpenParen) ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1==QuestionMark) ) {
					switch ( input.LA(3) ) {
					case RUC:
						{
						alt22=1;
						}
						break;
					case Plus:
						{
						alt22=3;
						}
						break;
					case Hyphen:
						{
						alt22=4;
						}
						break;
					case Ampersand:
						{
						alt22=5;
						}
						break;
					case PUC:
						{
						alt22=6;
						}
						break;
					case D0:
					case D1:
					case D2:
					case D3:
					case D4:
					case D5:
					case D6:
					case D7:
					case D8:
					case D9:
						{
						alt22=2;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 22, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA22_0==SubroutineOrNamedReferenceStartG) ) {
				int LA22_2 = input.LA(2);
				if ( (LA22_2==LessThan) ) {
					switch ( input.LA(3) ) {
					case Plus:
						{
						alt22=11;
						}
						break;
					case Hyphen:
						{
						alt22=13;
						}
						break;
					case ALC:
					case AUC:
					case BLC:
					case BUC:
					case CLC:
					case CUC:
					case DLC:
					case DUC:
					case ELC:
					case EUC:
					case FLC:
					case FUC:
					case GLC:
					case GUC:
					case HLC:
					case HUC:
					case ILC:
					case IUC:
					case JLC:
					case JUC:
					case KLC:
					case KUC:
					case LLC:
					case LUC:
					case MLC:
					case MUC:
					case NLC:
					case NUC:
					case OLC:
					case OUC:
					case PLC:
					case PUC:
					case QLC:
					case QUC:
					case RLC:
					case RUC:
					case SLC:
					case SUC:
					case TLC:
					case TUC:
					case ULC:
					case UUC:
					case Underscore:
					case VLC:
					case VUC:
					case WLC:
					case WUC:
					case XLC:
					case XUC:
					case YLC:
					case YUC:
					case ZLC:
					case ZUC:
						{
						alt22=7;
						}
						break;
					case D0:
					case D1:
					case D2:
					case D3:
					case D4:
					case D5:
					case D6:
					case D7:
					case D8:
					case D9:
						{
						alt22=9;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 22, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA22_2==SingleQuote) ) {
					switch ( input.LA(3) ) {
					case Plus:
						{
						alt22=12;
						}
						break;
					case Hyphen:
						{
						alt22=14;
						}
						break;
					case ALC:
					case AUC:
					case BLC:
					case BUC:
					case CLC:
					case CUC:
					case DLC:
					case DUC:
					case ELC:
					case EUC:
					case FLC:
					case FUC:
					case GLC:
					case GUC:
					case HLC:
					case HUC:
					case ILC:
					case IUC:
					case JLC:
					case JUC:
					case KLC:
					case KUC:
					case LLC:
					case LUC:
					case MLC:
					case MUC:
					case NLC:
					case NUC:
					case OLC:
					case OUC:
					case PLC:
					case PUC:
					case QLC:
					case QUC:
					case RLC:
					case RUC:
					case SLC:
					case SUC:
					case TLC:
					case TUC:
					case ULC:
					case UUC:
					case Underscore:
					case VLC:
					case VUC:
					case WLC:
					case WUC:
					case XLC:
					case XUC:
					case YLC:
					case YUC:
					case ZLC:
					case ZUC:
						{
						alt22=8;
						}
						break;
					case D0:
					case D1:
					case D2:
					case D3:
					case D4:
					case D5:
					case D6:
					case D7:
					case D8:
					case D9:
						{
						alt22=10;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 22, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// PCRE.g:433:4: '(' '?' 'R' ')'
					{
					char_literal221=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_subroutine_reference2463); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal221);

					char_literal222=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_subroutine_reference2465); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal222);

					char_literal223=(Token)match(input,RUC,FOLLOW_RUC_in_subroutine_reference2467); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal223);

					char_literal224=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_subroutine_reference2469); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal224);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 433:31: -> ^( NUMBERED_REFERENCE_ABSOLUTE NUMBER[\"0\"] )
					{
						// PCRE.g:433:34: ^( NUMBERED_REFERENCE_ABSOLUTE NUMBER[\"0\"] )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_ABSOLUTE, "NUMBERED_REFERENCE_ABSOLUTE"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(NUMBER, "0"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:434:4: '(' '?' number ')'
					{
					char_literal225=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_subroutine_reference2494); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal225);

					char_literal226=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_subroutine_reference2496); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal226);

					pushFollow(FOLLOW_number_in_subroutine_reference2498);
					number227=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number227.getTree());
					char_literal228=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_subroutine_reference2500); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal228);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 434:31: -> ^( NUMBERED_REFERENCE_ABSOLUTE number )
					{
						// PCRE.g:434:34: ^( NUMBERED_REFERENCE_ABSOLUTE number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_ABSOLUTE, "NUMBERED_REFERENCE_ABSOLUTE"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:435:4: '(' '?' '+' number ')'
					{
					char_literal229=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_subroutine_reference2521); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal229);

					char_literal230=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_subroutine_reference2523); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal230);

					char_literal231=(Token)match(input,Plus,FOLLOW_Plus_in_subroutine_reference2525); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(char_literal231);

					pushFollow(FOLLOW_number_in_subroutine_reference2527);
					number232=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number232.getTree());
					char_literal233=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_subroutine_reference2529); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal233);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 435:31: -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number )
					{
						// PCRE.g:435:34: ^( NUMBERED_REFERENCE_RELATIVE_PLUS number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_RELATIVE_PLUS, "NUMBERED_REFERENCE_RELATIVE_PLUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:436:4: '(' '?' '-' number ')'
					{
					char_literal234=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_subroutine_reference2546); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal234);

					char_literal235=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_subroutine_reference2548); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal235);

					char_literal236=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_subroutine_reference2550); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal236);

					pushFollow(FOLLOW_number_in_subroutine_reference2552);
					number237=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number237.getTree());
					char_literal238=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_subroutine_reference2554); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal238);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 436:31: -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number )
					{
						// PCRE.g:436:34: ^( NUMBERED_REFERENCE_RELATIVE_MINUS number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_RELATIVE_MINUS, "NUMBERED_REFERENCE_RELATIVE_MINUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:437:4: '(' '?' '&' name ')'
					{
					char_literal239=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_subroutine_reference2571); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal239);

					char_literal240=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_subroutine_reference2573); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal240);

					char_literal241=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_subroutine_reference2575); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Ampersand.add(char_literal241);

					pushFollow(FOLLOW_name_in_subroutine_reference2577);
					name242=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name242.getTree());
					char_literal243=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_subroutine_reference2579); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal243);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 437:31: -> ^( NAMED_REFERENCE_PERL name )
					{
						// PCRE.g:437:34: ^( NAMED_REFERENCE_PERL name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_PERL, "NAMED_REFERENCE_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:438:4: '(' '?' 'P' '>' name ')'
					{
					char_literal244=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_subroutine_reference2598); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal244);

					char_literal245=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_subroutine_reference2600); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal245);

					char_literal246=(Token)match(input,PUC,FOLLOW_PUC_in_subroutine_reference2602); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal246);

					char_literal247=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_subroutine_reference2604); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal247);

					pushFollow(FOLLOW_name_in_subroutine_reference2606);
					name248=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name248.getTree());
					char_literal249=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_subroutine_reference2608); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal249);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 438:31: -> ^( NAMED_REFERENCE_PYTHON name )
					{
						// PCRE.g:438:34: ^( NAMED_REFERENCE_PYTHON name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_PYTHON, "NAMED_REFERENCE_PYTHON"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:439:4: '\\\\g' '<' name '>'
					{
					string_literal250=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2623); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal250);

					char_literal251=(Token)match(input,LessThan,FOLLOW_LessThan_in_subroutine_reference2625); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal251);

					pushFollow(FOLLOW_name_in_subroutine_reference2627);
					name252=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name252.getTree());
					char_literal253=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_subroutine_reference2629); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal253);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 439:31: -> ^( NAMED_REFERENCE_ONIGURUMA name )
					{
						// PCRE.g:439:34: ^( NAMED_REFERENCE_ONIGURUMA name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_ONIGURUMA, "NAMED_REFERENCE_ONIGURUMA"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// PCRE.g:440:4: '\\\\g' '\\'' name '\\''
					{
					string_literal254=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2650); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal254);

					char_literal255=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2652); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal255);

					pushFollow(FOLLOW_name_in_subroutine_reference2654);
					name256=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name256.getTree());
					char_literal257=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2656); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal257);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 440:31: -> ^( NAMED_REFERENCE_ONIGURUMA name )
					{
						// PCRE.g:440:34: ^( NAMED_REFERENCE_ONIGURUMA name )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_ONIGURUMA, "NAMED_REFERENCE_ONIGURUMA"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// PCRE.g:441:4: '\\\\g' '<' number '>'
					{
					string_literal258=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2675); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal258);

					char_literal259=(Token)match(input,LessThan,FOLLOW_LessThan_in_subroutine_reference2677); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal259);

					pushFollow(FOLLOW_number_in_subroutine_reference2679);
					number260=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number260.getTree());
					char_literal261=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_subroutine_reference2681); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal261);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 441:31: -> ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number )
					{
						// PCRE.g:441:34: ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA, "NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// PCRE.g:442:4: '\\\\g' '\\'' number '\\''
					{
					string_literal262=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2700); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal262);

					char_literal263=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2702); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal263);

					pushFollow(FOLLOW_number_in_subroutine_reference2704);
					number264=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number264.getTree());
					char_literal265=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2706); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal265);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 442:31: -> ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number )
					{
						// PCRE.g:442:34: ^( NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA, "NUMBERED_REFERENCE_ABSOLUTE_ONIGURUMA"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 11 :
					// PCRE.g:443:4: '\\\\g' '<' '+' number '>'
					{
					string_literal266=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2723); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal266);

					char_literal267=(Token)match(input,LessThan,FOLLOW_LessThan_in_subroutine_reference2725); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal267);

					char_literal268=(Token)match(input,Plus,FOLLOW_Plus_in_subroutine_reference2727); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(char_literal268);

					pushFollow(FOLLOW_number_in_subroutine_reference2729);
					number269=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number269.getTree());
					char_literal270=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_subroutine_reference2731); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal270);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 443:31: -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number )
					{
						// PCRE.g:443:34: ^( NUMBERED_REFERENCE_RELATIVE_PLUS number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_RELATIVE_PLUS, "NUMBERED_REFERENCE_RELATIVE_PLUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 12 :
					// PCRE.g:444:4: '\\\\g' '\\'' '+' number '\\''
					{
					string_literal271=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2746); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal271);

					char_literal272=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2748); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal272);

					char_literal273=(Token)match(input,Plus,FOLLOW_Plus_in_subroutine_reference2750); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(char_literal273);

					pushFollow(FOLLOW_number_in_subroutine_reference2752);
					number274=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number274.getTree());
					char_literal275=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2754); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal275);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 444:31: -> ^( NUMBERED_REFERENCE_RELATIVE_PLUS number )
					{
						// PCRE.g:444:34: ^( NUMBERED_REFERENCE_RELATIVE_PLUS number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_RELATIVE_PLUS, "NUMBERED_REFERENCE_RELATIVE_PLUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 13 :
					// PCRE.g:445:4: '\\\\g' '<' '-' number '>'
					{
					string_literal276=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2767); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal276);

					char_literal277=(Token)match(input,LessThan,FOLLOW_LessThan_in_subroutine_reference2769); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal277);

					char_literal278=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_subroutine_reference2771); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal278);

					pushFollow(FOLLOW_number_in_subroutine_reference2773);
					number279=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number279.getTree());
					char_literal280=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_subroutine_reference2775); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal280);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 445:31: -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number )
					{
						// PCRE.g:445:34: ^( NUMBERED_REFERENCE_RELATIVE_MINUS number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_RELATIVE_MINUS, "NUMBERED_REFERENCE_RELATIVE_MINUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 14 :
					// PCRE.g:446:4: '\\\\g' '\\'' '-' number '\\''
					{
					string_literal281=(Token)match(input,SubroutineOrNamedReferenceStartG,FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2790); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SubroutineOrNamedReferenceStartG.add(string_literal281);

					char_literal282=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2792); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal282);

					char_literal283=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_subroutine_reference2794); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal283);

					pushFollow(FOLLOW_number_in_subroutine_reference2796);
					number284=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number284.getTree());
					char_literal285=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_subroutine_reference2798); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal285);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 446:31: -> ^( NUMBERED_REFERENCE_RELATIVE_MINUS number )
					{
						// PCRE.g:446:34: ^( NUMBERED_REFERENCE_RELATIVE_MINUS number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NUMBERED_REFERENCE_RELATIVE_MINUS, "NUMBERED_REFERENCE_RELATIVE_MINUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 19, subroutine_reference_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "subroutine_reference"


	public static class conditional_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "conditional"
	// PCRE.g:465:1: conditional : ( '(' '?' '(' number ')' t= regex ( '|' f= regex )? ')' -> ^( REFERENCE_CONDITION_ABSOLUTE number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '+' number ')' t= regex ( '|' f= regex )? ')' -> ^( REFERENCE_CONDITION_RELATIVE_PLUS number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '-' number ')' t= regex ( '|' f= regex )? ')' -> ^( REFERENCE_CONDITION_RELATIVE_MINUS number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '<' name '>' ')' t= regex ( '|' f= regex )? ')' -> ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '\\'' name '\\'' ')' t= regex ( '|' f= regex )? ')' -> ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'R' number ')' t= regex ( '|' f= regex )? ')' -> ^( SPECIFIC_GROUP_RECURSION_CONDITION number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'R' ')' t= regex ( '|' f= regex )? ')' -> ^( OVERALL_RECURSION_CONDITION ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'R' '&' name ')' t= regex ( '|' f= regex )? ')' -> ^( SPECIFIC_RECURSION_CONDITION name ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'D' 'E' 'F' 'I' 'N' 'E' ')' t= regex ( '|' f= regex )? ')' -> ^( DEFINE ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'a' 's' 's' 'e' 'r' 't' ')' t= regex ( '|' f= regex )? ')' -> ^( ASSERT ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' name ')' t= regex ( '|' f= regex )? ')' -> ^( NAMED_REFERENCE_CONDITION name ^( YES $t) ^( NO ( $f)? ) ) );
	public final PCREParser.conditional_return conditional() throws RecognitionException {
		PCREParser.conditional_return retval = new PCREParser.conditional_return();
		retval.start = input.LT(1);
		int conditional_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal286=null;
		Token char_literal287=null;
		Token char_literal288=null;
		Token char_literal290=null;
		Token char_literal291=null;
		Token char_literal292=null;
		Token char_literal293=null;
		Token char_literal294=null;
		Token char_literal295=null;
		Token char_literal296=null;
		Token char_literal298=null;
		Token char_literal299=null;
		Token char_literal300=null;
		Token char_literal301=null;
		Token char_literal302=null;
		Token char_literal303=null;
		Token char_literal304=null;
		Token char_literal306=null;
		Token char_literal307=null;
		Token char_literal308=null;
		Token char_literal309=null;
		Token char_literal310=null;
		Token char_literal311=null;
		Token char_literal312=null;
		Token char_literal314=null;
		Token char_literal315=null;
		Token char_literal316=null;
		Token char_literal317=null;
		Token char_literal318=null;
		Token char_literal319=null;
		Token char_literal320=null;
		Token char_literal321=null;
		Token char_literal323=null;
		Token char_literal324=null;
		Token char_literal325=null;
		Token char_literal326=null;
		Token char_literal327=null;
		Token char_literal328=null;
		Token char_literal329=null;
		Token char_literal330=null;
		Token char_literal332=null;
		Token char_literal333=null;
		Token char_literal334=null;
		Token char_literal335=null;
		Token char_literal336=null;
		Token char_literal337=null;
		Token char_literal338=null;
		Token char_literal339=null;
		Token char_literal340=null;
		Token char_literal341=null;
		Token char_literal342=null;
		Token char_literal343=null;
		Token char_literal344=null;
		Token char_literal345=null;
		Token char_literal346=null;
		Token char_literal348=null;
		Token char_literal349=null;
		Token char_literal350=null;
		Token char_literal351=null;
		Token char_literal352=null;
		Token char_literal353=null;
		Token char_literal354=null;
		Token char_literal355=null;
		Token char_literal356=null;
		Token char_literal357=null;
		Token char_literal358=null;
		Token char_literal359=null;
		Token char_literal360=null;
		Token char_literal361=null;
		Token char_literal362=null;
		Token char_literal363=null;
		Token char_literal364=null;
		Token char_literal365=null;
		Token char_literal366=null;
		Token char_literal367=null;
		Token char_literal368=null;
		Token char_literal369=null;
		Token char_literal370=null;
		Token char_literal371=null;
		Token char_literal372=null;
		Token char_literal373=null;
		Token char_literal374=null;
		Token char_literal375=null;
		Token char_literal376=null;
		Token char_literal377=null;
		Token char_literal379=null;
		Token char_literal380=null;
		Token char_literal381=null;
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope number289 =null;
		ParserRuleReturnScope number297 =null;
		ParserRuleReturnScope number305 =null;
		ParserRuleReturnScope name313 =null;
		ParserRuleReturnScope name322 =null;
		ParserRuleReturnScope number331 =null;
		ParserRuleReturnScope name347 =null;
		ParserRuleReturnScope name378 =null;

		CommonTree char_literal286_tree=null;
		CommonTree char_literal287_tree=null;
		CommonTree char_literal288_tree=null;
		CommonTree char_literal290_tree=null;
		CommonTree char_literal291_tree=null;
		CommonTree char_literal292_tree=null;
		CommonTree char_literal293_tree=null;
		CommonTree char_literal294_tree=null;
		CommonTree char_literal295_tree=null;
		CommonTree char_literal296_tree=null;
		CommonTree char_literal298_tree=null;
		CommonTree char_literal299_tree=null;
		CommonTree char_literal300_tree=null;
		CommonTree char_literal301_tree=null;
		CommonTree char_literal302_tree=null;
		CommonTree char_literal303_tree=null;
		CommonTree char_literal304_tree=null;
		CommonTree char_literal306_tree=null;
		CommonTree char_literal307_tree=null;
		CommonTree char_literal308_tree=null;
		CommonTree char_literal309_tree=null;
		CommonTree char_literal310_tree=null;
		CommonTree char_literal311_tree=null;
		CommonTree char_literal312_tree=null;
		CommonTree char_literal314_tree=null;
		CommonTree char_literal315_tree=null;
		CommonTree char_literal316_tree=null;
		CommonTree char_literal317_tree=null;
		CommonTree char_literal318_tree=null;
		CommonTree char_literal319_tree=null;
		CommonTree char_literal320_tree=null;
		CommonTree char_literal321_tree=null;
		CommonTree char_literal323_tree=null;
		CommonTree char_literal324_tree=null;
		CommonTree char_literal325_tree=null;
		CommonTree char_literal326_tree=null;
		CommonTree char_literal327_tree=null;
		CommonTree char_literal328_tree=null;
		CommonTree char_literal329_tree=null;
		CommonTree char_literal330_tree=null;
		CommonTree char_literal332_tree=null;
		CommonTree char_literal333_tree=null;
		CommonTree char_literal334_tree=null;
		CommonTree char_literal335_tree=null;
		CommonTree char_literal336_tree=null;
		CommonTree char_literal337_tree=null;
		CommonTree char_literal338_tree=null;
		CommonTree char_literal339_tree=null;
		CommonTree char_literal340_tree=null;
		CommonTree char_literal341_tree=null;
		CommonTree char_literal342_tree=null;
		CommonTree char_literal343_tree=null;
		CommonTree char_literal344_tree=null;
		CommonTree char_literal345_tree=null;
		CommonTree char_literal346_tree=null;
		CommonTree char_literal348_tree=null;
		CommonTree char_literal349_tree=null;
		CommonTree char_literal350_tree=null;
		CommonTree char_literal351_tree=null;
		CommonTree char_literal352_tree=null;
		CommonTree char_literal353_tree=null;
		CommonTree char_literal354_tree=null;
		CommonTree char_literal355_tree=null;
		CommonTree char_literal356_tree=null;
		CommonTree char_literal357_tree=null;
		CommonTree char_literal358_tree=null;
		CommonTree char_literal359_tree=null;
		CommonTree char_literal360_tree=null;
		CommonTree char_literal361_tree=null;
		CommonTree char_literal362_tree=null;
		CommonTree char_literal363_tree=null;
		CommonTree char_literal364_tree=null;
		CommonTree char_literal365_tree=null;
		CommonTree char_literal366_tree=null;
		CommonTree char_literal367_tree=null;
		CommonTree char_literal368_tree=null;
		CommonTree char_literal369_tree=null;
		CommonTree char_literal370_tree=null;
		CommonTree char_literal371_tree=null;
		CommonTree char_literal372_tree=null;
		CommonTree char_literal373_tree=null;
		CommonTree char_literal374_tree=null;
		CommonTree char_literal375_tree=null;
		CommonTree char_literal376_tree=null;
		CommonTree char_literal377_tree=null;
		CommonTree char_literal379_tree=null;
		CommonTree char_literal380_tree=null;
		CommonTree char_literal381_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_RUC=new RewriteRuleTokenStream(adaptor,"token RUC");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleTokenStream stream_RLC=new RewriteRuleTokenStream(adaptor,"token RLC");
		RewriteRuleTokenStream stream_TLC=new RewriteRuleTokenStream(adaptor,"token TLC");
		RewriteRuleTokenStream stream_Pipe=new RewriteRuleTokenStream(adaptor,"token Pipe");
		RewriteRuleTokenStream stream_SLC=new RewriteRuleTokenStream(adaptor,"token SLC");
		RewriteRuleTokenStream stream_LessThan=new RewriteRuleTokenStream(adaptor,"token LessThan");
		RewriteRuleTokenStream stream_EUC=new RewriteRuleTokenStream(adaptor,"token EUC");
		RewriteRuleTokenStream stream_DUC=new RewriteRuleTokenStream(adaptor,"token DUC");
		RewriteRuleTokenStream stream_GreaterThan=new RewriteRuleTokenStream(adaptor,"token GreaterThan");
		RewriteRuleTokenStream stream_FUC=new RewriteRuleTokenStream(adaptor,"token FUC");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_IUC=new RewriteRuleTokenStream(adaptor,"token IUC");
		RewriteRuleTokenStream stream_SingleQuote=new RewriteRuleTokenStream(adaptor,"token SingleQuote");
		RewriteRuleTokenStream stream_ALC=new RewriteRuleTokenStream(adaptor,"token ALC");
		RewriteRuleTokenStream stream_Ampersand=new RewriteRuleTokenStream(adaptor,"token Ampersand");
		RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
		RewriteRuleTokenStream stream_NUC=new RewriteRuleTokenStream(adaptor,"token NUC");
		RewriteRuleTokenStream stream_ELC=new RewriteRuleTokenStream(adaptor,"token ELC");
		RewriteRuleSubtreeStream stream_number=new RewriteRuleSubtreeStream(adaptor,"rule number");
		RewriteRuleSubtreeStream stream_regex=new RewriteRuleSubtreeStream(adaptor,"rule regex");
		RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

			// PCRE.g:466:2: ( '(' '?' '(' number ')' t= regex ( '|' f= regex )? ')' -> ^( REFERENCE_CONDITION_ABSOLUTE number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '+' number ')' t= regex ( '|' f= regex )? ')' -> ^( REFERENCE_CONDITION_RELATIVE_PLUS number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '-' number ')' t= regex ( '|' f= regex )? ')' -> ^( REFERENCE_CONDITION_RELATIVE_MINUS number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '<' name '>' ')' t= regex ( '|' f= regex )? ')' -> ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' '\\'' name '\\'' ')' t= regex ( '|' f= regex )? ')' -> ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'R' number ')' t= regex ( '|' f= regex )? ')' -> ^( SPECIFIC_GROUP_RECURSION_CONDITION number ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'R' ')' t= regex ( '|' f= regex )? ')' -> ^( OVERALL_RECURSION_CONDITION ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'R' '&' name ')' t= regex ( '|' f= regex )? ')' -> ^( SPECIFIC_RECURSION_CONDITION name ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'D' 'E' 'F' 'I' 'N' 'E' ')' t= regex ( '|' f= regex )? ')' -> ^( DEFINE ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' 'a' 's' 's' 'e' 'r' 't' ')' t= regex ( '|' f= regex )? ')' -> ^( ASSERT ^( YES $t) ^( NO ( $f)? ) ) | '(' '?' '(' name ')' t= regex ( '|' f= regex )? ')' -> ^( NAMED_REFERENCE_CONDITION name ^( YES $t) ^( NO ( $f)? ) ) )
			int alt34=11;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==OpenParen) ) {
				int LA34_1 = input.LA(2);
				if ( (synpred66_PCRE()) ) {
					alt34=1;
				}
				else if ( (synpred68_PCRE()) ) {
					alt34=2;
				}
				else if ( (synpred70_PCRE()) ) {
					alt34=3;
				}
				else if ( (synpred72_PCRE()) ) {
					alt34=4;
				}
				else if ( (synpred74_PCRE()) ) {
					alt34=5;
				}
				else if ( (synpred76_PCRE()) ) {
					alt34=6;
				}
				else if ( (synpred78_PCRE()) ) {
					alt34=7;
				}
				else if ( (synpred80_PCRE()) ) {
					alt34=8;
				}
				else if ( (synpred82_PCRE()) ) {
					alt34=9;
				}
				else if ( (synpred84_PCRE()) ) {
					alt34=10;
				}
				else if ( (true) ) {
					alt34=11;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// PCRE.g:466:4: '(' '?' '(' number ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal286=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional2833); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal286);

					char_literal287=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional2835); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal287);

					char_literal288=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional2837); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal288);

					pushFollow(FOLLOW_number_in_conditional2839);
					number289=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number289.getTree());
					char_literal290=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional2841); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal290);

					pushFollow(FOLLOW_regex_in_conditional2845);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:466:35: ( '|' f= regex )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==Pipe) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// PCRE.g:466:36: '|' f= regex
							{
							char_literal291=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional2848); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal291);

							pushFollow(FOLLOW_regex_in_conditional2852);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal292=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional2856); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal292);

					// AST REWRITE
					// elements: number, f, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 466:71: -> ^( REFERENCE_CONDITION_ABSOLUTE number ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:466:74: ^( REFERENCE_CONDITION_ABSOLUTE number ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REFERENCE_CONDITION_ABSOLUTE, "REFERENCE_CONDITION_ABSOLUTE"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						// PCRE.g:466:112: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:466:122: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:466:128: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:467:4: '(' '?' '(' '+' number ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal293=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional2901); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal293);

					char_literal294=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional2903); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal294);

					char_literal295=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional2905); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal295);

					char_literal296=(Token)match(input,Plus,FOLLOW_Plus_in_conditional2907); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(char_literal296);

					pushFollow(FOLLOW_number_in_conditional2909);
					number297=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number297.getTree());
					char_literal298=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional2911); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal298);

					pushFollow(FOLLOW_regex_in_conditional2915);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:467:39: ( '|' f= regex )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==Pipe) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// PCRE.g:467:40: '|' f= regex
							{
							char_literal299=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional2918); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal299);

							pushFollow(FOLLOW_regex_in_conditional2922);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal300=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional2926); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal300);

					// AST REWRITE
					// elements: number, f, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 467:71: -> ^( REFERENCE_CONDITION_RELATIVE_PLUS number ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:467:74: ^( REFERENCE_CONDITION_RELATIVE_PLUS number ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REFERENCE_CONDITION_RELATIVE_PLUS, "REFERENCE_CONDITION_RELATIVE_PLUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						// PCRE.g:467:117: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:467:127: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:467:133: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:468:4: '(' '?' '(' '-' number ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal301=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional2967); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal301);

					char_literal302=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional2969); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal302);

					char_literal303=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional2971); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal303);

					char_literal304=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_conditional2973); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(char_literal304);

					pushFollow(FOLLOW_number_in_conditional2975);
					number305=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number305.getTree());
					char_literal306=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional2977); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal306);

					pushFollow(FOLLOW_regex_in_conditional2981);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:468:39: ( '|' f= regex )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==Pipe) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// PCRE.g:468:40: '|' f= regex
							{
							char_literal307=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional2984); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal307);

							pushFollow(FOLLOW_regex_in_conditional2988);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal308=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional2992); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal308);

					// AST REWRITE
					// elements: number, f, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 468:71: -> ^( REFERENCE_CONDITION_RELATIVE_MINUS number ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:468:74: ^( REFERENCE_CONDITION_RELATIVE_MINUS number ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REFERENCE_CONDITION_RELATIVE_MINUS, "REFERENCE_CONDITION_RELATIVE_MINUS"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						// PCRE.g:468:118: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:468:128: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:468:134: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:469:4: '(' '?' '(' '<' name '>' ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal309=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3033); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal309);

					char_literal310=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3035); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal310);

					char_literal311=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3037); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal311);

					char_literal312=(Token)match(input,LessThan,FOLLOW_LessThan_in_conditional3039); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(char_literal312);

					pushFollow(FOLLOW_name_in_conditional3041);
					name313=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name313.getTree());
					char_literal314=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_conditional3043); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(char_literal314);

					char_literal315=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3045); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal315);

					pushFollow(FOLLOW_regex_in_conditional3049);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:469:41: ( '|' f= regex )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==Pipe) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// PCRE.g:469:42: '|' f= regex
							{
							char_literal316=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3052); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal316);

							pushFollow(FOLLOW_regex_in_conditional3056);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal317=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3060); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal317);

					// AST REWRITE
					// elements: name, t, f
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 469:71: -> ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:469:74: ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_CONDITION_PERL, "NAMED_REFERENCE_CONDITION_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// PCRE.g:469:112: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:469:122: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:469:128: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:470:4: '(' '?' '(' '\\'' name '\\'' ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal318=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3099); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal318);

					char_literal319=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3101); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal319);

					char_literal320=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3103); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal320);

					char_literal321=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_conditional3105); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal321);

					pushFollow(FOLLOW_name_in_conditional3107);
					name322=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name322.getTree());
					char_literal323=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_conditional3109); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(char_literal323);

					char_literal324=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3111); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal324);

					pushFollow(FOLLOW_regex_in_conditional3115);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:470:43: ( '|' f= regex )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==Pipe) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// PCRE.g:470:44: '|' f= regex
							{
							char_literal325=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3118); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal325);

							pushFollow(FOLLOW_regex_in_conditional3122);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal326=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3126); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal326);

					// AST REWRITE
					// elements: name, f, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 470:71: -> ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:470:74: ^( NAMED_REFERENCE_CONDITION_PERL name ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_CONDITION_PERL, "NAMED_REFERENCE_CONDITION_PERL"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// PCRE.g:470:112: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:470:122: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:470:128: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:471:4: '(' '?' '(' 'R' number ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal327=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3163); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal327);

					char_literal328=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3165); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal328);

					char_literal329=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3167); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal329);

					char_literal330=(Token)match(input,RUC,FOLLOW_RUC_in_conditional3169); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal330);

					pushFollow(FOLLOW_number_in_conditional3171);
					number331=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number331.getTree());
					char_literal332=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3173); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal332);

					pushFollow(FOLLOW_regex_in_conditional3177);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:471:39: ( '|' f= regex )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==Pipe) ) {
						alt28=1;
					}
					switch (alt28) {
						case 1 :
							// PCRE.g:471:40: '|' f= regex
							{
							char_literal333=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3180); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal333);

							pushFollow(FOLLOW_regex_in_conditional3184);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal334=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3188); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal334);

					// AST REWRITE
					// elements: t, number, f
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 471:71: -> ^( SPECIFIC_GROUP_RECURSION_CONDITION number ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:471:74: ^( SPECIFIC_GROUP_RECURSION_CONDITION number ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SPECIFIC_GROUP_RECURSION_CONDITION, "SPECIFIC_GROUP_RECURSION_CONDITION"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						// PCRE.g:471:118: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:471:128: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:471:134: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:472:4: '(' '?' '(' 'R' ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal335=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3229); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal335);

					char_literal336=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3231); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal336);

					char_literal337=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3233); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal337);

					char_literal338=(Token)match(input,RUC,FOLLOW_RUC_in_conditional3235); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal338);

					char_literal339=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3237); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal339);

					pushFollow(FOLLOW_regex_in_conditional3241);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:472:32: ( '|' f= regex )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==Pipe) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// PCRE.g:472:33: '|' f= regex
							{
							char_literal340=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3244); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal340);

							pushFollow(FOLLOW_regex_in_conditional3248);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal341=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3252); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal341);

					// AST REWRITE
					// elements: t, f
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 472:71: -> ^( OVERALL_RECURSION_CONDITION ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:472:74: ^( OVERALL_RECURSION_CONDITION ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OVERALL_RECURSION_CONDITION, "OVERALL_RECURSION_CONDITION"), root_1);
						// PCRE.g:472:104: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:472:114: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:472:120: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// PCRE.g:473:4: '(' '?' '(' 'R' '&' name ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal342=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3298); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal342);

					char_literal343=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3300); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal343);

					char_literal344=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3302); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal344);

					char_literal345=(Token)match(input,RUC,FOLLOW_RUC_in_conditional3304); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal345);

					char_literal346=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_conditional3306); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Ampersand.add(char_literal346);

					pushFollow(FOLLOW_name_in_conditional3308);
					name347=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name347.getTree());
					char_literal348=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3310); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal348);

					pushFollow(FOLLOW_regex_in_conditional3314);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:473:41: ( '|' f= regex )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==Pipe) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// PCRE.g:473:42: '|' f= regex
							{
							char_literal349=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3317); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal349);

							pushFollow(FOLLOW_regex_in_conditional3321);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal350=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3325); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal350);

					// AST REWRITE
					// elements: name, f, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 473:71: -> ^( SPECIFIC_RECURSION_CONDITION name ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:473:74: ^( SPECIFIC_RECURSION_CONDITION name ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SPECIFIC_RECURSION_CONDITION, "SPECIFIC_RECURSION_CONDITION"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// PCRE.g:473:110: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:473:120: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:473:126: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// PCRE.g:474:4: '(' '?' '(' 'D' 'E' 'F' 'I' 'N' 'E' ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal351=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3364); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal351);

					char_literal352=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3366); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal352);

					char_literal353=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3368); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal353);

					char_literal354=(Token)match(input,DUC,FOLLOW_DUC_in_conditional3370); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DUC.add(char_literal354);

					char_literal355=(Token)match(input,EUC,FOLLOW_EUC_in_conditional3372); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal355);

					char_literal356=(Token)match(input,FUC,FOLLOW_FUC_in_conditional3374); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal356);

					char_literal357=(Token)match(input,IUC,FOLLOW_IUC_in_conditional3376); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IUC.add(char_literal357);

					char_literal358=(Token)match(input,NUC,FOLLOW_NUC_in_conditional3378); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal358);

					char_literal359=(Token)match(input,EUC,FOLLOW_EUC_in_conditional3380); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal359);

					char_literal360=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3382); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal360);

					pushFollow(FOLLOW_regex_in_conditional3386);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:474:52: ( '|' f= regex )?
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==Pipe) ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// PCRE.g:474:53: '|' f= regex
							{
							char_literal361=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3389); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal361);

							pushFollow(FOLLOW_regex_in_conditional3393);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal362=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3397); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal362);

					// AST REWRITE
					// elements: t, f
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 474:71: -> ^( DEFINE ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:474:74: ^( DEFINE ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEFINE, "DEFINE"), root_1);
						// PCRE.g:474:83: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:474:93: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:474:99: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// PCRE.g:475:4: '(' '?' '(' 'a' 's' 's' 'e' 'r' 't' ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal363=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3423); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal363);

					char_literal364=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3425); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal364);

					char_literal365=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3427); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal365);

					char_literal366=(Token)match(input,ALC,FOLLOW_ALC_in_conditional3429); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ALC.add(char_literal366);

					char_literal367=(Token)match(input,SLC,FOLLOW_SLC_in_conditional3431); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SLC.add(char_literal367);

					char_literal368=(Token)match(input,SLC,FOLLOW_SLC_in_conditional3433); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SLC.add(char_literal368);

					char_literal369=(Token)match(input,ELC,FOLLOW_ELC_in_conditional3435); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELC.add(char_literal369);

					char_literal370=(Token)match(input,RLC,FOLLOW_RLC_in_conditional3437); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RLC.add(char_literal370);

					char_literal371=(Token)match(input,TLC,FOLLOW_TLC_in_conditional3439); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TLC.add(char_literal371);

					char_literal372=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3441); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal372);

					pushFollow(FOLLOW_regex_in_conditional3445);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:475:52: ( '|' f= regex )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==Pipe) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// PCRE.g:475:53: '|' f= regex
							{
							char_literal373=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3448); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal373);

							pushFollow(FOLLOW_regex_in_conditional3452);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal374=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3456); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal374);

					// AST REWRITE
					// elements: f, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 475:71: -> ^( ASSERT ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:475:74: ^( ASSERT ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSERT, "ASSERT"), root_1);
						// PCRE.g:475:83: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:475:93: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:475:99: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 11 :
					// PCRE.g:476:4: '(' '?' '(' name ')' t= regex ( '|' f= regex )? ')'
					{
					char_literal375=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3482); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal375);

					char_literal376=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_conditional3484); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal376);

					char_literal377=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_conditional3486); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal377);

					pushFollow(FOLLOW_name_in_conditional3488);
					name378=name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_name.add(name378.getTree());
					char_literal379=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3490); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal379);

					pushFollow(FOLLOW_regex_in_conditional3494);
					t=regex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_regex.add(t.getTree());
					// PCRE.g:476:33: ( '|' f= regex )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==Pipe) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// PCRE.g:476:34: '|' f= regex
							{
							char_literal380=(Token)match(input,Pipe,FOLLOW_Pipe_in_conditional3497); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Pipe.add(char_literal380);

							pushFollow(FOLLOW_regex_in_conditional3501);
							f=regex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_regex.add(f.getTree());
							}
							break;

					}

					char_literal381=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_conditional3505); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal381);

					// AST REWRITE
					// elements: f, name, t
					// token labels: 
					// rule labels: t, f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 476:71: -> ^( NAMED_REFERENCE_CONDITION name ^( YES $t) ^( NO ( $f)? ) )
					{
						// PCRE.g:476:74: ^( NAMED_REFERENCE_CONDITION name ^( YES $t) ^( NO ( $f)? ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED_REFERENCE_CONDITION, "NAMED_REFERENCE_CONDITION"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// PCRE.g:476:107: ^( YES $t)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(YES, "YES"), root_2);
						adaptor.addChild(root_2, stream_t.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// PCRE.g:476:117: ^( NO ( $f)? )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NO, "NO"), root_2);
						// PCRE.g:476:123: ( $f)?
						if ( stream_f.hasNext() ) {
							adaptor.addChild(root_2, stream_f.nextTree());
						}
						stream_f.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 20, conditional_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "conditional"


	public static class backtrack_control_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "backtrack_control"
	// PCRE.g:500:1: backtrack_control : ( '(' '*' 'A' 'C' 'C' 'E' 'P' 'T' ')' -> BACKTACK_CONTROL_ACCEPT | '(' '*' 'F' ( 'A' 'I' 'L' )? ')' -> BACKTACK_CONTROL_FAIL | '(' '*' ( 'M' 'A' 'R' 'K' )? ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_MARK_NAME | '(' '*' 'C' 'O' 'M' 'M' 'I' 'T' ')' -> BACKTACK_CONTROL_COMMIT | '(' '*' 'P' 'R' 'U' 'N' 'E' ')' -> BACKTACK_CONTROL_PRUNE | '(' '*' 'P' 'R' 'U' 'N' 'E' ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_PRUNE_NAME | '(' '*' 'S' 'K' 'I' 'P' ')' -> BACKTACK_CONTROL_SKIP | '(' '*' 'S' 'K' 'I' 'P' ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_SKIP_NAME | '(' '*' 'T' 'H' 'E' 'N' ')' -> BACKTACK_CONTROL_THEN | '(' '*' 'T' 'H' 'E' 'N' ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_THEN_NAME );
	public final PCREParser.backtrack_control_return backtrack_control() throws RecognitionException {
		PCREParser.backtrack_control_return retval = new PCREParser.backtrack_control_return();
		retval.start = input.LT(1);
		int backtrack_control_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal382=null;
		Token char_literal383=null;
		Token char_literal384=null;
		Token char_literal385=null;
		Token char_literal386=null;
		Token char_literal387=null;
		Token char_literal388=null;
		Token char_literal389=null;
		Token char_literal390=null;
		Token char_literal391=null;
		Token char_literal392=null;
		Token char_literal393=null;
		Token char_literal394=null;
		Token char_literal395=null;
		Token char_literal396=null;
		Token char_literal397=null;
		Token char_literal398=null;
		Token char_literal399=null;
		Token char_literal400=null;
		Token char_literal401=null;
		Token char_literal402=null;
		Token char_literal403=null;
		Token char_literal404=null;
		Token char_literal405=null;
		Token char_literal406=null;
		Token char_literal407=null;
		Token char_literal408=null;
		Token char_literal409=null;
		Token char_literal410=null;
		Token char_literal411=null;
		Token char_literal412=null;
		Token char_literal413=null;
		Token char_literal414=null;
		Token char_literal415=null;
		Token char_literal416=null;
		Token char_literal417=null;
		Token char_literal418=null;
		Token char_literal419=null;
		Token char_literal420=null;
		Token char_literal421=null;
		Token char_literal422=null;
		Token char_literal423=null;
		Token char_literal424=null;
		Token char_literal425=null;
		Token char_literal426=null;
		Token char_literal427=null;
		Token char_literal428=null;
		Token char_literal429=null;
		Token char_literal430=null;
		Token char_literal431=null;
		Token char_literal432=null;
		Token char_literal433=null;
		Token char_literal434=null;
		Token char_literal435=null;
		Token char_literal436=null;
		Token char_literal437=null;
		Token char_literal438=null;
		Token char_literal439=null;
		Token char_literal440=null;
		Token char_literal441=null;
		Token char_literal442=null;
		Token char_literal443=null;
		Token char_literal444=null;
		Token char_literal445=null;
		Token char_literal446=null;
		Token char_literal447=null;
		Token char_literal448=null;
		Token char_literal449=null;
		Token char_literal450=null;
		Token char_literal451=null;
		Token char_literal452=null;
		Token char_literal453=null;
		Token char_literal454=null;
		Token char_literal455=null;
		Token char_literal456=null;
		Token char_literal457=null;
		Token char_literal458=null;
		Token char_literal459=null;
		Token char_literal460=null;
		Token char_literal461=null;
		Token char_literal462=null;
		Token char_literal463=null;
		Token char_literal464=null;
		Token char_literal465=null;
		Token char_literal466=null;
		Token char_literal467=null;
		Token char_literal468=null;
		Token char_literal469=null;
		Token char_literal470=null;
		Token char_literal471=null;
		Token char_literal472=null;
		Token char_literal473=null;
		Token char_literal474=null;
		Token char_literal475=null;
		Token char_literal476=null;
		Token char_literal477=null;

		CommonTree char_literal382_tree=null;
		CommonTree char_literal383_tree=null;
		CommonTree char_literal384_tree=null;
		CommonTree char_literal385_tree=null;
		CommonTree char_literal386_tree=null;
		CommonTree char_literal387_tree=null;
		CommonTree char_literal388_tree=null;
		CommonTree char_literal389_tree=null;
		CommonTree char_literal390_tree=null;
		CommonTree char_literal391_tree=null;
		CommonTree char_literal392_tree=null;
		CommonTree char_literal393_tree=null;
		CommonTree char_literal394_tree=null;
		CommonTree char_literal395_tree=null;
		CommonTree char_literal396_tree=null;
		CommonTree char_literal397_tree=null;
		CommonTree char_literal398_tree=null;
		CommonTree char_literal399_tree=null;
		CommonTree char_literal400_tree=null;
		CommonTree char_literal401_tree=null;
		CommonTree char_literal402_tree=null;
		CommonTree char_literal403_tree=null;
		CommonTree char_literal404_tree=null;
		CommonTree char_literal405_tree=null;
		CommonTree char_literal406_tree=null;
		CommonTree char_literal407_tree=null;
		CommonTree char_literal408_tree=null;
		CommonTree char_literal409_tree=null;
		CommonTree char_literal410_tree=null;
		CommonTree char_literal411_tree=null;
		CommonTree char_literal412_tree=null;
		CommonTree char_literal413_tree=null;
		CommonTree char_literal414_tree=null;
		CommonTree char_literal415_tree=null;
		CommonTree char_literal416_tree=null;
		CommonTree char_literal417_tree=null;
		CommonTree char_literal418_tree=null;
		CommonTree char_literal419_tree=null;
		CommonTree char_literal420_tree=null;
		CommonTree char_literal421_tree=null;
		CommonTree char_literal422_tree=null;
		CommonTree char_literal423_tree=null;
		CommonTree char_literal424_tree=null;
		CommonTree char_literal425_tree=null;
		CommonTree char_literal426_tree=null;
		CommonTree char_literal427_tree=null;
		CommonTree char_literal428_tree=null;
		CommonTree char_literal429_tree=null;
		CommonTree char_literal430_tree=null;
		CommonTree char_literal431_tree=null;
		CommonTree char_literal432_tree=null;
		CommonTree char_literal433_tree=null;
		CommonTree char_literal434_tree=null;
		CommonTree char_literal435_tree=null;
		CommonTree char_literal436_tree=null;
		CommonTree char_literal437_tree=null;
		CommonTree char_literal438_tree=null;
		CommonTree char_literal439_tree=null;
		CommonTree char_literal440_tree=null;
		CommonTree char_literal441_tree=null;
		CommonTree char_literal442_tree=null;
		CommonTree char_literal443_tree=null;
		CommonTree char_literal444_tree=null;
		CommonTree char_literal445_tree=null;
		CommonTree char_literal446_tree=null;
		CommonTree char_literal447_tree=null;
		CommonTree char_literal448_tree=null;
		CommonTree char_literal449_tree=null;
		CommonTree char_literal450_tree=null;
		CommonTree char_literal451_tree=null;
		CommonTree char_literal452_tree=null;
		CommonTree char_literal453_tree=null;
		CommonTree char_literal454_tree=null;
		CommonTree char_literal455_tree=null;
		CommonTree char_literal456_tree=null;
		CommonTree char_literal457_tree=null;
		CommonTree char_literal458_tree=null;
		CommonTree char_literal459_tree=null;
		CommonTree char_literal460_tree=null;
		CommonTree char_literal461_tree=null;
		CommonTree char_literal462_tree=null;
		CommonTree char_literal463_tree=null;
		CommonTree char_literal464_tree=null;
		CommonTree char_literal465_tree=null;
		CommonTree char_literal466_tree=null;
		CommonTree char_literal467_tree=null;
		CommonTree char_literal468_tree=null;
		CommonTree char_literal469_tree=null;
		CommonTree char_literal470_tree=null;
		CommonTree char_literal471_tree=null;
		CommonTree char_literal472_tree=null;
		CommonTree char_literal473_tree=null;
		CommonTree char_literal474_tree=null;
		CommonTree char_literal475_tree=null;
		CommonTree char_literal476_tree=null;
		CommonTree char_literal477_tree=null;
		RewriteRuleTokenStream stream_SUC=new RewriteRuleTokenStream(adaptor,"token SUC");
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_RUC=new RewriteRuleTokenStream(adaptor,"token RUC");
		RewriteRuleTokenStream stream_UUC=new RewriteRuleTokenStream(adaptor,"token UUC");
		RewriteRuleTokenStream stream_TUC=new RewriteRuleTokenStream(adaptor,"token TUC");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_AUC=new RewriteRuleTokenStream(adaptor,"token AUC");
		RewriteRuleTokenStream stream_CUC=new RewriteRuleTokenStream(adaptor,"token CUC");
		RewriteRuleTokenStream stream_EUC=new RewriteRuleTokenStream(adaptor,"token EUC");
		RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
		RewriteRuleTokenStream stream_FUC=new RewriteRuleTokenStream(adaptor,"token FUC");
		RewriteRuleTokenStream stream_IUC=new RewriteRuleTokenStream(adaptor,"token IUC");
		RewriteRuleTokenStream stream_HUC=new RewriteRuleTokenStream(adaptor,"token HUC");
		RewriteRuleTokenStream stream_KUC=new RewriteRuleTokenStream(adaptor,"token KUC");
		RewriteRuleTokenStream stream_MUC=new RewriteRuleTokenStream(adaptor,"token MUC");
		RewriteRuleTokenStream stream_LUC=new RewriteRuleTokenStream(adaptor,"token LUC");
		RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
		RewriteRuleTokenStream stream_OUC=new RewriteRuleTokenStream(adaptor,"token OUC");
		RewriteRuleTokenStream stream_NUC=new RewriteRuleTokenStream(adaptor,"token NUC");
		RewriteRuleTokenStream stream_PUC=new RewriteRuleTokenStream(adaptor,"token PUC");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

			// PCRE.g:501:2: ( '(' '*' 'A' 'C' 'C' 'E' 'P' 'T' ')' -> BACKTACK_CONTROL_ACCEPT | '(' '*' 'F' ( 'A' 'I' 'L' )? ')' -> BACKTACK_CONTROL_FAIL | '(' '*' ( 'M' 'A' 'R' 'K' )? ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_MARK_NAME | '(' '*' 'C' 'O' 'M' 'M' 'I' 'T' ')' -> BACKTACK_CONTROL_COMMIT | '(' '*' 'P' 'R' 'U' 'N' 'E' ')' -> BACKTACK_CONTROL_PRUNE | '(' '*' 'P' 'R' 'U' 'N' 'E' ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_PRUNE_NAME | '(' '*' 'S' 'K' 'I' 'P' ')' -> BACKTACK_CONTROL_SKIP | '(' '*' 'S' 'K' 'I' 'P' ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_SKIP_NAME | '(' '*' 'T' 'H' 'E' 'N' ')' -> BACKTACK_CONTROL_THEN | '(' '*' 'T' 'H' 'E' 'N' ':' 'N' 'A' 'M' 'E' ')' -> BACKTACK_CONTROL_THEN_NAME )
			int alt37=10;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==OpenParen) ) {
				int LA37_1 = input.LA(2);
				if ( (LA37_1==Star) ) {
					switch ( input.LA(3) ) {
					case AUC:
						{
						alt37=1;
						}
						break;
					case FUC:
						{
						alt37=2;
						}
						break;
					case CUC:
						{
						alt37=4;
						}
						break;
					case PUC:
						{
						int LA37_6 = input.LA(4);
						if ( (LA37_6==RUC) ) {
							int LA37_10 = input.LA(5);
							if ( (LA37_10==UUC) ) {
								int LA37_13 = input.LA(6);
								if ( (LA37_13==NUC) ) {
									int LA37_16 = input.LA(7);
									if ( (LA37_16==EUC) ) {
										int LA37_19 = input.LA(8);
										if ( (LA37_19==CloseParen) ) {
											alt37=5;
										}
										else if ( (LA37_19==Colon) ) {
											alt37=6;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 37, 19, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 16, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 13, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 10, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case SUC:
						{
						int LA37_7 = input.LA(4);
						if ( (LA37_7==KUC) ) {
							int LA37_11 = input.LA(5);
							if ( (LA37_11==IUC) ) {
								int LA37_14 = input.LA(6);
								if ( (LA37_14==PUC) ) {
									int LA37_17 = input.LA(7);
									if ( (LA37_17==CloseParen) ) {
										alt37=7;
									}
									else if ( (LA37_17==Colon) ) {
										alt37=8;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 17, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 14, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 11, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case TUC:
						{
						int LA37_8 = input.LA(4);
						if ( (LA37_8==HUC) ) {
							int LA37_12 = input.LA(5);
							if ( (LA37_12==EUC) ) {
								int LA37_15 = input.LA(6);
								if ( (LA37_15==NUC) ) {
									int LA37_18 = input.LA(7);
									if ( (LA37_18==CloseParen) ) {
										alt37=9;
									}
									else if ( (LA37_18==Colon) ) {
										alt37=10;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 18, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 15, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 12, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case Colon:
					case MUC:
						{
						alt37=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 37, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// PCRE.g:501:4: '(' '*' 'A' 'C' 'C' 'E' 'P' 'T' ')'
					{
					char_literal382=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3580); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal382);

					char_literal383=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3582); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal383);

					char_literal384=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3584); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal384);

					char_literal385=(Token)match(input,CUC,FOLLOW_CUC_in_backtrack_control3586); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal385);

					char_literal386=(Token)match(input,CUC,FOLLOW_CUC_in_backtrack_control3588); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal386);

					char_literal387=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3590); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal387);

					char_literal388=(Token)match(input,PUC,FOLLOW_PUC_in_backtrack_control3592); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal388);

					char_literal389=(Token)match(input,TUC,FOLLOW_TUC_in_backtrack_control3594); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal389);

					char_literal390=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3596); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal390);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 501:56: -> BACKTACK_CONTROL_ACCEPT
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_ACCEPT, "BACKTACK_CONTROL_ACCEPT"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:502:4: '(' '*' 'F' ( 'A' 'I' 'L' )? ')'
					{
					char_literal391=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3621); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal391);

					char_literal392=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3623); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal392);

					char_literal393=(Token)match(input,FUC,FOLLOW_FUC_in_backtrack_control3625); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal393);

					// PCRE.g:502:16: ( 'A' 'I' 'L' )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==AUC) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// PCRE.g:502:17: 'A' 'I' 'L'
							{
							char_literal394=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3628); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_AUC.add(char_literal394);

							char_literal395=(Token)match(input,IUC,FOLLOW_IUC_in_backtrack_control3630); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_IUC.add(char_literal395);

							char_literal396=(Token)match(input,LUC,FOLLOW_LUC_in_backtrack_control3632); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LUC.add(char_literal396);

							}
							break;

					}

					char_literal397=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3636); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal397);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 502:56: -> BACKTACK_CONTROL_FAIL
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_FAIL, "BACKTACK_CONTROL_FAIL"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:503:4: '(' '*' ( 'M' 'A' 'R' 'K' )? ':' 'N' 'A' 'M' 'E' ')'
					{
					char_literal398=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3666); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal398);

					char_literal399=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3668); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal399);

					// PCRE.g:503:12: ( 'M' 'A' 'R' 'K' )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==MUC) ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// PCRE.g:503:13: 'M' 'A' 'R' 'K'
							{
							char_literal400=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3671); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_MUC.add(char_literal400);

							char_literal401=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3673); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_AUC.add(char_literal401);

							char_literal402=(Token)match(input,RUC,FOLLOW_RUC_in_backtrack_control3675); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RUC.add(char_literal402);

							char_literal403=(Token)match(input,KUC,FOLLOW_KUC_in_backtrack_control3677); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KUC.add(char_literal403);

							}
							break;

					}

					char_literal404=(Token)match(input,Colon,FOLLOW_Colon_in_backtrack_control3681); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Colon.add(char_literal404);

					char_literal405=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3683); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal405);

					char_literal406=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3685); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal406);

					char_literal407=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3687); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MUC.add(char_literal407);

					char_literal408=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3689); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal408);

					char_literal409=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3691); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal409);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 503:56: -> BACKTACK_CONTROL_MARK_NAME
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_MARK_NAME, "BACKTACK_CONTROL_MARK_NAME"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:504:4: '(' '*' 'C' 'O' 'M' 'M' 'I' 'T' ')'
					{
					char_literal410=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3701); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal410);

					char_literal411=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3703); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal411);

					char_literal412=(Token)match(input,CUC,FOLLOW_CUC_in_backtrack_control3705); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal412);

					char_literal413=(Token)match(input,OUC,FOLLOW_OUC_in_backtrack_control3707); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OUC.add(char_literal413);

					char_literal414=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3709); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MUC.add(char_literal414);

					char_literal415=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3711); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MUC.add(char_literal415);

					char_literal416=(Token)match(input,IUC,FOLLOW_IUC_in_backtrack_control3713); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IUC.add(char_literal416);

					char_literal417=(Token)match(input,TUC,FOLLOW_TUC_in_backtrack_control3715); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal417);

					char_literal418=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3717); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal418);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 504:56: -> BACKTACK_CONTROL_COMMIT
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_COMMIT, "BACKTACK_CONTROL_COMMIT"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:505:4: '(' '*' 'P' 'R' 'U' 'N' 'E' ')'
					{
					char_literal419=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3742); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal419);

					char_literal420=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3744); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal420);

					char_literal421=(Token)match(input,PUC,FOLLOW_PUC_in_backtrack_control3746); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal421);

					char_literal422=(Token)match(input,RUC,FOLLOW_RUC_in_backtrack_control3748); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal422);

					char_literal423=(Token)match(input,UUC,FOLLOW_UUC_in_backtrack_control3750); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal423);

					char_literal424=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3752); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal424);

					char_literal425=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3754); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal425);

					char_literal426=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3756); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal426);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 505:56: -> BACKTACK_CONTROL_PRUNE
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_PRUNE, "BACKTACK_CONTROL_PRUNE"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:506:4: '(' '*' 'P' 'R' 'U' 'N' 'E' ':' 'N' 'A' 'M' 'E' ')'
					{
					char_literal427=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3785); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal427);

					char_literal428=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3787); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal428);

					char_literal429=(Token)match(input,PUC,FOLLOW_PUC_in_backtrack_control3789); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal429);

					char_literal430=(Token)match(input,RUC,FOLLOW_RUC_in_backtrack_control3791); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal430);

					char_literal431=(Token)match(input,UUC,FOLLOW_UUC_in_backtrack_control3793); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal431);

					char_literal432=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3795); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal432);

					char_literal433=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3797); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal433);

					char_literal434=(Token)match(input,Colon,FOLLOW_Colon_in_backtrack_control3799); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Colon.add(char_literal434);

					char_literal435=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3801); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal435);

					char_literal436=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3803); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal436);

					char_literal437=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3805); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MUC.add(char_literal437);

					char_literal438=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3807); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal438);

					char_literal439=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3809); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal439);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 506:56: -> BACKTACK_CONTROL_PRUNE_NAME
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_PRUNE_NAME, "BACKTACK_CONTROL_PRUNE_NAME"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:507:4: '(' '*' 'S' 'K' 'I' 'P' ')'
					{
					char_literal440=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3818); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal440);

					char_literal441=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3820); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal441);

					char_literal442=(Token)match(input,SUC,FOLLOW_SUC_in_backtrack_control3822); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SUC.add(char_literal442);

					char_literal443=(Token)match(input,KUC,FOLLOW_KUC_in_backtrack_control3824); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KUC.add(char_literal443);

					char_literal444=(Token)match(input,IUC,FOLLOW_IUC_in_backtrack_control3826); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IUC.add(char_literal444);

					char_literal445=(Token)match(input,PUC,FOLLOW_PUC_in_backtrack_control3828); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal445);

					char_literal446=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3830); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal446);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 507:56: -> BACKTACK_CONTROL_SKIP
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_SKIP, "BACKTACK_CONTROL_SKIP"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// PCRE.g:508:4: '(' '*' 'S' 'K' 'I' 'P' ':' 'N' 'A' 'M' 'E' ')'
					{
					char_literal447=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3863); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal447);

					char_literal448=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3865); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal448);

					char_literal449=(Token)match(input,SUC,FOLLOW_SUC_in_backtrack_control3867); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SUC.add(char_literal449);

					char_literal450=(Token)match(input,KUC,FOLLOW_KUC_in_backtrack_control3869); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KUC.add(char_literal450);

					char_literal451=(Token)match(input,IUC,FOLLOW_IUC_in_backtrack_control3871); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IUC.add(char_literal451);

					char_literal452=(Token)match(input,PUC,FOLLOW_PUC_in_backtrack_control3873); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PUC.add(char_literal452);

					char_literal453=(Token)match(input,Colon,FOLLOW_Colon_in_backtrack_control3875); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Colon.add(char_literal453);

					char_literal454=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3877); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal454);

					char_literal455=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3879); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal455);

					char_literal456=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3881); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MUC.add(char_literal456);

					char_literal457=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3883); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal457);

					char_literal458=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3885); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal458);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 508:56: -> BACKTACK_CONTROL_SKIP_NAME
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_SKIP_NAME, "BACKTACK_CONTROL_SKIP_NAME"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// PCRE.g:509:4: '(' '*' 'T' 'H' 'E' 'N' ')'
					{
					char_literal459=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3898); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal459);

					char_literal460=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3900); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal460);

					char_literal461=(Token)match(input,TUC,FOLLOW_TUC_in_backtrack_control3902); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal461);

					char_literal462=(Token)match(input,HUC,FOLLOW_HUC_in_backtrack_control3904); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_HUC.add(char_literal462);

					char_literal463=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3906); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal463);

					char_literal464=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3908); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal464);

					char_literal465=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3910); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal465);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 509:56: -> BACKTACK_CONTROL_THEN
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_THEN, "BACKTACK_CONTROL_THEN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// PCRE.g:510:4: '(' '*' 'T' 'H' 'E' 'N' ':' 'N' 'A' 'M' 'E' ')'
					{
					char_literal466=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_backtrack_control3943); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal466);

					char_literal467=(Token)match(input,Star,FOLLOW_Star_in_backtrack_control3945); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal467);

					char_literal468=(Token)match(input,TUC,FOLLOW_TUC_in_backtrack_control3947); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TUC.add(char_literal468);

					char_literal469=(Token)match(input,HUC,FOLLOW_HUC_in_backtrack_control3949); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_HUC.add(char_literal469);

					char_literal470=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3951); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal470);

					char_literal471=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3953); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal471);

					char_literal472=(Token)match(input,Colon,FOLLOW_Colon_in_backtrack_control3955); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Colon.add(char_literal472);

					char_literal473=(Token)match(input,NUC,FOLLOW_NUC_in_backtrack_control3957); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal473);

					char_literal474=(Token)match(input,AUC,FOLLOW_AUC_in_backtrack_control3959); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal474);

					char_literal475=(Token)match(input,MUC,FOLLOW_MUC_in_backtrack_control3961); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MUC.add(char_literal475);

					char_literal476=(Token)match(input,EUC,FOLLOW_EUC_in_backtrack_control3963); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal476);

					char_literal477=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_backtrack_control3965); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal477);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 510:56: -> BACKTACK_CONTROL_THEN_NAME
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(BACKTACK_CONTROL_THEN_NAME, "BACKTACK_CONTROL_THEN_NAME"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 21, backtrack_control_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "backtrack_control"


	public static class newline_convention_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "newline_convention"
	// PCRE.g:531:1: newline_convention : ( '(' '*' 'C' 'R' ')' -> NEWLINE_CONVENTION_CR | '(' '*' 'L' 'F' ')' -> NEWLINE_CONVENTION_LF | '(' '*' 'C' 'R' 'L' 'F' ')' -> NEWLINE_CONVENTION_CRLF | '(' '*' 'A' 'N' 'Y' 'C' 'R' 'L' 'F' ')' -> NEWLINE_CONVENTION_ANYCRLF | '(' '*' 'A' 'N' 'Y' ')' -> NEWLINE_CONVENTION_ANY | '(' '*' 'B' 'S' 'R' '_' 'A' 'N' 'Y' 'C' 'R' 'L' 'F' ')' -> NEWLINE_CONVENTION_BSR_ANYCRLF | '(' '*' 'B' 'S' 'R' '_' 'U' 'N' 'I' 'C' 'O' 'D' 'E' ')' -> NEWLINE_CONVENTION_BSR_UNICODE );
	public final PCREParser.newline_convention_return newline_convention() throws RecognitionException {
		PCREParser.newline_convention_return retval = new PCREParser.newline_convention_return();
		retval.start = input.LT(1);
		int newline_convention_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal478=null;
		Token char_literal479=null;
		Token char_literal480=null;
		Token char_literal481=null;
		Token char_literal482=null;
		Token char_literal483=null;
		Token char_literal484=null;
		Token char_literal485=null;
		Token char_literal486=null;
		Token char_literal487=null;
		Token char_literal488=null;
		Token char_literal489=null;
		Token char_literal490=null;
		Token char_literal491=null;
		Token char_literal492=null;
		Token char_literal493=null;
		Token char_literal494=null;
		Token char_literal495=null;
		Token char_literal496=null;
		Token char_literal497=null;
		Token char_literal498=null;
		Token char_literal499=null;
		Token char_literal500=null;
		Token char_literal501=null;
		Token char_literal502=null;
		Token char_literal503=null;
		Token char_literal504=null;
		Token char_literal505=null;
		Token char_literal506=null;
		Token char_literal507=null;
		Token char_literal508=null;
		Token char_literal509=null;
		Token char_literal510=null;
		Token char_literal511=null;
		Token char_literal512=null;
		Token char_literal513=null;
		Token char_literal514=null;
		Token char_literal515=null;
		Token char_literal516=null;
		Token char_literal517=null;
		Token char_literal518=null;
		Token char_literal519=null;
		Token char_literal520=null;
		Token char_literal521=null;
		Token char_literal522=null;
		Token char_literal523=null;
		Token char_literal524=null;
		Token char_literal525=null;
		Token char_literal526=null;
		Token char_literal527=null;
		Token char_literal528=null;
		Token char_literal529=null;
		Token char_literal530=null;
		Token char_literal531=null;
		Token char_literal532=null;
		Token char_literal533=null;
		Token char_literal534=null;
		Token char_literal535=null;
		Token char_literal536=null;
		Token char_literal537=null;
		Token char_literal538=null;

		CommonTree char_literal478_tree=null;
		CommonTree char_literal479_tree=null;
		CommonTree char_literal480_tree=null;
		CommonTree char_literal481_tree=null;
		CommonTree char_literal482_tree=null;
		CommonTree char_literal483_tree=null;
		CommonTree char_literal484_tree=null;
		CommonTree char_literal485_tree=null;
		CommonTree char_literal486_tree=null;
		CommonTree char_literal487_tree=null;
		CommonTree char_literal488_tree=null;
		CommonTree char_literal489_tree=null;
		CommonTree char_literal490_tree=null;
		CommonTree char_literal491_tree=null;
		CommonTree char_literal492_tree=null;
		CommonTree char_literal493_tree=null;
		CommonTree char_literal494_tree=null;
		CommonTree char_literal495_tree=null;
		CommonTree char_literal496_tree=null;
		CommonTree char_literal497_tree=null;
		CommonTree char_literal498_tree=null;
		CommonTree char_literal499_tree=null;
		CommonTree char_literal500_tree=null;
		CommonTree char_literal501_tree=null;
		CommonTree char_literal502_tree=null;
		CommonTree char_literal503_tree=null;
		CommonTree char_literal504_tree=null;
		CommonTree char_literal505_tree=null;
		CommonTree char_literal506_tree=null;
		CommonTree char_literal507_tree=null;
		CommonTree char_literal508_tree=null;
		CommonTree char_literal509_tree=null;
		CommonTree char_literal510_tree=null;
		CommonTree char_literal511_tree=null;
		CommonTree char_literal512_tree=null;
		CommonTree char_literal513_tree=null;
		CommonTree char_literal514_tree=null;
		CommonTree char_literal515_tree=null;
		CommonTree char_literal516_tree=null;
		CommonTree char_literal517_tree=null;
		CommonTree char_literal518_tree=null;
		CommonTree char_literal519_tree=null;
		CommonTree char_literal520_tree=null;
		CommonTree char_literal521_tree=null;
		CommonTree char_literal522_tree=null;
		CommonTree char_literal523_tree=null;
		CommonTree char_literal524_tree=null;
		CommonTree char_literal525_tree=null;
		CommonTree char_literal526_tree=null;
		CommonTree char_literal527_tree=null;
		CommonTree char_literal528_tree=null;
		CommonTree char_literal529_tree=null;
		CommonTree char_literal530_tree=null;
		CommonTree char_literal531_tree=null;
		CommonTree char_literal532_tree=null;
		CommonTree char_literal533_tree=null;
		CommonTree char_literal534_tree=null;
		CommonTree char_literal535_tree=null;
		CommonTree char_literal536_tree=null;
		CommonTree char_literal537_tree=null;
		CommonTree char_literal538_tree=null;
		RewriteRuleTokenStream stream_SUC=new RewriteRuleTokenStream(adaptor,"token SUC");
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_RUC=new RewriteRuleTokenStream(adaptor,"token RUC");
		RewriteRuleTokenStream stream_UUC=new RewriteRuleTokenStream(adaptor,"token UUC");
		RewriteRuleTokenStream stream_YUC=new RewriteRuleTokenStream(adaptor,"token YUC");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_AUC=new RewriteRuleTokenStream(adaptor,"token AUC");
		RewriteRuleTokenStream stream_CUC=new RewriteRuleTokenStream(adaptor,"token CUC");
		RewriteRuleTokenStream stream_BUC=new RewriteRuleTokenStream(adaptor,"token BUC");
		RewriteRuleTokenStream stream_EUC=new RewriteRuleTokenStream(adaptor,"token EUC");
		RewriteRuleTokenStream stream_DUC=new RewriteRuleTokenStream(adaptor,"token DUC");
		RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
		RewriteRuleTokenStream stream_FUC=new RewriteRuleTokenStream(adaptor,"token FUC");
		RewriteRuleTokenStream stream_IUC=new RewriteRuleTokenStream(adaptor,"token IUC");
		RewriteRuleTokenStream stream_Underscore=new RewriteRuleTokenStream(adaptor,"token Underscore");
		RewriteRuleTokenStream stream_LUC=new RewriteRuleTokenStream(adaptor,"token LUC");
		RewriteRuleTokenStream stream_OUC=new RewriteRuleTokenStream(adaptor,"token OUC");
		RewriteRuleTokenStream stream_NUC=new RewriteRuleTokenStream(adaptor,"token NUC");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

			// PCRE.g:532:2: ( '(' '*' 'C' 'R' ')' -> NEWLINE_CONVENTION_CR | '(' '*' 'L' 'F' ')' -> NEWLINE_CONVENTION_LF | '(' '*' 'C' 'R' 'L' 'F' ')' -> NEWLINE_CONVENTION_CRLF | '(' '*' 'A' 'N' 'Y' 'C' 'R' 'L' 'F' ')' -> NEWLINE_CONVENTION_ANYCRLF | '(' '*' 'A' 'N' 'Y' ')' -> NEWLINE_CONVENTION_ANY | '(' '*' 'B' 'S' 'R' '_' 'A' 'N' 'Y' 'C' 'R' 'L' 'F' ')' -> NEWLINE_CONVENTION_BSR_ANYCRLF | '(' '*' 'B' 'S' 'R' '_' 'U' 'N' 'I' 'C' 'O' 'D' 'E' ')' -> NEWLINE_CONVENTION_BSR_UNICODE )
			int alt38=7;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==OpenParen) ) {
				int LA38_1 = input.LA(2);
				if ( (LA38_1==Star) ) {
					switch ( input.LA(3) ) {
					case CUC:
						{
						int LA38_3 = input.LA(4);
						if ( (LA38_3==RUC) ) {
							int LA38_7 = input.LA(5);
							if ( (LA38_7==CloseParen) ) {
								alt38=1;
							}
							else if ( (LA38_7==LUC) ) {
								alt38=3;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 38, 7, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 38, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case LUC:
						{
						alt38=2;
						}
						break;
					case AUC:
						{
						int LA38_5 = input.LA(4);
						if ( (LA38_5==NUC) ) {
							int LA38_8 = input.LA(5);
							if ( (LA38_8==YUC) ) {
								int LA38_12 = input.LA(6);
								if ( (LA38_12==CUC) ) {
									alt38=4;
								}
								else if ( (LA38_12==CloseParen) ) {
									alt38=5;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 38, 12, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 38, 8, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 38, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case BUC:
						{
						int LA38_6 = input.LA(4);
						if ( (LA38_6==SUC) ) {
							int LA38_9 = input.LA(5);
							if ( (LA38_9==RUC) ) {
								int LA38_13 = input.LA(6);
								if ( (LA38_13==Underscore) ) {
									int LA38_16 = input.LA(7);
									if ( (LA38_16==AUC) ) {
										alt38=6;
									}
									else if ( (LA38_16==UUC) ) {
										alt38=7;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 38, 16, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 38, 13, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 38, 9, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 38, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 38, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// PCRE.g:532:4: '(' '*' 'C' 'R' ')'
					{
					char_literal478=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4002); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal478);

					char_literal479=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4004); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal479);

					char_literal480=(Token)match(input,CUC,FOLLOW_CUC_in_newline_convention4006); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal480);

					char_literal481=(Token)match(input,RUC,FOLLOW_RUC_in_newline_convention4008); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal481);

					char_literal482=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4010); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal482);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 532:60: -> NEWLINE_CONVENTION_CR
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_CR, "NEWLINE_CONVENTION_CR"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:533:4: '(' '*' 'L' 'F' ')'
					{
					char_literal483=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4055); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal483);

					char_literal484=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4057); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal484);

					char_literal485=(Token)match(input,LUC,FOLLOW_LUC_in_newline_convention4059); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LUC.add(char_literal485);

					char_literal486=(Token)match(input,FUC,FOLLOW_FUC_in_newline_convention4061); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal486);

					char_literal487=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4063); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal487);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 533:60: -> NEWLINE_CONVENTION_LF
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_LF, "NEWLINE_CONVENTION_LF"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:534:4: '(' '*' 'C' 'R' 'L' 'F' ')'
					{
					char_literal488=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4108); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal488);

					char_literal489=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4110); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal489);

					char_literal490=(Token)match(input,CUC,FOLLOW_CUC_in_newline_convention4112); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal490);

					char_literal491=(Token)match(input,RUC,FOLLOW_RUC_in_newline_convention4114); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal491);

					char_literal492=(Token)match(input,LUC,FOLLOW_LUC_in_newline_convention4116); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LUC.add(char_literal492);

					char_literal493=(Token)match(input,FUC,FOLLOW_FUC_in_newline_convention4118); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal493);

					char_literal494=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4120); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal494);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 534:60: -> NEWLINE_CONVENTION_CRLF
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_CRLF, "NEWLINE_CONVENTION_CRLF"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:535:4: '(' '*' 'A' 'N' 'Y' 'C' 'R' 'L' 'F' ')'
					{
					char_literal495=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4157); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal495);

					char_literal496=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4159); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal496);

					char_literal497=(Token)match(input,AUC,FOLLOW_AUC_in_newline_convention4161); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal497);

					char_literal498=(Token)match(input,NUC,FOLLOW_NUC_in_newline_convention4163); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal498);

					char_literal499=(Token)match(input,YUC,FOLLOW_YUC_in_newline_convention4165); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_YUC.add(char_literal499);

					char_literal500=(Token)match(input,CUC,FOLLOW_CUC_in_newline_convention4167); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal500);

					char_literal501=(Token)match(input,RUC,FOLLOW_RUC_in_newline_convention4169); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal501);

					char_literal502=(Token)match(input,LUC,FOLLOW_LUC_in_newline_convention4171); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LUC.add(char_literal502);

					char_literal503=(Token)match(input,FUC,FOLLOW_FUC_in_newline_convention4173); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal503);

					char_literal504=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4175); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal504);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 535:60: -> NEWLINE_CONVENTION_ANYCRLF
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_ANYCRLF, "NEWLINE_CONVENTION_ANYCRLF"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:536:4: '(' '*' 'A' 'N' 'Y' ')'
					{
					char_literal505=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4200); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal505);

					char_literal506=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4202); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal506);

					char_literal507=(Token)match(input,AUC,FOLLOW_AUC_in_newline_convention4204); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal507);

					char_literal508=(Token)match(input,NUC,FOLLOW_NUC_in_newline_convention4206); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal508);

					char_literal509=(Token)match(input,YUC,FOLLOW_YUC_in_newline_convention4208); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_YUC.add(char_literal509);

					char_literal510=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4210); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal510);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 536:60: -> NEWLINE_CONVENTION_ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_ANY, "NEWLINE_CONVENTION_ANY"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:537:4: '(' '*' 'B' 'S' 'R' '_' 'A' 'N' 'Y' 'C' 'R' 'L' 'F' ')'
					{
					char_literal511=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4251); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal511);

					char_literal512=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4253); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal512);

					char_literal513=(Token)match(input,BUC,FOLLOW_BUC_in_newline_convention4255); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BUC.add(char_literal513);

					char_literal514=(Token)match(input,SUC,FOLLOW_SUC_in_newline_convention4257); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SUC.add(char_literal514);

					char_literal515=(Token)match(input,RUC,FOLLOW_RUC_in_newline_convention4259); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal515);

					char_literal516=(Token)match(input,Underscore,FOLLOW_Underscore_in_newline_convention4261); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Underscore.add(char_literal516);

					char_literal517=(Token)match(input,AUC,FOLLOW_AUC_in_newline_convention4263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AUC.add(char_literal517);

					char_literal518=(Token)match(input,NUC,FOLLOW_NUC_in_newline_convention4265); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal518);

					char_literal519=(Token)match(input,YUC,FOLLOW_YUC_in_newline_convention4267); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_YUC.add(char_literal519);

					char_literal520=(Token)match(input,CUC,FOLLOW_CUC_in_newline_convention4269); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal520);

					char_literal521=(Token)match(input,RUC,FOLLOW_RUC_in_newline_convention4271); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal521);

					char_literal522=(Token)match(input,LUC,FOLLOW_LUC_in_newline_convention4273); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LUC.add(char_literal522);

					char_literal523=(Token)match(input,FUC,FOLLOW_FUC_in_newline_convention4275); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUC.add(char_literal523);

					char_literal524=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4277); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal524);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 537:60: -> NEWLINE_CONVENTION_BSR_ANYCRLF
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_BSR_ANYCRLF, "NEWLINE_CONVENTION_BSR_ANYCRLF"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:538:4: '(' '*' 'B' 'S' 'R' '_' 'U' 'N' 'I' 'C' 'O' 'D' 'E' ')'
					{
					char_literal525=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_newline_convention4286); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal525);

					char_literal526=(Token)match(input,Star,FOLLOW_Star_in_newline_convention4288); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(char_literal526);

					char_literal527=(Token)match(input,BUC,FOLLOW_BUC_in_newline_convention4290); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BUC.add(char_literal527);

					char_literal528=(Token)match(input,SUC,FOLLOW_SUC_in_newline_convention4292); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SUC.add(char_literal528);

					char_literal529=(Token)match(input,RUC,FOLLOW_RUC_in_newline_convention4294); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RUC.add(char_literal529);

					char_literal530=(Token)match(input,Underscore,FOLLOW_Underscore_in_newline_convention4296); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Underscore.add(char_literal530);

					char_literal531=(Token)match(input,UUC,FOLLOW_UUC_in_newline_convention4298); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UUC.add(char_literal531);

					char_literal532=(Token)match(input,NUC,FOLLOW_NUC_in_newline_convention4300); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUC.add(char_literal532);

					char_literal533=(Token)match(input,IUC,FOLLOW_IUC_in_newline_convention4302); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IUC.add(char_literal533);

					char_literal534=(Token)match(input,CUC,FOLLOW_CUC_in_newline_convention4304); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal534);

					char_literal535=(Token)match(input,OUC,FOLLOW_OUC_in_newline_convention4306); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OUC.add(char_literal535);

					char_literal536=(Token)match(input,DUC,FOLLOW_DUC_in_newline_convention4308); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DUC.add(char_literal536);

					char_literal537=(Token)match(input,EUC,FOLLOW_EUC_in_newline_convention4310); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EUC.add(char_literal537);

					char_literal538=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_newline_convention4312); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal538);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 538:60: -> NEWLINE_CONVENTION_BSR_UNICODE
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NEWLINE_CONVENTION_BSR_UNICODE, "NEWLINE_CONVENTION_BSR_UNICODE"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 22, newline_convention_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "newline_convention"


	public static class callout_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "callout"
	// PCRE.g:545:1: callout : ( '(' '?' 'C' ')' -> ^( CALLOUT ) | '(' '?' 'C' number ')' -> ^( CALLOUT number ) );
	public final PCREParser.callout_return callout() throws RecognitionException {
		PCREParser.callout_return retval = new PCREParser.callout_return();
		retval.start = input.LT(1);
		int callout_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal539=null;
		Token char_literal540=null;
		Token char_literal541=null;
		Token char_literal542=null;
		Token char_literal543=null;
		Token char_literal544=null;
		Token char_literal545=null;
		Token char_literal547=null;
		ParserRuleReturnScope number546 =null;

		CommonTree char_literal539_tree=null;
		CommonTree char_literal540_tree=null;
		CommonTree char_literal541_tree=null;
		CommonTree char_literal542_tree=null;
		CommonTree char_literal543_tree=null;
		CommonTree char_literal544_tree=null;
		CommonTree char_literal545_tree=null;
		CommonTree char_literal547_tree=null;
		RewriteRuleTokenStream stream_CUC=new RewriteRuleTokenStream(adaptor,"token CUC");
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleSubtreeStream stream_number=new RewriteRuleSubtreeStream(adaptor,"rule number");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }

			// PCRE.g:546:2: ( '(' '?' 'C' ')' -> ^( CALLOUT ) | '(' '?' 'C' number ')' -> ^( CALLOUT number ) )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==OpenParen) ) {
				int LA39_1 = input.LA(2);
				if ( (LA39_1==QuestionMark) ) {
					int LA39_2 = input.LA(3);
					if ( (LA39_2==CUC) ) {
						int LA39_3 = input.LA(4);
						if ( (LA39_3==CloseParen) ) {
							alt39=1;
						}
						else if ( ((LA39_3 >= D0 && LA39_3 <= D9)) ) {
							alt39=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 39, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 39, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 39, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// PCRE.g:546:4: '(' '?' 'C' ')'
					{
					char_literal539=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_callout4331); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal539);

					char_literal540=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_callout4333); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal540);

					char_literal541=(Token)match(input,CUC,FOLLOW_CUC_in_callout4335); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal541);

					char_literal542=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_callout4337); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal542);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 546:27: -> ^( CALLOUT )
					{
						// PCRE.g:546:30: ^( CALLOUT )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALLOUT, "CALLOUT"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:547:4: '(' '?' 'C' number ')'
					{
					char_literal543=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_callout4355); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(char_literal543);

					char_literal544=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_callout4357); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(char_literal544);

					char_literal545=(Token)match(input,CUC,FOLLOW_CUC_in_callout4359); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CUC.add(char_literal545);

					pushFollow(FOLLOW_number_in_callout4361);
					number546=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_number.add(number546.getTree());
					char_literal547=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_callout4363); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(char_literal547);

					// AST REWRITE
					// elements: number
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 547:27: -> ^( CALLOUT number )
					{
						// PCRE.g:547:30: ^( CALLOUT number )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALLOUT, "CALLOUT"), root_1);
						adaptor.addChild(root_1, stream_number.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 23, callout_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "callout"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// PCRE.g:550:1: atom : ( subroutine_reference | shared_atom | literal | character_class | capture | non_capture | comment | option | look_around | backreference | conditional | backtrack_control | newline_convention | callout | Dot -> ANY | Caret -> START_OF_SUBJECT | StartOfSubject -> START_OF_SUBJECT | WordBoundary | NonWordBoundary | EndOfSubjectOrLine | EndOfSubjectOrLineEndOfSubject | EndOfSubject | PreviousMatchInSubject | ResetStartMatch | OneDataUnit | ExtendedUnicodeChar );
	public final PCREParser.atom_return atom() throws RecognitionException {
		PCREParser.atom_return retval = new PCREParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Dot562=null;
		Token Caret563=null;
		Token StartOfSubject564=null;
		Token WordBoundary565=null;
		Token NonWordBoundary566=null;
		Token EndOfSubjectOrLine567=null;
		Token EndOfSubjectOrLineEndOfSubject568=null;
		Token EndOfSubject569=null;
		Token PreviousMatchInSubject570=null;
		Token ResetStartMatch571=null;
		Token OneDataUnit572=null;
		Token ExtendedUnicodeChar573=null;
		ParserRuleReturnScope subroutine_reference548 =null;
		ParserRuleReturnScope shared_atom549 =null;
		ParserRuleReturnScope literal550 =null;
		ParserRuleReturnScope character_class551 =null;
		ParserRuleReturnScope capture552 =null;
		ParserRuleReturnScope non_capture553 =null;
		ParserRuleReturnScope comment554 =null;
		ParserRuleReturnScope option555 =null;
		ParserRuleReturnScope look_around556 =null;
		ParserRuleReturnScope backreference557 =null;
		ParserRuleReturnScope conditional558 =null;
		ParserRuleReturnScope backtrack_control559 =null;
		ParserRuleReturnScope newline_convention560 =null;
		ParserRuleReturnScope callout561 =null;

		CommonTree Dot562_tree=null;
		CommonTree Caret563_tree=null;
		CommonTree StartOfSubject564_tree=null;
		CommonTree WordBoundary565_tree=null;
		CommonTree NonWordBoundary566_tree=null;
		CommonTree EndOfSubjectOrLine567_tree=null;
		CommonTree EndOfSubjectOrLineEndOfSubject568_tree=null;
		CommonTree EndOfSubject569_tree=null;
		CommonTree PreviousMatchInSubject570_tree=null;
		CommonTree ResetStartMatch571_tree=null;
		CommonTree OneDataUnit572_tree=null;
		CommonTree ExtendedUnicodeChar573_tree=null;
		RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
		RewriteRuleTokenStream stream_StartOfSubject=new RewriteRuleTokenStream(adaptor,"token StartOfSubject");
		RewriteRuleTokenStream stream_Caret=new RewriteRuleTokenStream(adaptor,"token Caret");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }

			// PCRE.g:551:2: ( subroutine_reference | shared_atom | literal | character_class | capture | non_capture | comment | option | look_around | backreference | conditional | backtrack_control | newline_convention | callout | Dot -> ANY | Caret -> START_OF_SUBJECT | StartOfSubject -> START_OF_SUBJECT | WordBoundary | NonWordBoundary | EndOfSubjectOrLine | EndOfSubjectOrLineEndOfSubject | EndOfSubject | PreviousMatchInSubject | ResetStartMatch | OneDataUnit | ExtendedUnicodeChar )
			int alt40=26;
			switch ( input.LA(1) ) {
			case OpenParen:
				{
				switch ( input.LA(2) ) {
				case QuestionMark:
					{
					switch ( input.LA(3) ) {
					case Ampersand:
					case D0:
					case D1:
					case D2:
					case D3:
					case D4:
					case D5:
					case D6:
					case D7:
					case D8:
					case D9:
					case Plus:
					case RUC:
						{
						alt40=1;
						}
						break;
					case Hyphen:
						{
						int LA40_29 = input.LA(4);
						if ( ((LA40_29 >= D0 && LA40_29 <= D9)) ) {
							alt40=1;
						}
						else if ( (LA40_29==ILC||LA40_29==JUC||LA40_29==MLC||LA40_29==SLC||LA40_29==UUC||LA40_29==XLC) ) {
							alt40=8;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 29, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case PUC:
						{
						switch ( input.LA(4) ) {
						case GreaterThan:
							{
							alt40=1;
							}
							break;
						case Equals:
							{
							alt40=10;
							}
							break;
						case LessThan:
							{
							alt40=5;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 30, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case Colon:
					case GreaterThan:
					case Pipe:
						{
						alt40=6;
						}
						break;
					case Hash:
						{
						alt40=7;
						}
						break;
					case Equals:
					case Exclamation:
						{
						alt40=9;
						}
						break;
					case LessThan:
						{
						int LA40_34 = input.LA(4);
						if ( (LA40_34==Equals||LA40_34==Exclamation) ) {
							alt40=9;
						}
						else if ( (LA40_34==ALC||LA40_34==AUC||(LA40_34 >= BLC && LA40_34 <= BUC)||LA40_34==CLC||LA40_34==CUC||(LA40_34 >= DLC && LA40_34 <= DUC)||LA40_34==ELC||LA40_34==EUC||(LA40_34 >= FLC && LA40_34 <= FUC)||LA40_34==GLC||LA40_34==GUC||(LA40_34 >= HLC && LA40_34 <= HUC)||(LA40_34 >= ILC && LA40_34 <= KUC)||LA40_34==LLC||LA40_34==LUC||(LA40_34 >= MLC && LA40_34 <= MUC)||LA40_34==NLC||LA40_34==NUC||LA40_34==OLC||LA40_34==OUC||LA40_34==PLC||LA40_34==PUC||LA40_34==QLC||LA40_34==QUC||(LA40_34 >= RLC && LA40_34 <= RUC)||LA40_34==SLC||LA40_34==SUC||(LA40_34 >= TLC && LA40_34 <= TUC)||LA40_34==ULC||(LA40_34 >= UUC && LA40_34 <= Underscore)||(LA40_34 >= VLC && LA40_34 <= VUC)||(LA40_34 >= WLC && LA40_34 <= WUC)||(LA40_34 >= XLC && LA40_34 <= XUC)||(LA40_34 >= YLC && LA40_34 <= ZUC)) ) {
							alt40=5;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 34, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case OpenParen:
						{
						alt40=11;
						}
						break;
					case CUC:
						{
						alt40=14;
						}
						break;
					case SingleQuote:
						{
						alt40=5;
						}
						break;
					case ILC:
					case JUC:
					case MLC:
					case SLC:
					case UUC:
					case XLC:
						{
						alt40=8;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 20, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case Star:
					{
					switch ( input.LA(3) ) {
					case NUC:
					case UUC:
						{
						alt40=8;
						}
						break;
					case AUC:
						{
						int LA40_38 = input.LA(4);
						if ( (LA40_38==CUC) ) {
							alt40=12;
						}
						else if ( (LA40_38==NUC) ) {
							alt40=13;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 38, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case Colon:
					case FUC:
					case MUC:
					case PUC:
					case SUC:
					case TUC:
						{
						alt40=12;
						}
						break;
					case CUC:
						{
						int LA40_40 = input.LA(4);
						if ( (LA40_40==OUC) ) {
							alt40=12;
						}
						else if ( (LA40_40==RUC) ) {
							alt40=13;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 40, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case BUC:
					case LUC:
						{
						alt40=13;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 21, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case ALC:
				case AUC:
				case Ampersand:
				case BLC:
				case BUC:
				case Backslash:
				case BellChar:
				case BlockQuoted:
				case CLC:
				case CUC:
				case Caret:
				case CarriageReturn:
				case CharWithProperty:
				case CharWithoutProperty:
				case CharacterClassEnd:
				case CharacterClassStart:
				case CloseBrace:
				case CloseParen:
				case Colon:
				case Comma:
				case ControlChar:
				case D0:
				case D1:
				case D2:
				case D3:
				case D4:
				case D5:
				case D6:
				case D7:
				case D8:
				case D9:
				case DLC:
				case DUC:
				case DecimalDigit:
				case Dot:
				case ELC:
				case EUC:
				case EndOfSubject:
				case EndOfSubjectOrLine:
				case EndOfSubjectOrLineEndOfSubject:
				case Equals:
				case EscapeChar:
				case Exclamation:
				case ExtendedUnicodeChar:
				case FLC:
				case FUC:
				case FormFeed:
				case GLC:
				case GUC:
				case GreaterThan:
				case HLC:
				case HUC:
				case Hash:
				case HexChar:
				case HorizontalWhiteSpace:
				case Hyphen:
				case ILC:
				case IUC:
				case JLC:
				case JUC:
				case KLC:
				case KUC:
				case LLC:
				case LUC:
				case LessThan:
				case MLC:
				case MUC:
				case NLC:
				case NUC:
				case NamedReferenceStartK:
				case NewLine:
				case NewLineSequence:
				case NonWordBoundary:
				case NotDecimalDigit:
				case NotHorizontalWhiteSpace:
				case NotNewLine:
				case NotVerticalWhiteSpace:
				case NotWhiteSpace:
				case NotWordChar:
				case OLC:
				case OUC:
				case OneDataUnit:
				case OpenBrace:
				case OpenParen:
				case OtherChar:
				case PLC:
				case POSIXNamedSet:
				case POSIXNegatedNamedSet:
				case PUC:
				case Pipe:
				case PreviousMatchInSubject:
				case QLC:
				case QUC:
				case Quoted:
				case RLC:
				case RUC:
				case ResetStartMatch:
				case SLC:
				case SUC:
				case SingleQuote:
				case StartOfSubject:
				case SubroutineOrNamedReferenceStartG:
				case TLC:
				case TUC:
				case Tab:
				case ULC:
				case UUC:
				case Underscore:
				case VLC:
				case VUC:
				case VerticalWhiteSpace:
				case WLC:
				case WUC:
				case WhiteSpace:
				case WordBoundary:
				case WordChar:
				case XLC:
				case XUC:
				case YLC:
				case YUC:
				case ZLC:
				case ZUC:
					{
					alt40=5;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case SubroutineOrNamedReferenceStartG:
				{
				int LA40_2 = input.LA(2);
				if ( (LA40_2==LessThan||LA40_2==SingleQuote) ) {
					alt40=1;
				}
				else if ( ((LA40_2 >= D0 && LA40_2 <= D9)||LA40_2==OpenBrace) ) {
					alt40=10;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CharWithProperty:
			case CharWithoutProperty:
			case ControlChar:
			case DecimalDigit:
			case HorizontalWhiteSpace:
			case NewLineSequence:
			case NotDecimalDigit:
			case NotHorizontalWhiteSpace:
			case NotNewLine:
			case NotVerticalWhiteSpace:
			case NotWhiteSpace:
			case NotWordChar:
			case POSIXNamedSet:
			case POSIXNegatedNamedSet:
			case VerticalWhiteSpace:
			case WhiteSpace:
			case WordChar:
				{
				alt40=2;
				}
				break;
			case Backslash:
				{
				switch ( input.LA(2) ) {
				case D0:
					{
					int LA40_24 = input.LA(3);
					if ( ((LA40_24 >= D0 && LA40_24 <= D7)) ) {
						int LA40_42 = input.LA(4);
						if ( (synpred106_PCRE()) ) {
							alt40=3;
						}
						else if ( (synpred113_PCRE()) ) {
							alt40=10;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 42, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA40_24==EOF||LA40_24==ALC||LA40_24==AUC||LA40_24==Ampersand||(LA40_24 >= BLC && LA40_24 <= BlockQuoted)||LA40_24==CLC||(LA40_24 >= CUC && LA40_24 <= ControlChar)||(LA40_24 >= D8 && LA40_24 <= D9)||(LA40_24 >= DLC && LA40_24 <= ELC)||(LA40_24 >= EUC && LA40_24 <= GLC)||(LA40_24 >= GUC && LA40_24 <= HexChar)||(LA40_24 >= HorizontalWhiteSpace && LA40_24 <= KUC)||LA40_24==LLC||(LA40_24 >= LUC && LA40_24 <= MUC)||LA40_24==NLC||LA40_24==NUC||(LA40_24 >= NamedReferenceStartK && LA40_24 <= NewLineSequence)||(LA40_24 >= NonWordBoundary && LA40_24 <= OLC)||LA40_24==OUC||(LA40_24 >= OneDataUnit && LA40_24 <= POSIXNegatedNamedSet)||(LA40_24 >= PUC && LA40_24 <= QLC)||(LA40_24 >= QUC && LA40_24 <= Quoted)||(LA40_24 >= RLC && LA40_24 <= ResetStartMatch)||LA40_24==SLC||(LA40_24 >= SUC && LA40_24 <= ULC)||(LA40_24 >= UUC && LA40_24 <= Underscore)||(LA40_24 >= VLC && LA40_24 <= XUC)||(LA40_24 >= YLC && LA40_24 <= ZUC)) ) {
						alt40=10;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 24, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D1:
					{
					int LA40_25 = input.LA(3);
					if ( ((LA40_25 >= D0 && LA40_25 <= D7)) ) {
						int LA40_42 = input.LA(4);
						if ( (synpred106_PCRE()) ) {
							alt40=3;
						}
						else if ( (synpred113_PCRE()) ) {
							alt40=10;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 42, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA40_25==EOF||LA40_25==ALC||LA40_25==AUC||LA40_25==Ampersand||(LA40_25 >= BLC && LA40_25 <= BlockQuoted)||LA40_25==CLC||(LA40_25 >= CUC && LA40_25 <= ControlChar)||(LA40_25 >= D8 && LA40_25 <= D9)||(LA40_25 >= DLC && LA40_25 <= ELC)||(LA40_25 >= EUC && LA40_25 <= GLC)||(LA40_25 >= GUC && LA40_25 <= HexChar)||(LA40_25 >= HorizontalWhiteSpace && LA40_25 <= KUC)||LA40_25==LLC||(LA40_25 >= LUC && LA40_25 <= MUC)||LA40_25==NLC||LA40_25==NUC||(LA40_25 >= NamedReferenceStartK && LA40_25 <= NewLineSequence)||(LA40_25 >= NonWordBoundary && LA40_25 <= OLC)||LA40_25==OUC||(LA40_25 >= OneDataUnit && LA40_25 <= POSIXNegatedNamedSet)||(LA40_25 >= PUC && LA40_25 <= QLC)||(LA40_25 >= QUC && LA40_25 <= Quoted)||(LA40_25 >= RLC && LA40_25 <= ResetStartMatch)||LA40_25==SLC||(LA40_25 >= SUC && LA40_25 <= ULC)||(LA40_25 >= UUC && LA40_25 <= Underscore)||(LA40_25 >= VLC && LA40_25 <= XUC)||(LA40_25 >= YLC && LA40_25 <= ZUC)) ) {
						alt40=10;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 25, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D2:
					{
					int LA40_26 = input.LA(3);
					if ( ((LA40_26 >= D0 && LA40_26 <= D7)) ) {
						int LA40_42 = input.LA(4);
						if ( (synpred106_PCRE()) ) {
							alt40=3;
						}
						else if ( (synpred113_PCRE()) ) {
							alt40=10;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 42, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA40_26==EOF||LA40_26==ALC||LA40_26==AUC||LA40_26==Ampersand||(LA40_26 >= BLC && LA40_26 <= BlockQuoted)||LA40_26==CLC||(LA40_26 >= CUC && LA40_26 <= ControlChar)||(LA40_26 >= D8 && LA40_26 <= D9)||(LA40_26 >= DLC && LA40_26 <= ELC)||(LA40_26 >= EUC && LA40_26 <= GLC)||(LA40_26 >= GUC && LA40_26 <= HexChar)||(LA40_26 >= HorizontalWhiteSpace && LA40_26 <= KUC)||LA40_26==LLC||(LA40_26 >= LUC && LA40_26 <= MUC)||LA40_26==NLC||LA40_26==NUC||(LA40_26 >= NamedReferenceStartK && LA40_26 <= NewLineSequence)||(LA40_26 >= NonWordBoundary && LA40_26 <= OLC)||LA40_26==OUC||(LA40_26 >= OneDataUnit && LA40_26 <= POSIXNegatedNamedSet)||(LA40_26 >= PUC && LA40_26 <= QLC)||(LA40_26 >= QUC && LA40_26 <= Quoted)||(LA40_26 >= RLC && LA40_26 <= ResetStartMatch)||LA40_26==SLC||(LA40_26 >= SUC && LA40_26 <= ULC)||(LA40_26 >= UUC && LA40_26 <= Underscore)||(LA40_26 >= VLC && LA40_26 <= XUC)||(LA40_26 >= YLC && LA40_26 <= ZUC)) ) {
						alt40=10;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 26, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D3:
					{
					int LA40_27 = input.LA(3);
					if ( ((LA40_27 >= D0 && LA40_27 <= D7)) ) {
						int LA40_42 = input.LA(4);
						if ( (synpred106_PCRE()) ) {
							alt40=3;
						}
						else if ( (synpred113_PCRE()) ) {
							alt40=10;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 42, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA40_27==EOF||LA40_27==ALC||LA40_27==AUC||LA40_27==Ampersand||(LA40_27 >= BLC && LA40_27 <= BlockQuoted)||LA40_27==CLC||(LA40_27 >= CUC && LA40_27 <= ControlChar)||(LA40_27 >= D8 && LA40_27 <= D9)||(LA40_27 >= DLC && LA40_27 <= ELC)||(LA40_27 >= EUC && LA40_27 <= GLC)||(LA40_27 >= GUC && LA40_27 <= HexChar)||(LA40_27 >= HorizontalWhiteSpace && LA40_27 <= KUC)||LA40_27==LLC||(LA40_27 >= LUC && LA40_27 <= MUC)||LA40_27==NLC||LA40_27==NUC||(LA40_27 >= NamedReferenceStartK && LA40_27 <= NewLineSequence)||(LA40_27 >= NonWordBoundary && LA40_27 <= OLC)||LA40_27==OUC||(LA40_27 >= OneDataUnit && LA40_27 <= POSIXNegatedNamedSet)||(LA40_27 >= PUC && LA40_27 <= QLC)||(LA40_27 >= QUC && LA40_27 <= Quoted)||(LA40_27 >= RLC && LA40_27 <= ResetStartMatch)||LA40_27==SLC||(LA40_27 >= SUC && LA40_27 <= ULC)||(LA40_27 >= UUC && LA40_27 <= Underscore)||(LA40_27 >= VLC && LA40_27 <= XUC)||(LA40_27 >= YLC && LA40_27 <= ZUC)) ) {
						alt40=10;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 27, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D4:
				case D5:
				case D6:
				case D7:
					{
					int LA40_28 = input.LA(3);
					if ( ((LA40_28 >= D0 && LA40_28 <= D7)) ) {
						int LA40_43 = input.LA(4);
						if ( (synpred106_PCRE()) ) {
							alt40=3;
						}
						else if ( (synpred113_PCRE()) ) {
							alt40=10;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 40, 43, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA40_28==EOF||LA40_28==ALC||LA40_28==AUC||LA40_28==Ampersand||(LA40_28 >= BLC && LA40_28 <= BlockQuoted)||LA40_28==CLC||(LA40_28 >= CUC && LA40_28 <= ControlChar)||(LA40_28 >= D8 && LA40_28 <= D9)||(LA40_28 >= DLC && LA40_28 <= ELC)||(LA40_28 >= EUC && LA40_28 <= GLC)||(LA40_28 >= GUC && LA40_28 <= HexChar)||(LA40_28 >= HorizontalWhiteSpace && LA40_28 <= KUC)||LA40_28==LLC||(LA40_28 >= LUC && LA40_28 <= MUC)||LA40_28==NLC||LA40_28==NUC||(LA40_28 >= NamedReferenceStartK && LA40_28 <= NewLineSequence)||(LA40_28 >= NonWordBoundary && LA40_28 <= OLC)||LA40_28==OUC||(LA40_28 >= OneDataUnit && LA40_28 <= POSIXNegatedNamedSet)||(LA40_28 >= PUC && LA40_28 <= QLC)||(LA40_28 >= QUC && LA40_28 <= Quoted)||(LA40_28 >= RLC && LA40_28 <= ResetStartMatch)||LA40_28==SLC||(LA40_28 >= SUC && LA40_28 <= ULC)||(LA40_28 >= UUC && LA40_28 <= Underscore)||(LA40_28 >= VLC && LA40_28 <= XUC)||(LA40_28 >= YLC && LA40_28 <= ZUC)) ) {
						alt40=10;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 40, 28, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D8:
				case D9:
					{
					alt40=10;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case ALC:
			case AUC:
			case Ampersand:
			case BLC:
			case BUC:
			case BellChar:
			case BlockQuoted:
			case CLC:
			case CUC:
			case CarriageReturn:
			case CharacterClassEnd:
			case CloseBrace:
			case Colon:
			case Comma:
			case D0:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case DLC:
			case DUC:
			case ELC:
			case EUC:
			case Equals:
			case EscapeChar:
			case Exclamation:
			case FLC:
			case FUC:
			case FormFeed:
			case GLC:
			case GUC:
			case GreaterThan:
			case HLC:
			case HUC:
			case Hash:
			case HexChar:
			case Hyphen:
			case ILC:
			case IUC:
			case JLC:
			case JUC:
			case KLC:
			case KUC:
			case LLC:
			case LUC:
			case LessThan:
			case MLC:
			case MUC:
			case NLC:
			case NUC:
			case NewLine:
			case OLC:
			case OUC:
			case OpenBrace:
			case OtherChar:
			case PLC:
			case PUC:
			case QLC:
			case QUC:
			case Quoted:
			case RLC:
			case RUC:
			case SLC:
			case SUC:
			case SingleQuote:
			case TLC:
			case TUC:
			case Tab:
			case ULC:
			case UUC:
			case Underscore:
			case VLC:
			case VUC:
			case WLC:
			case WUC:
			case XLC:
			case XUC:
			case YLC:
			case YUC:
			case ZLC:
			case ZUC:
				{
				alt40=3;
				}
				break;
			case CharacterClassStart:
				{
				alt40=4;
				}
				break;
			case NamedReferenceStartK:
				{
				alt40=10;
				}
				break;
			case Dot:
				{
				alt40=15;
				}
				break;
			case Caret:
				{
				alt40=16;
				}
				break;
			case StartOfSubject:
				{
				alt40=17;
				}
				break;
			case WordBoundary:
				{
				alt40=18;
				}
				break;
			case NonWordBoundary:
				{
				alt40=19;
				}
				break;
			case EndOfSubjectOrLine:
				{
				alt40=20;
				}
				break;
			case EndOfSubjectOrLineEndOfSubject:
				{
				alt40=21;
				}
				break;
			case EndOfSubject:
				{
				alt40=22;
				}
				break;
			case PreviousMatchInSubject:
				{
				alt40=23;
				}
				break;
			case ResetStartMatch:
				{
				alt40=24;
				}
				break;
			case OneDataUnit:
				{
				alt40=25;
				}
				break;
			case ExtendedUnicodeChar:
				{
				alt40=26;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}
			switch (alt40) {
				case 1 :
					// PCRE.g:551:4: subroutine_reference
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_subroutine_reference_in_atom4382);
					subroutine_reference548=subroutine_reference();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, subroutine_reference548.getTree());

					}
					break;
				case 2 :
					// PCRE.g:552:4: shared_atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_shared_atom_in_atom4387);
					shared_atom549=shared_atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, shared_atom549.getTree());

					}
					break;
				case 3 :
					// PCRE.g:553:4: literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_literal_in_atom4392);
					literal550=literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal550.getTree());

					}
					break;
				case 4 :
					// PCRE.g:554:4: character_class
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_character_class_in_atom4397);
					character_class551=character_class();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, character_class551.getTree());

					}
					break;
				case 5 :
					// PCRE.g:555:4: capture
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_capture_in_atom4402);
					capture552=capture();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, capture552.getTree());

					}
					break;
				case 6 :
					// PCRE.g:556:4: non_capture
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_non_capture_in_atom4407);
					non_capture553=non_capture();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, non_capture553.getTree());

					}
					break;
				case 7 :
					// PCRE.g:557:4: comment
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_comment_in_atom4412);
					comment554=comment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment554.getTree());

					}
					break;
				case 8 :
					// PCRE.g:558:4: option
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_option_in_atom4417);
					option555=option();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option555.getTree());

					}
					break;
				case 9 :
					// PCRE.g:559:4: look_around
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_look_around_in_atom4422);
					look_around556=look_around();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, look_around556.getTree());

					}
					break;
				case 10 :
					// PCRE.g:560:4: backreference
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_backreference_in_atom4427);
					backreference557=backreference();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, backreference557.getTree());

					}
					break;
				case 11 :
					// PCRE.g:561:4: conditional
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_conditional_in_atom4432);
					conditional558=conditional();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conditional558.getTree());

					}
					break;
				case 12 :
					// PCRE.g:562:4: backtrack_control
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_backtrack_control_in_atom4437);
					backtrack_control559=backtrack_control();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, backtrack_control559.getTree());

					}
					break;
				case 13 :
					// PCRE.g:563:4: newline_convention
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_newline_convention_in_atom4442);
					newline_convention560=newline_convention();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, newline_convention560.getTree());

					}
					break;
				case 14 :
					// PCRE.g:564:4: callout
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_callout_in_atom4447);
					callout561=callout();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, callout561.getTree());

					}
					break;
				case 15 :
					// PCRE.g:565:4: Dot
					{
					Dot562=(Token)match(input,Dot,FOLLOW_Dot_in_atom4452); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Dot.add(Dot562);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 565:23: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 16 :
					// PCRE.g:566:4: Caret
					{
					Caret563=(Token)match(input,Caret,FOLLOW_Caret_in_atom4476); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Caret.add(Caret563);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 566:23: -> START_OF_SUBJECT
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(START_OF_SUBJECT, "START_OF_SUBJECT"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 17 :
					// PCRE.g:567:4: StartOfSubject
					{
					StartOfSubject564=(Token)match(input,StartOfSubject,FOLLOW_StartOfSubject_in_atom4498); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_StartOfSubject.add(StartOfSubject564);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 567:23: -> START_OF_SUBJECT
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(START_OF_SUBJECT, "START_OF_SUBJECT"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 18 :
					// PCRE.g:568:4: WordBoundary
					{
					root_0 = (CommonTree)adaptor.nil();


					WordBoundary565=(Token)match(input,WordBoundary,FOLLOW_WordBoundary_in_atom4511); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WordBoundary565_tree = (CommonTree)adaptor.create(WordBoundary565);
					adaptor.addChild(root_0, WordBoundary565_tree);
					}

					}
					break;
				case 19 :
					// PCRE.g:569:4: NonWordBoundary
					{
					root_0 = (CommonTree)adaptor.nil();


					NonWordBoundary566=(Token)match(input,NonWordBoundary,FOLLOW_NonWordBoundary_in_atom4516); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NonWordBoundary566_tree = (CommonTree)adaptor.create(NonWordBoundary566);
					adaptor.addChild(root_0, NonWordBoundary566_tree);
					}

					}
					break;
				case 20 :
					// PCRE.g:570:4: EndOfSubjectOrLine
					{
					root_0 = (CommonTree)adaptor.nil();


					EndOfSubjectOrLine567=(Token)match(input,EndOfSubjectOrLine,FOLLOW_EndOfSubjectOrLine_in_atom4521); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EndOfSubjectOrLine567_tree = (CommonTree)adaptor.create(EndOfSubjectOrLine567);
					adaptor.addChild(root_0, EndOfSubjectOrLine567_tree);
					}

					}
					break;
				case 21 :
					// PCRE.g:571:4: EndOfSubjectOrLineEndOfSubject
					{
					root_0 = (CommonTree)adaptor.nil();


					EndOfSubjectOrLineEndOfSubject568=(Token)match(input,EndOfSubjectOrLineEndOfSubject,FOLLOW_EndOfSubjectOrLineEndOfSubject_in_atom4526); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EndOfSubjectOrLineEndOfSubject568_tree = (CommonTree)adaptor.create(EndOfSubjectOrLineEndOfSubject568);
					adaptor.addChild(root_0, EndOfSubjectOrLineEndOfSubject568_tree);
					}

					}
					break;
				case 22 :
					// PCRE.g:572:4: EndOfSubject
					{
					root_0 = (CommonTree)adaptor.nil();


					EndOfSubject569=(Token)match(input,EndOfSubject,FOLLOW_EndOfSubject_in_atom4531); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EndOfSubject569_tree = (CommonTree)adaptor.create(EndOfSubject569);
					adaptor.addChild(root_0, EndOfSubject569_tree);
					}

					}
					break;
				case 23 :
					// PCRE.g:573:4: PreviousMatchInSubject
					{
					root_0 = (CommonTree)adaptor.nil();


					PreviousMatchInSubject570=(Token)match(input,PreviousMatchInSubject,FOLLOW_PreviousMatchInSubject_in_atom4536); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PreviousMatchInSubject570_tree = (CommonTree)adaptor.create(PreviousMatchInSubject570);
					adaptor.addChild(root_0, PreviousMatchInSubject570_tree);
					}

					}
					break;
				case 24 :
					// PCRE.g:574:4: ResetStartMatch
					{
					root_0 = (CommonTree)adaptor.nil();


					ResetStartMatch571=(Token)match(input,ResetStartMatch,FOLLOW_ResetStartMatch_in_atom4541); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ResetStartMatch571_tree = (CommonTree)adaptor.create(ResetStartMatch571);
					adaptor.addChild(root_0, ResetStartMatch571_tree);
					}

					}
					break;
				case 25 :
					// PCRE.g:575:4: OneDataUnit
					{
					root_0 = (CommonTree)adaptor.nil();


					OneDataUnit572=(Token)match(input,OneDataUnit,FOLLOW_OneDataUnit_in_atom4546); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OneDataUnit572_tree = (CommonTree)adaptor.create(OneDataUnit572);
					adaptor.addChild(root_0, OneDataUnit572_tree);
					}

					}
					break;
				case 26 :
					// PCRE.g:576:4: ExtendedUnicodeChar
					{
					root_0 = (CommonTree)adaptor.nil();


					ExtendedUnicodeChar573=(Token)match(input,ExtendedUnicodeChar,FOLLOW_ExtendedUnicodeChar_in_atom4551); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ExtendedUnicodeChar573_tree = (CommonTree)adaptor.create(ExtendedUnicodeChar573);
					adaptor.addChild(root_0, ExtendedUnicodeChar573_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 24, atom_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class cc_atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cc_atom"
	// PCRE.g:579:1: cc_atom : ( cc_literal Hyphen cc_literal -> ^( RANGE cc_literal cc_literal ) | shared_atom | cc_literal | backreference_or_octal );
	public final PCREParser.cc_atom_return cc_atom() throws RecognitionException {
		PCREParser.cc_atom_return retval = new PCREParser.cc_atom_return();
		retval.start = input.LT(1);
		int cc_atom_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Hyphen575=null;
		ParserRuleReturnScope cc_literal574 =null;
		ParserRuleReturnScope cc_literal576 =null;
		ParserRuleReturnScope shared_atom577 =null;
		ParserRuleReturnScope cc_literal578 =null;
		ParserRuleReturnScope backreference_or_octal579 =null;

		CommonTree Hyphen575_tree=null;
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleSubtreeStream stream_cc_literal=new RewriteRuleSubtreeStream(adaptor,"rule cc_literal");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }

			// PCRE.g:580:2: ( cc_literal Hyphen cc_literal -> ^( RANGE cc_literal cc_literal ) | shared_atom | cc_literal | backreference_or_octal )
			int alt41=4;
			alt41 = dfa41.predict(input);
			switch (alt41) {
				case 1 :
					// PCRE.g:580:4: cc_literal Hyphen cc_literal
					{
					pushFollow(FOLLOW_cc_literal_in_cc_atom4562);
					cc_literal574=cc_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cc_literal.add(cc_literal574.getTree());
					Hyphen575=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_cc_atom4564); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen575);

					pushFollow(FOLLOW_cc_literal_in_cc_atom4566);
					cc_literal576=cc_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cc_literal.add(cc_literal576.getTree());
					// AST REWRITE
					// elements: cc_literal, cc_literal
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 580:33: -> ^( RANGE cc_literal cc_literal )
					{
						// PCRE.g:580:36: ^( RANGE cc_literal cc_literal )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_1);
						adaptor.addChild(root_1, stream_cc_literal.nextTree());
						adaptor.addChild(root_1, stream_cc_literal.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// PCRE.g:581:4: shared_atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_shared_atom_in_cc_atom4581);
					shared_atom577=shared_atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, shared_atom577.getTree());

					}
					break;
				case 3 :
					// PCRE.g:582:4: cc_literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_cc_literal_in_cc_atom4586);
					cc_literal578=cc_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cc_literal578.getTree());

					}
					break;
				case 4 :
					// PCRE.g:583:4: backreference_or_octal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_backreference_or_octal_in_cc_atom4591);
					backreference_or_octal579=backreference_or_octal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, backreference_or_octal579.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 25, cc_atom_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "cc_atom"


	public static class shared_atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "shared_atom"
	// PCRE.g:586:1: shared_atom : ( POSIXNamedSet | POSIXNegatedNamedSet | ControlChar | DecimalDigit | NotDecimalDigit | HorizontalWhiteSpace | NotHorizontalWhiteSpace | NotNewLine | CharWithProperty | CharWithoutProperty | NewLineSequence | WhiteSpace | NotWhiteSpace | VerticalWhiteSpace | NotVerticalWhiteSpace | WordChar | NotWordChar );
	public final PCREParser.shared_atom_return shared_atom() throws RecognitionException {
		PCREParser.shared_atom_return retval = new PCREParser.shared_atom_return();
		retval.start = input.LT(1);
		int shared_atom_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set580=null;

		CommonTree set580_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

			// PCRE.g:587:2: ( POSIXNamedSet | POSIXNegatedNamedSet | ControlChar | DecimalDigit | NotDecimalDigit | HorizontalWhiteSpace | NotHorizontalWhiteSpace | NotNewLine | CharWithProperty | CharWithoutProperty | NewLineSequence | WhiteSpace | NotWhiteSpace | VerticalWhiteSpace | NotVerticalWhiteSpace | WordChar | NotWordChar )
			// PCRE.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set580=input.LT(1);
			if ( (input.LA(1) >= CharWithProperty && input.LA(1) <= CharWithoutProperty)||input.LA(1)==ControlChar||input.LA(1)==DecimalDigit||input.LA(1)==HorizontalWhiteSpace||input.LA(1)==NewLineSequence||(input.LA(1) >= NotDecimalDigit && input.LA(1) <= NotWordChar)||(input.LA(1) >= POSIXNamedSet && input.LA(1) <= POSIXNegatedNamedSet)||input.LA(1)==VerticalWhiteSpace||input.LA(1)==WhiteSpace||input.LA(1)==WordChar ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set580));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 26, shared_atom_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "shared_atom"


	public static class literal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// PCRE.g:606:1: literal : ( shared_literal | CharacterClassEnd -> LITERAL[\"]\"] );
	public final PCREParser.literal_return literal() throws RecognitionException {
		PCREParser.literal_return retval = new PCREParser.literal_return();
		retval.start = input.LT(1);
		int literal_StartIndex = input.index();

		CommonTree root_0 = null;

		Token CharacterClassEnd582=null;
		ParserRuleReturnScope shared_literal581 =null;

		CommonTree CharacterClassEnd582_tree=null;
		RewriteRuleTokenStream stream_CharacterClassEnd=new RewriteRuleTokenStream(adaptor,"token CharacterClassEnd");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }

			// PCRE.g:607:2: ( shared_literal | CharacterClassEnd -> LITERAL[\"]\"] )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==ALC||LA42_0==AUC||LA42_0==Ampersand||(LA42_0 >= BLC && LA42_0 <= BlockQuoted)||LA42_0==CLC||LA42_0==CUC||LA42_0==CarriageReturn||LA42_0==CloseBrace||(LA42_0 >= Colon && LA42_0 <= Comma)||(LA42_0 >= D0 && LA42_0 <= D9)||(LA42_0 >= DLC && LA42_0 <= DUC)||LA42_0==ELC||LA42_0==EUC||(LA42_0 >= Equals && LA42_0 <= Exclamation)||(LA42_0 >= FLC && LA42_0 <= GLC)||(LA42_0 >= GUC && LA42_0 <= HexChar)||(LA42_0 >= Hyphen && LA42_0 <= KUC)||LA42_0==LLC||(LA42_0 >= LUC && LA42_0 <= MUC)||LA42_0==NLC||LA42_0==NUC||LA42_0==NewLine||LA42_0==OLC||LA42_0==OUC||LA42_0==OpenBrace||(LA42_0 >= OtherChar && LA42_0 <= PLC)||LA42_0==PUC||LA42_0==QLC||LA42_0==QUC||LA42_0==Quoted||(LA42_0 >= RLC && LA42_0 <= RUC)||LA42_0==SLC||(LA42_0 >= SUC && LA42_0 <= SingleQuote)||(LA42_0 >= TLC && LA42_0 <= ULC)||(LA42_0 >= UUC && LA42_0 <= Underscore)||(LA42_0 >= VLC && LA42_0 <= VUC)||(LA42_0 >= WLC && LA42_0 <= WUC)||(LA42_0 >= XLC && LA42_0 <= XUC)||(LA42_0 >= YLC && LA42_0 <= ZUC)) ) {
				alt42=1;
			}
			else if ( (LA42_0==CharacterClassEnd) ) {
				alt42=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// PCRE.g:607:4: shared_literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_shared_literal_in_literal4695);
					shared_literal581=shared_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, shared_literal581.getTree());

					}
					break;
				case 2 :
					// PCRE.g:608:4: CharacterClassEnd
					{
					CharacterClassEnd582=(Token)match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_literal4700); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassEnd.add(CharacterClassEnd582);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 608:22: -> LITERAL[\"]\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "]"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 27, literal_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "literal"


	public static class cc_literal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cc_literal"
	// PCRE.g:611:1: cc_literal : ( shared_literal | Dot -> LITERAL[\".\"] | CharacterClassStart -> LITERAL[\"[\"] | Caret -> LITERAL[\"^\"] | QuestionMark -> LITERAL[\"?\"] | Plus -> LITERAL[\"+\"] | Star -> LITERAL[\"*\"] | WordBoundary -> LITERAL[\"\\u0008\"] | EndOfSubjectOrLine -> LITERAL[\"$\"] | Pipe -> LITERAL[\"|\"] | OpenParen -> LITERAL[\"(\"] | CloseParen -> LITERAL[\")\"] );
	public final PCREParser.cc_literal_return cc_literal() throws RecognitionException {
		PCREParser.cc_literal_return retval = new PCREParser.cc_literal_return();
		retval.start = input.LT(1);
		int cc_literal_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Dot584=null;
		Token CharacterClassStart585=null;
		Token Caret586=null;
		Token QuestionMark587=null;
		Token Plus588=null;
		Token Star589=null;
		Token WordBoundary590=null;
		Token EndOfSubjectOrLine591=null;
		Token Pipe592=null;
		Token OpenParen593=null;
		Token CloseParen594=null;
		ParserRuleReturnScope shared_literal583 =null;

		CommonTree Dot584_tree=null;
		CommonTree CharacterClassStart585_tree=null;
		CommonTree Caret586_tree=null;
		CommonTree QuestionMark587_tree=null;
		CommonTree Plus588_tree=null;
		CommonTree Star589_tree=null;
		CommonTree WordBoundary590_tree=null;
		CommonTree EndOfSubjectOrLine591_tree=null;
		CommonTree Pipe592_tree=null;
		CommonTree OpenParen593_tree=null;
		CommonTree CloseParen594_tree=null;
		RewriteRuleTokenStream stream_OpenParen=new RewriteRuleTokenStream(adaptor,"token OpenParen");
		RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
		RewriteRuleTokenStream stream_QuestionMark=new RewriteRuleTokenStream(adaptor,"token QuestionMark");
		RewriteRuleTokenStream stream_CloseParen=new RewriteRuleTokenStream(adaptor,"token CloseParen");
		RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
		RewriteRuleTokenStream stream_WordBoundary=new RewriteRuleTokenStream(adaptor,"token WordBoundary");
		RewriteRuleTokenStream stream_Pipe=new RewriteRuleTokenStream(adaptor,"token Pipe");
		RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
		RewriteRuleTokenStream stream_CharacterClassStart=new RewriteRuleTokenStream(adaptor,"token CharacterClassStart");
		RewriteRuleTokenStream stream_Caret=new RewriteRuleTokenStream(adaptor,"token Caret");
		RewriteRuleTokenStream stream_EndOfSubjectOrLine=new RewriteRuleTokenStream(adaptor,"token EndOfSubjectOrLine");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }

			// PCRE.g:612:2: ( shared_literal | Dot -> LITERAL[\".\"] | CharacterClassStart -> LITERAL[\"[\"] | Caret -> LITERAL[\"^\"] | QuestionMark -> LITERAL[\"?\"] | Plus -> LITERAL[\"+\"] | Star -> LITERAL[\"*\"] | WordBoundary -> LITERAL[\"\\u0008\"] | EndOfSubjectOrLine -> LITERAL[\"$\"] | Pipe -> LITERAL[\"|\"] | OpenParen -> LITERAL[\"(\"] | CloseParen -> LITERAL[\")\"] )
			int alt43=12;
			switch ( input.LA(1) ) {
			case ALC:
			case AUC:
			case Ampersand:
			case BLC:
			case BUC:
			case Backslash:
			case BellChar:
			case BlockQuoted:
			case CLC:
			case CUC:
			case CarriageReturn:
			case CloseBrace:
			case Colon:
			case Comma:
			case D0:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
			case DLC:
			case DUC:
			case ELC:
			case EUC:
			case Equals:
			case EscapeChar:
			case Exclamation:
			case FLC:
			case FUC:
			case FormFeed:
			case GLC:
			case GUC:
			case GreaterThan:
			case HLC:
			case HUC:
			case Hash:
			case HexChar:
			case Hyphen:
			case ILC:
			case IUC:
			case JLC:
			case JUC:
			case KLC:
			case KUC:
			case LLC:
			case LUC:
			case LessThan:
			case MLC:
			case MUC:
			case NLC:
			case NUC:
			case NewLine:
			case OLC:
			case OUC:
			case OpenBrace:
			case OtherChar:
			case PLC:
			case PUC:
			case QLC:
			case QUC:
			case Quoted:
			case RLC:
			case RUC:
			case SLC:
			case SUC:
			case SingleQuote:
			case TLC:
			case TUC:
			case Tab:
			case ULC:
			case UUC:
			case Underscore:
			case VLC:
			case VUC:
			case WLC:
			case WUC:
			case XLC:
			case XUC:
			case YLC:
			case YUC:
			case ZLC:
			case ZUC:
				{
				alt43=1;
				}
				break;
			case Dot:
				{
				alt43=2;
				}
				break;
			case CharacterClassStart:
				{
				alt43=3;
				}
				break;
			case Caret:
				{
				alt43=4;
				}
				break;
			case QuestionMark:
				{
				alt43=5;
				}
				break;
			case Plus:
				{
				alt43=6;
				}
				break;
			case Star:
				{
				alt43=7;
				}
				break;
			case WordBoundary:
				{
				alt43=8;
				}
				break;
			case EndOfSubjectOrLine:
				{
				alt43=9;
				}
				break;
			case Pipe:
				{
				alt43=10;
				}
				break;
			case OpenParen:
				{
				alt43=11;
				}
				break;
			case CloseParen:
				{
				alt43=12;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}
			switch (alt43) {
				case 1 :
					// PCRE.g:612:4: shared_literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_shared_literal_in_cc_literal4716);
					shared_literal583=shared_literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, shared_literal583.getTree());

					}
					break;
				case 2 :
					// PCRE.g:613:4: Dot
					{
					Dot584=(Token)match(input,Dot,FOLLOW_Dot_in_cc_literal4721); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Dot.add(Dot584);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 613:24: -> LITERAL[\".\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "."));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:614:4: CharacterClassStart
					{
					CharacterClassStart585=(Token)match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_cc_literal4747); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CharacterClassStart.add(CharacterClassStart585);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 614:24: -> LITERAL[\"[\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "["));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:615:4: Caret
					{
					Caret586=(Token)match(input,Caret,FOLLOW_Caret_in_cc_literal4757); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Caret.add(Caret586);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 615:24: -> LITERAL[\"^\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "^"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:616:4: QuestionMark
					{
					QuestionMark587=(Token)match(input,QuestionMark,FOLLOW_QuestionMark_in_cc_literal4781); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionMark.add(QuestionMark587);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 616:24: -> LITERAL[\"?\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "?"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:617:4: Plus
					{
					Plus588=(Token)match(input,Plus,FOLLOW_Plus_in_cc_literal4798); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Plus.add(Plus588);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 617:24: -> LITERAL[\"+\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "+"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:618:4: Star
					{
					Star589=(Token)match(input,Star,FOLLOW_Star_in_cc_literal4823); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Star.add(Star589);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 618:24: -> LITERAL[\"*\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "*"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// PCRE.g:619:4: WordBoundary
					{
					WordBoundary590=(Token)match(input,WordBoundary,FOLLOW_WordBoundary_in_cc_literal4848); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_WordBoundary.add(WordBoundary590);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 619:24: -> LITERAL[\"\\u0008\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "\u0008"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// PCRE.g:620:4: EndOfSubjectOrLine
					{
					EndOfSubjectOrLine591=(Token)match(input,EndOfSubjectOrLine,FOLLOW_EndOfSubjectOrLine_in_cc_literal4866); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EndOfSubjectOrLine.add(EndOfSubjectOrLine591);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 620:24: -> LITERAL[\"$\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "$"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// PCRE.g:621:4: Pipe
					{
					Pipe592=(Token)match(input,Pipe,FOLLOW_Pipe_in_cc_literal4877); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Pipe.add(Pipe592);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 621:24: -> LITERAL[\"|\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "|"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 11 :
					// PCRE.g:622:4: OpenParen
					{
					OpenParen593=(Token)match(input,OpenParen,FOLLOW_OpenParen_in_cc_literal4902); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenParen.add(OpenParen593);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 622:24: -> LITERAL[\"(\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "("));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 12 :
					// PCRE.g:623:4: CloseParen
					{
					CloseParen594=(Token)match(input,CloseParen,FOLLOW_CloseParen_in_cc_literal4922); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseParen.add(CloseParen594);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 623:24: -> LITERAL[\")\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, ")"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 28, cc_literal_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "cc_literal"


	public static class shared_literal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "shared_literal"
	// PCRE.g:626:1: shared_literal : ( octal_char | letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] | BellChar -> LITERAL[$BellChar.text] | EscapeChar -> LITERAL[$EscapeChar.text] | FormFeed -> LITERAL[$FormFeed.text] | NewLine -> LITERAL[$NewLine.text] | CarriageReturn -> LITERAL[$CarriageReturn.text] | Tab -> LITERAL[$Tab.text] | HexChar -> LITERAL[$HexChar.text] | Quoted -> LITERAL[$Quoted.text] | BlockQuoted -> LITERAL[$BlockQuoted.text] | OpenBrace -> LITERAL[\"{\"] | CloseBrace -> LITERAL[\"}\"] | Comma -> LITERAL[\",\"] | Hyphen -> LITERAL[\"-\"] | LessThan -> LITERAL[\"<\"] | GreaterThan -> LITERAL[\">\"] | SingleQuote -> LITERAL[\"'\"] | Underscore -> LITERAL[\"_\"] | Colon -> LITERAL[\":\"] | Hash -> LITERAL[\"#\"] | Equals -> LITERAL[\"=\"] | Exclamation -> LITERAL[\"!\"] | Ampersand -> LITERAL[\"&\"] | OtherChar -> LITERAL[$OtherChar.text] );
	public final PCREParser.shared_literal_return shared_literal() throws RecognitionException {
		PCREParser.shared_literal_return retval = new PCREParser.shared_literal_return();
		retval.start = input.LT(1);
		int shared_literal_StartIndex = input.index();

		CommonTree root_0 = null;

		Token BellChar598=null;
		Token EscapeChar599=null;
		Token FormFeed600=null;
		Token NewLine601=null;
		Token CarriageReturn602=null;
		Token Tab603=null;
		Token HexChar604=null;
		Token Quoted605=null;
		Token BlockQuoted606=null;
		Token OpenBrace607=null;
		Token CloseBrace608=null;
		Token Comma609=null;
		Token Hyphen610=null;
		Token LessThan611=null;
		Token GreaterThan612=null;
		Token SingleQuote613=null;
		Token Underscore614=null;
		Token Colon615=null;
		Token Hash616=null;
		Token Equals617=null;
		Token Exclamation618=null;
		Token Ampersand619=null;
		Token OtherChar620=null;
		ParserRuleReturnScope octal_char595 =null;
		ParserRuleReturnScope letter596 =null;
		ParserRuleReturnScope digit597 =null;

		CommonTree BellChar598_tree=null;
		CommonTree EscapeChar599_tree=null;
		CommonTree FormFeed600_tree=null;
		CommonTree NewLine601_tree=null;
		CommonTree CarriageReturn602_tree=null;
		CommonTree Tab603_tree=null;
		CommonTree HexChar604_tree=null;
		CommonTree Quoted605_tree=null;
		CommonTree BlockQuoted606_tree=null;
		CommonTree OpenBrace607_tree=null;
		CommonTree CloseBrace608_tree=null;
		CommonTree Comma609_tree=null;
		CommonTree Hyphen610_tree=null;
		CommonTree LessThan611_tree=null;
		CommonTree GreaterThan612_tree=null;
		CommonTree SingleQuote613_tree=null;
		CommonTree Underscore614_tree=null;
		CommonTree Colon615_tree=null;
		CommonTree Hash616_tree=null;
		CommonTree Equals617_tree=null;
		CommonTree Exclamation618_tree=null;
		CommonTree Ampersand619_tree=null;
		CommonTree OtherChar620_tree=null;
		RewriteRuleTokenStream stream_NewLine=new RewriteRuleTokenStream(adaptor,"token NewLine");
		RewriteRuleTokenStream stream_HexChar=new RewriteRuleTokenStream(adaptor,"token HexChar");
		RewriteRuleTokenStream stream_Hyphen=new RewriteRuleTokenStream(adaptor,"token Hyphen");
		RewriteRuleTokenStream stream_OtherChar=new RewriteRuleTokenStream(adaptor,"token OtherChar");
		RewriteRuleTokenStream stream_OpenBrace=new RewriteRuleTokenStream(adaptor,"token OpenBrace");
		RewriteRuleTokenStream stream_CloseBrace=new RewriteRuleTokenStream(adaptor,"token CloseBrace");
		RewriteRuleTokenStream stream_Hash=new RewriteRuleTokenStream(adaptor,"token Hash");
		RewriteRuleTokenStream stream_FormFeed=new RewriteRuleTokenStream(adaptor,"token FormFeed");
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_LessThan=new RewriteRuleTokenStream(adaptor,"token LessThan");
		RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
		RewriteRuleTokenStream stream_Tab=new RewriteRuleTokenStream(adaptor,"token Tab");
		RewriteRuleTokenStream stream_Quoted=new RewriteRuleTokenStream(adaptor,"token Quoted");
		RewriteRuleTokenStream stream_GreaterThan=new RewriteRuleTokenStream(adaptor,"token GreaterThan");
		RewriteRuleTokenStream stream_CarriageReturn=new RewriteRuleTokenStream(adaptor,"token CarriageReturn");
		RewriteRuleTokenStream stream_SingleQuote=new RewriteRuleTokenStream(adaptor,"token SingleQuote");
		RewriteRuleTokenStream stream_BellChar=new RewriteRuleTokenStream(adaptor,"token BellChar");
		RewriteRuleTokenStream stream_Underscore=new RewriteRuleTokenStream(adaptor,"token Underscore");
		RewriteRuleTokenStream stream_Ampersand=new RewriteRuleTokenStream(adaptor,"token Ampersand");
		RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
		RewriteRuleTokenStream stream_Exclamation=new RewriteRuleTokenStream(adaptor,"token Exclamation");
		RewriteRuleTokenStream stream_EscapeChar=new RewriteRuleTokenStream(adaptor,"token EscapeChar");
		RewriteRuleTokenStream stream_BlockQuoted=new RewriteRuleTokenStream(adaptor,"token BlockQuoted");
		RewriteRuleSubtreeStream stream_letter=new RewriteRuleSubtreeStream(adaptor,"rule letter");
		RewriteRuleSubtreeStream stream_digit=new RewriteRuleSubtreeStream(adaptor,"rule digit");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }

			// PCRE.g:627:2: ( octal_char | letter -> LITERAL[$letter.text] | digit -> LITERAL[$digit.text] | BellChar -> LITERAL[$BellChar.text] | EscapeChar -> LITERAL[$EscapeChar.text] | FormFeed -> LITERAL[$FormFeed.text] | NewLine -> LITERAL[$NewLine.text] | CarriageReturn -> LITERAL[$CarriageReturn.text] | Tab -> LITERAL[$Tab.text] | HexChar -> LITERAL[$HexChar.text] | Quoted -> LITERAL[$Quoted.text] | BlockQuoted -> LITERAL[$BlockQuoted.text] | OpenBrace -> LITERAL[\"{\"] | CloseBrace -> LITERAL[\"}\"] | Comma -> LITERAL[\",\"] | Hyphen -> LITERAL[\"-\"] | LessThan -> LITERAL[\"<\"] | GreaterThan -> LITERAL[\">\"] | SingleQuote -> LITERAL[\"'\"] | Underscore -> LITERAL[\"_\"] | Colon -> LITERAL[\":\"] | Hash -> LITERAL[\"#\"] | Equals -> LITERAL[\"=\"] | Exclamation -> LITERAL[\"!\"] | Ampersand -> LITERAL[\"&\"] | OtherChar -> LITERAL[$OtherChar.text] )
			int alt44=26;
			switch ( input.LA(1) ) {
			case Backslash:
				{
				alt44=1;
				}
				break;
			case ALC:
			case AUC:
			case BLC:
			case BUC:
			case CLC:
			case CUC:
			case DLC:
			case DUC:
			case ELC:
			case EUC:
			case FLC:
			case FUC:
			case GLC:
			case GUC:
			case HLC:
			case HUC:
			case ILC:
			case IUC:
			case JLC:
			case JUC:
			case KLC:
			case KUC:
			case LLC:
			case LUC:
			case MLC:
			case MUC:
			case NLC:
			case NUC:
			case OLC:
			case OUC:
			case PLC:
			case PUC:
			case QLC:
			case QUC:
			case RLC:
			case RUC:
			case SLC:
			case SUC:
			case TLC:
			case TUC:
			case ULC:
			case UUC:
			case VLC:
			case VUC:
			case WLC:
			case WUC:
			case XLC:
			case XUC:
			case YLC:
			case YUC:
			case ZLC:
			case ZUC:
				{
				alt44=2;
				}
				break;
			case D0:
			case D1:
			case D2:
			case D3:
			case D4:
			case D5:
			case D6:
			case D7:
			case D8:
			case D9:
				{
				alt44=3;
				}
				break;
			case BellChar:
				{
				alt44=4;
				}
				break;
			case EscapeChar:
				{
				alt44=5;
				}
				break;
			case FormFeed:
				{
				alt44=6;
				}
				break;
			case NewLine:
				{
				alt44=7;
				}
				break;
			case CarriageReturn:
				{
				alt44=8;
				}
				break;
			case Tab:
				{
				alt44=9;
				}
				break;
			case HexChar:
				{
				alt44=10;
				}
				break;
			case Quoted:
				{
				alt44=11;
				}
				break;
			case BlockQuoted:
				{
				alt44=12;
				}
				break;
			case OpenBrace:
				{
				alt44=13;
				}
				break;
			case CloseBrace:
				{
				alt44=14;
				}
				break;
			case Comma:
				{
				alt44=15;
				}
				break;
			case Hyphen:
				{
				alt44=16;
				}
				break;
			case LessThan:
				{
				alt44=17;
				}
				break;
			case GreaterThan:
				{
				alt44=18;
				}
				break;
			case SingleQuote:
				{
				alt44=19;
				}
				break;
			case Underscore:
				{
				alt44=20;
				}
				break;
			case Colon:
				{
				alt44=21;
				}
				break;
			case Hash:
				{
				alt44=22;
				}
				break;
			case Equals:
				{
				alt44=23;
				}
				break;
			case Exclamation:
				{
				alt44=24;
				}
				break;
			case Ampersand:
				{
				alt44=25;
				}
				break;
			case OtherChar:
				{
				alt44=26;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// PCRE.g:627:4: octal_char
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_octal_char_in_shared_literal4947);
					octal_char595=octal_char();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, octal_char595.getTree());

					}
					break;
				case 2 :
					// PCRE.g:628:4: letter
					{
					pushFollow(FOLLOW_letter_in_shared_literal4952);
					letter596=letter();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_letter.add(letter596.getTree());
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 628:19: -> LITERAL[$letter.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (letter596!=null?input.toString(letter596.start,letter596.stop):null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// PCRE.g:629:4: digit
					{
					pushFollow(FOLLOW_digit_in_shared_literal4970);
					digit597=digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_digit.add(digit597.getTree());
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 629:19: -> LITERAL[$digit.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (digit597!=null?input.toString(digit597.start,digit597.stop):null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// PCRE.g:630:4: BellChar
					{
					BellChar598=(Token)match(input,BellChar,FOLLOW_BellChar_in_shared_literal4989); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BellChar.add(BellChar598);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 630:19: -> LITERAL[$BellChar.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (BellChar598!=null?BellChar598.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// PCRE.g:631:4: EscapeChar
					{
					EscapeChar599=(Token)match(input,EscapeChar,FOLLOW_EscapeChar_in_shared_literal5005); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EscapeChar.add(EscapeChar599);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 631:19: -> LITERAL[$EscapeChar.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (EscapeChar599!=null?EscapeChar599.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// PCRE.g:632:4: FormFeed
					{
					FormFeed600=(Token)match(input,FormFeed,FOLLOW_FormFeed_in_shared_literal5019); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FormFeed.add(FormFeed600);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 632:19: -> LITERAL[$FormFeed.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (FormFeed600!=null?FormFeed600.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// PCRE.g:633:4: NewLine
					{
					NewLine601=(Token)match(input,NewLine,FOLLOW_NewLine_in_shared_literal5035); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NewLine.add(NewLine601);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 633:19: -> LITERAL[$NewLine.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (NewLine601!=null?NewLine601.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// PCRE.g:634:4: CarriageReturn
					{
					CarriageReturn602=(Token)match(input,CarriageReturn,FOLLOW_CarriageReturn_in_shared_literal5052); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CarriageReturn.add(CarriageReturn602);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 634:19: -> LITERAL[$CarriageReturn.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (CarriageReturn602!=null?CarriageReturn602.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// PCRE.g:635:4: Tab
					{
					Tab603=(Token)match(input,Tab,FOLLOW_Tab_in_shared_literal5062); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Tab.add(Tab603);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 635:19: -> LITERAL[$Tab.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (Tab603!=null?Tab603.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// PCRE.g:636:4: HexChar
					{
					HexChar604=(Token)match(input,HexChar,FOLLOW_HexChar_in_shared_literal5083); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_HexChar.add(HexChar604);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 636:19: -> LITERAL[$HexChar.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (HexChar604!=null?HexChar604.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 11 :
					// PCRE.g:637:4: Quoted
					{
					Quoted605=(Token)match(input,Quoted,FOLLOW_Quoted_in_shared_literal5100); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Quoted.add(Quoted605);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 637:19: -> LITERAL[$Quoted.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (Quoted605!=null?Quoted605.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 12 :
					// PCRE.g:638:4: BlockQuoted
					{
					BlockQuoted606=(Token)match(input,BlockQuoted,FOLLOW_BlockQuoted_in_shared_literal5118); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BlockQuoted.add(BlockQuoted606);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 638:19: -> LITERAL[$BlockQuoted.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (BlockQuoted606!=null?BlockQuoted606.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 13 :
					// PCRE.g:639:4: OpenBrace
					{
					OpenBrace607=(Token)match(input,OpenBrace,FOLLOW_OpenBrace_in_shared_literal5131); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OpenBrace.add(OpenBrace607);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 639:19: -> LITERAL[\"{\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "{"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 14 :
					// PCRE.g:640:4: CloseBrace
					{
					CloseBrace608=(Token)match(input,CloseBrace,FOLLOW_CloseBrace_in_shared_literal5146); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CloseBrace.add(CloseBrace608);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 640:19: -> LITERAL[\"}\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "}"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 15 :
					// PCRE.g:641:4: Comma
					{
					Comma609=(Token)match(input,Comma,FOLLOW_Comma_in_shared_literal5160); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Comma.add(Comma609);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 641:19: -> LITERAL[\",\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, ","));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 16 :
					// PCRE.g:642:4: Hyphen
					{
					Hyphen610=(Token)match(input,Hyphen,FOLLOW_Hyphen_in_shared_literal5179); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hyphen.add(Hyphen610);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 642:19: -> LITERAL[\"-\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "-"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 17 :
					// PCRE.g:643:4: LessThan
					{
					LessThan611=(Token)match(input,LessThan,FOLLOW_LessThan_in_shared_literal5197); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LessThan.add(LessThan611);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 643:19: -> LITERAL[\"<\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "<"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 18 :
					// PCRE.g:644:4: GreaterThan
					{
					GreaterThan612=(Token)match(input,GreaterThan,FOLLOW_GreaterThan_in_shared_literal5213); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GreaterThan.add(GreaterThan612);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 644:19: -> LITERAL[\">\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, ">"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 19 :
					// PCRE.g:645:4: SingleQuote
					{
					SingleQuote613=(Token)match(input,SingleQuote,FOLLOW_SingleQuote_in_shared_literal5226); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SingleQuote.add(SingleQuote613);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 645:19: -> LITERAL[\"'\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "'"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 20 :
					// PCRE.g:646:4: Underscore
					{
					Underscore614=(Token)match(input,Underscore,FOLLOW_Underscore_in_shared_literal5239); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Underscore.add(Underscore614);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 646:19: -> LITERAL[\"_\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "_"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 21 :
					// PCRE.g:647:4: Colon
					{
					Colon615=(Token)match(input,Colon,FOLLOW_Colon_in_shared_literal5253); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Colon.add(Colon615);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 647:19: -> LITERAL[\":\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, ":"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 22 :
					// PCRE.g:648:4: Hash
					{
					Hash616=(Token)match(input,Hash,FOLLOW_Hash_in_shared_literal5272); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Hash.add(Hash616);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 648:19: -> LITERAL[\"#\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "#"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 23 :
					// PCRE.g:649:4: Equals
					{
					Equals617=(Token)match(input,Equals,FOLLOW_Equals_in_shared_literal5292); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Equals.add(Equals617);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 649:19: -> LITERAL[\"=\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "="));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 24 :
					// PCRE.g:650:4: Exclamation
					{
					Exclamation618=(Token)match(input,Exclamation,FOLLOW_Exclamation_in_shared_literal5310); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Exclamation.add(Exclamation618);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 650:19: -> LITERAL[\"!\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "!"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 25 :
					// PCRE.g:651:4: Ampersand
					{
					Ampersand619=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_shared_literal5323); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Ampersand.add(Ampersand619);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 651:19: -> LITERAL[\"&\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, "&"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 26 :
					// PCRE.g:652:4: OtherChar
					{
					OtherChar620=(Token)match(input,OtherChar,FOLLOW_OtherChar_in_shared_literal5338); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OtherChar.add(OtherChar620);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 652:19: -> LITERAL[$OtherChar.text]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, (OtherChar620!=null?OtherChar620.getText():null)));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 29, shared_literal_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "shared_literal"


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// PCRE.g:655:1: number : digits -> NUMBER[$digits.text] ;
	public final PCREParser.number_return number() throws RecognitionException {
		PCREParser.number_return retval = new PCREParser.number_return();
		retval.start = input.LT(1);
		int number_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope digits621 =null;

		RewriteRuleSubtreeStream stream_digits=new RewriteRuleSubtreeStream(adaptor,"rule digits");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }

			// PCRE.g:656:2: ( digits -> NUMBER[$digits.text] )
			// PCRE.g:656:4: digits
			{
			pushFollow(FOLLOW_digits_in_number5359);
			digits621=digits();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_digits.add(digits621.getTree());
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 656:11: -> NUMBER[$digits.text]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(NUMBER, (digits621!=null?input.toString(digits621.start,digits621.stop):null)));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 30, number_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "number"


	public static class octal_char_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "octal_char"
	// PCRE.g:659:1: octal_char : ( Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit | Backslash octal_digit octal_digit ) -> LITERAL[String.valueOf((char)Integer.parseInt($text.substring(1), 8))] ;
	public final PCREParser.octal_char_return octal_char() throws RecognitionException {
		PCREParser.octal_char_return retval = new PCREParser.octal_char_return();
		retval.start = input.LT(1);
		int octal_char_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Backslash622=null;
		Token D0623=null;
		Token D1624=null;
		Token D2625=null;
		Token D3626=null;
		Token Backslash629=null;
		ParserRuleReturnScope octal_digit627 =null;
		ParserRuleReturnScope octal_digit628 =null;
		ParserRuleReturnScope octal_digit630 =null;
		ParserRuleReturnScope octal_digit631 =null;

		CommonTree Backslash622_tree=null;
		CommonTree D0623_tree=null;
		CommonTree D1624_tree=null;
		CommonTree D2625_tree=null;
		CommonTree D3626_tree=null;
		CommonTree Backslash629_tree=null;
		RewriteRuleTokenStream stream_Backslash=new RewriteRuleTokenStream(adaptor,"token Backslash");
		RewriteRuleTokenStream stream_D0=new RewriteRuleTokenStream(adaptor,"token D0");
		RewriteRuleTokenStream stream_D1=new RewriteRuleTokenStream(adaptor,"token D1");
		RewriteRuleTokenStream stream_D2=new RewriteRuleTokenStream(adaptor,"token D2");
		RewriteRuleTokenStream stream_D3=new RewriteRuleTokenStream(adaptor,"token D3");
		RewriteRuleSubtreeStream stream_octal_digit=new RewriteRuleSubtreeStream(adaptor,"rule octal_digit");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }

			// PCRE.g:660:2: ( ( Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit | Backslash octal_digit octal_digit ) -> LITERAL[String.valueOf((char)Integer.parseInt($text.substring(1), 8))] )
			// PCRE.g:660:4: ( Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit | Backslash octal_digit octal_digit )
			{
			// PCRE.g:660:4: ( Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit | Backslash octal_digit octal_digit )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==Backslash) ) {
				switch ( input.LA(2) ) {
				case D0:
					{
					int LA46_2 = input.LA(3);
					if ( ((LA46_2 >= D0 && LA46_2 <= D7)) ) {
						int LA46_7 = input.LA(4);
						if ( ((LA46_7 >= D0 && LA46_7 <= D7)) ) {
							int LA46_8 = input.LA(5);
							if ( (synpred188_PCRE()) ) {
								alt46=1;
							}
							else if ( (true) ) {
								alt46=2;
							}

						}
						else if ( (LA46_7==EOF||LA46_7==ALC||LA46_7==AUC||LA46_7==Ampersand||(LA46_7 >= BLC && LA46_7 <= BlockQuoted)||LA46_7==CLC||(LA46_7 >= CUC && LA46_7 <= ControlChar)||(LA46_7 >= D8 && LA46_7 <= D9)||(LA46_7 >= DLC && LA46_7 <= ELC)||(LA46_7 >= EUC && LA46_7 <= GLC)||(LA46_7 >= GUC && LA46_7 <= HexChar)||(LA46_7 >= HorizontalWhiteSpace && LA46_7 <= KUC)||LA46_7==LLC||(LA46_7 >= LUC && LA46_7 <= MUC)||LA46_7==NLC||LA46_7==NUC||(LA46_7 >= NamedReferenceStartK && LA46_7 <= NewLineSequence)||(LA46_7 >= NonWordBoundary && LA46_7 <= OLC)||LA46_7==OUC||(LA46_7 >= OneDataUnit && LA46_7 <= POSIXNegatedNamedSet)||(LA46_7 >= PUC && LA46_7 <= QLC)||(LA46_7 >= QUC && LA46_7 <= Quoted)||(LA46_7 >= RLC && LA46_7 <= ResetStartMatch)||LA46_7==SLC||(LA46_7 >= SUC && LA46_7 <= ULC)||(LA46_7 >= UUC && LA46_7 <= Underscore)||(LA46_7 >= VLC && LA46_7 <= XUC)||(LA46_7 >= YLC && LA46_7 <= ZUC)) ) {
							alt46=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 46, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D1:
					{
					int LA46_3 = input.LA(3);
					if ( ((LA46_3 >= D0 && LA46_3 <= D7)) ) {
						int LA46_7 = input.LA(4);
						if ( ((LA46_7 >= D0 && LA46_7 <= D7)) ) {
							int LA46_8 = input.LA(5);
							if ( (synpred188_PCRE()) ) {
								alt46=1;
							}
							else if ( (true) ) {
								alt46=2;
							}

						}
						else if ( (LA46_7==EOF||LA46_7==ALC||LA46_7==AUC||LA46_7==Ampersand||(LA46_7 >= BLC && LA46_7 <= BlockQuoted)||LA46_7==CLC||(LA46_7 >= CUC && LA46_7 <= ControlChar)||(LA46_7 >= D8 && LA46_7 <= D9)||(LA46_7 >= DLC && LA46_7 <= ELC)||(LA46_7 >= EUC && LA46_7 <= GLC)||(LA46_7 >= GUC && LA46_7 <= HexChar)||(LA46_7 >= HorizontalWhiteSpace && LA46_7 <= KUC)||LA46_7==LLC||(LA46_7 >= LUC && LA46_7 <= MUC)||LA46_7==NLC||LA46_7==NUC||(LA46_7 >= NamedReferenceStartK && LA46_7 <= NewLineSequence)||(LA46_7 >= NonWordBoundary && LA46_7 <= OLC)||LA46_7==OUC||(LA46_7 >= OneDataUnit && LA46_7 <= POSIXNegatedNamedSet)||(LA46_7 >= PUC && LA46_7 <= QLC)||(LA46_7 >= QUC && LA46_7 <= Quoted)||(LA46_7 >= RLC && LA46_7 <= ResetStartMatch)||LA46_7==SLC||(LA46_7 >= SUC && LA46_7 <= ULC)||(LA46_7 >= UUC && LA46_7 <= Underscore)||(LA46_7 >= VLC && LA46_7 <= XUC)||(LA46_7 >= YLC && LA46_7 <= ZUC)) ) {
							alt46=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 46, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D2:
					{
					int LA46_4 = input.LA(3);
					if ( ((LA46_4 >= D0 && LA46_4 <= D7)) ) {
						int LA46_7 = input.LA(4);
						if ( ((LA46_7 >= D0 && LA46_7 <= D7)) ) {
							int LA46_8 = input.LA(5);
							if ( (synpred188_PCRE()) ) {
								alt46=1;
							}
							else if ( (true) ) {
								alt46=2;
							}

						}
						else if ( (LA46_7==EOF||LA46_7==ALC||LA46_7==AUC||LA46_7==Ampersand||(LA46_7 >= BLC && LA46_7 <= BlockQuoted)||LA46_7==CLC||(LA46_7 >= CUC && LA46_7 <= ControlChar)||(LA46_7 >= D8 && LA46_7 <= D9)||(LA46_7 >= DLC && LA46_7 <= ELC)||(LA46_7 >= EUC && LA46_7 <= GLC)||(LA46_7 >= GUC && LA46_7 <= HexChar)||(LA46_7 >= HorizontalWhiteSpace && LA46_7 <= KUC)||LA46_7==LLC||(LA46_7 >= LUC && LA46_7 <= MUC)||LA46_7==NLC||LA46_7==NUC||(LA46_7 >= NamedReferenceStartK && LA46_7 <= NewLineSequence)||(LA46_7 >= NonWordBoundary && LA46_7 <= OLC)||LA46_7==OUC||(LA46_7 >= OneDataUnit && LA46_7 <= POSIXNegatedNamedSet)||(LA46_7 >= PUC && LA46_7 <= QLC)||(LA46_7 >= QUC && LA46_7 <= Quoted)||(LA46_7 >= RLC && LA46_7 <= ResetStartMatch)||LA46_7==SLC||(LA46_7 >= SUC && LA46_7 <= ULC)||(LA46_7 >= UUC && LA46_7 <= Underscore)||(LA46_7 >= VLC && LA46_7 <= XUC)||(LA46_7 >= YLC && LA46_7 <= ZUC)) ) {
							alt46=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 46, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D3:
					{
					int LA46_5 = input.LA(3);
					if ( ((LA46_5 >= D0 && LA46_5 <= D7)) ) {
						int LA46_7 = input.LA(4);
						if ( ((LA46_7 >= D0 && LA46_7 <= D7)) ) {
							int LA46_8 = input.LA(5);
							if ( (synpred188_PCRE()) ) {
								alt46=1;
							}
							else if ( (true) ) {
								alt46=2;
							}

						}
						else if ( (LA46_7==EOF||LA46_7==ALC||LA46_7==AUC||LA46_7==Ampersand||(LA46_7 >= BLC && LA46_7 <= BlockQuoted)||LA46_7==CLC||(LA46_7 >= CUC && LA46_7 <= ControlChar)||(LA46_7 >= D8 && LA46_7 <= D9)||(LA46_7 >= DLC && LA46_7 <= ELC)||(LA46_7 >= EUC && LA46_7 <= GLC)||(LA46_7 >= GUC && LA46_7 <= HexChar)||(LA46_7 >= HorizontalWhiteSpace && LA46_7 <= KUC)||LA46_7==LLC||(LA46_7 >= LUC && LA46_7 <= MUC)||LA46_7==NLC||LA46_7==NUC||(LA46_7 >= NamedReferenceStartK && LA46_7 <= NewLineSequence)||(LA46_7 >= NonWordBoundary && LA46_7 <= OLC)||LA46_7==OUC||(LA46_7 >= OneDataUnit && LA46_7 <= POSIXNegatedNamedSet)||(LA46_7 >= PUC && LA46_7 <= QLC)||(LA46_7 >= QUC && LA46_7 <= Quoted)||(LA46_7 >= RLC && LA46_7 <= ResetStartMatch)||LA46_7==SLC||(LA46_7 >= SUC && LA46_7 <= ULC)||(LA46_7 >= UUC && LA46_7 <= Underscore)||(LA46_7 >= VLC && LA46_7 <= XUC)||(LA46_7 >= YLC && LA46_7 <= ZUC)) ) {
							alt46=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 46, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 46, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case D4:
				case D5:
				case D6:
				case D7:
					{
					alt46=2;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 46, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// PCRE.g:660:6: Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit
					{
					Backslash622=(Token)match(input,Backslash,FOLLOW_Backslash_in_octal_char5377); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Backslash.add(Backslash622);

					// PCRE.g:660:16: ( D0 | D1 | D2 | D3 )
					int alt45=4;
					switch ( input.LA(1) ) {
					case D0:
						{
						alt45=1;
						}
						break;
					case D1:
						{
						alt45=2;
						}
						break;
					case D2:
						{
						alt45=3;
						}
						break;
					case D3:
						{
						alt45=4;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 45, 0, input);
						throw nvae;
					}
					switch (alt45) {
						case 1 :
							// PCRE.g:660:17: D0
							{
							D0623=(Token)match(input,D0,FOLLOW_D0_in_octal_char5380); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_D0.add(D0623);

							}
							break;
						case 2 :
							// PCRE.g:660:22: D1
							{
							D1624=(Token)match(input,D1,FOLLOW_D1_in_octal_char5384); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_D1.add(D1624);

							}
							break;
						case 3 :
							// PCRE.g:660:27: D2
							{
							D2625=(Token)match(input,D2,FOLLOW_D2_in_octal_char5388); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_D2.add(D2625);

							}
							break;
						case 4 :
							// PCRE.g:660:32: D3
							{
							D3626=(Token)match(input,D3,FOLLOW_D3_in_octal_char5392); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_D3.add(D3626);

							}
							break;

					}

					pushFollow(FOLLOW_octal_digit_in_octal_char5395);
					octal_digit627=octal_digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_octal_digit.add(octal_digit627.getTree());
					pushFollow(FOLLOW_octal_digit_in_octal_char5397);
					octal_digit628=octal_digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_octal_digit.add(octal_digit628.getTree());
					}
					break;
				case 2 :
					// PCRE.g:661:6: Backslash octal_digit octal_digit
					{
					Backslash629=(Token)match(input,Backslash,FOLLOW_Backslash_in_octal_char5404); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Backslash.add(Backslash629);

					pushFollow(FOLLOW_octal_digit_in_octal_char5406);
					octal_digit630=octal_digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_octal_digit.add(octal_digit630.getTree());
					pushFollow(FOLLOW_octal_digit_in_octal_char5408);
					octal_digit631=octal_digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_octal_digit.add(octal_digit631.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 663:4: -> LITERAL[String.valueOf((char)Integer.parseInt($text.substring(1), 8))]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(LITERAL, String.valueOf((char)Integer.parseInt(input.toString(retval.start,input.LT(-1)).substring(1), 8))));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 31, octal_char_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "octal_char"


	public static class octal_digit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "octal_digit"
	// PCRE.g:666:1: octal_digit : ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 );
	public final PCREParser.octal_digit_return octal_digit() throws RecognitionException {
		PCREParser.octal_digit_return retval = new PCREParser.octal_digit_return();
		retval.start = input.LT(1);
		int octal_digit_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set632=null;

		CommonTree set632_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

			// PCRE.g:667:2: ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 )
			// PCRE.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set632=input.LT(1);
			if ( (input.LA(1) >= D0 && input.LA(1) <= D7) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set632));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 32, octal_digit_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "octal_digit"


	public static class digits_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "digits"
	// PCRE.g:670:1: digits : ( digit )+ ;
	public final PCREParser.digits_return digits() throws RecognitionException {
		PCREParser.digits_return retval = new PCREParser.digits_return();
		retval.start = input.LT(1);
		int digits_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope digit633 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }

			// PCRE.g:671:2: ( ( digit )+ )
			// PCRE.g:671:4: ( digit )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// PCRE.g:671:4: ( digit )+
			int cnt47=0;
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( ((LA47_0 >= D0 && LA47_0 <= D9)) ) {
					int LA47_2 = input.LA(2);
					if ( (synpred196_PCRE()) ) {
						alt47=1;
					}

				}

				switch (alt47) {
				case 1 :
					// PCRE.g:671:4: digit
					{
					pushFollow(FOLLOW_digit_in_digits5493);
					digit633=digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, digit633.getTree());

					}
					break;

				default :
					if ( cnt47 >= 1 ) break loop47;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(47, input);
					throw eee;
				}
				cnt47++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 33, digits_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "digits"


	public static class digit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "digit"
	// PCRE.g:674:1: digit : ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 );
	public final PCREParser.digit_return digit() throws RecognitionException {
		PCREParser.digit_return retval = new PCREParser.digit_return();
		retval.start = input.LT(1);
		int digit_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set634=null;

		CommonTree set634_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }

			// PCRE.g:675:2: ( D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 )
			// PCRE.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set634=input.LT(1);
			if ( (input.LA(1) >= D0 && input.LA(1) <= D9) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set634));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 34, digit_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "digit"


	public static class name_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "name"
	// PCRE.g:678:1: name : alpha_nums -> NAME[$alpha_nums.text] ;
	public final PCREParser.name_return name() throws RecognitionException {
		PCREParser.name_return retval = new PCREParser.name_return();
		retval.start = input.LT(1);
		int name_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope alpha_nums635 =null;

		RewriteRuleSubtreeStream stream_alpha_nums=new RewriteRuleSubtreeStream(adaptor,"rule alpha_nums");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }

			// PCRE.g:679:2: ( alpha_nums -> NAME[$alpha_nums.text] )
			// PCRE.g:679:4: alpha_nums
			{
			pushFollow(FOLLOW_alpha_nums_in_name5552);
			alpha_nums635=alpha_nums();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_alpha_nums.add(alpha_nums635.getTree());
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 679:15: -> NAME[$alpha_nums.text]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(NAME, (alpha_nums635!=null?input.toString(alpha_nums635.start,alpha_nums635.stop):null)));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 35, name_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "name"


	public static class alpha_nums_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alpha_nums"
	// PCRE.g:682:1: alpha_nums : ( letter | Underscore ) ( letter | Underscore | digit )* ;
	public final PCREParser.alpha_nums_return alpha_nums() throws RecognitionException {
		PCREParser.alpha_nums_return retval = new PCREParser.alpha_nums_return();
		retval.start = input.LT(1);
		int alpha_nums_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Underscore637=null;
		Token Underscore639=null;
		ParserRuleReturnScope letter636 =null;
		ParserRuleReturnScope letter638 =null;
		ParserRuleReturnScope digit640 =null;

		CommonTree Underscore637_tree=null;
		CommonTree Underscore639_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }

			// PCRE.g:683:2: ( ( letter | Underscore ) ( letter | Underscore | digit )* )
			// PCRE.g:683:4: ( letter | Underscore ) ( letter | Underscore | digit )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// PCRE.g:683:4: ( letter | Underscore )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==ALC||LA48_0==AUC||(LA48_0 >= BLC && LA48_0 <= BUC)||LA48_0==CLC||LA48_0==CUC||(LA48_0 >= DLC && LA48_0 <= DUC)||LA48_0==ELC||LA48_0==EUC||(LA48_0 >= FLC && LA48_0 <= FUC)||LA48_0==GLC||LA48_0==GUC||(LA48_0 >= HLC && LA48_0 <= HUC)||(LA48_0 >= ILC && LA48_0 <= KUC)||LA48_0==LLC||LA48_0==LUC||(LA48_0 >= MLC && LA48_0 <= MUC)||LA48_0==NLC||LA48_0==NUC||LA48_0==OLC||LA48_0==OUC||LA48_0==PLC||LA48_0==PUC||LA48_0==QLC||LA48_0==QUC||(LA48_0 >= RLC && LA48_0 <= RUC)||LA48_0==SLC||LA48_0==SUC||(LA48_0 >= TLC && LA48_0 <= TUC)||LA48_0==ULC||LA48_0==UUC||(LA48_0 >= VLC && LA48_0 <= VUC)||(LA48_0 >= WLC && LA48_0 <= WUC)||(LA48_0 >= XLC && LA48_0 <= XUC)||(LA48_0 >= YLC && LA48_0 <= ZUC)) ) {
				alt48=1;
			}
			else if ( (LA48_0==Underscore) ) {
				alt48=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// PCRE.g:683:5: letter
					{
					pushFollow(FOLLOW_letter_in_alpha_nums5569);
					letter636=letter();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, letter636.getTree());

					}
					break;
				case 2 :
					// PCRE.g:683:14: Underscore
					{
					Underscore637=(Token)match(input,Underscore,FOLLOW_Underscore_in_alpha_nums5573); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Underscore637_tree = (CommonTree)adaptor.create(Underscore637);
					adaptor.addChild(root_0, Underscore637_tree);
					}

					}
					break;

			}

			// PCRE.g:683:26: ( letter | Underscore | digit )*
			loop49:
			while (true) {
				int alt49=4;
				switch ( input.LA(1) ) {
				case ALC:
				case AUC:
				case BLC:
				case BUC:
				case CLC:
				case CUC:
				case DLC:
				case DUC:
				case ELC:
				case EUC:
				case FLC:
				case FUC:
				case GLC:
				case GUC:
				case HLC:
				case HUC:
				case ILC:
				case IUC:
				case JLC:
				case JUC:
				case KLC:
				case KUC:
				case LLC:
				case LUC:
				case MLC:
				case MUC:
				case NLC:
				case NUC:
				case OLC:
				case OUC:
				case PLC:
				case PUC:
				case QLC:
				case QUC:
				case RLC:
				case RUC:
				case SLC:
				case SUC:
				case TLC:
				case TUC:
				case ULC:
				case UUC:
				case VLC:
				case VUC:
				case WLC:
				case WUC:
				case XLC:
				case XUC:
				case YLC:
				case YUC:
				case ZLC:
				case ZUC:
					{
					alt49=1;
					}
					break;
				case Underscore:
					{
					alt49=2;
					}
					break;
				case D0:
				case D1:
				case D2:
				case D3:
				case D4:
				case D5:
				case D6:
				case D7:
				case D8:
				case D9:
					{
					alt49=3;
					}
					break;
				}
				switch (alt49) {
				case 1 :
					// PCRE.g:683:27: letter
					{
					pushFollow(FOLLOW_letter_in_alpha_nums5577);
					letter638=letter();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, letter638.getTree());

					}
					break;
				case 2 :
					// PCRE.g:683:36: Underscore
					{
					Underscore639=(Token)match(input,Underscore,FOLLOW_Underscore_in_alpha_nums5581); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Underscore639_tree = (CommonTree)adaptor.create(Underscore639);
					adaptor.addChild(root_0, Underscore639_tree);
					}

					}
					break;
				case 3 :
					// PCRE.g:683:49: digit
					{
					pushFollow(FOLLOW_digit_in_alpha_nums5585);
					digit640=digit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, digit640.getTree());

					}
					break;

				default :
					break loop49;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 36, alpha_nums_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "alpha_nums"


	public static class non_close_parens_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "non_close_parens"
	// PCRE.g:686:1: non_close_parens : ( non_close_paren )+ ;
	public final PCREParser.non_close_parens_return non_close_parens() throws RecognitionException {
		PCREParser.non_close_parens_return retval = new PCREParser.non_close_parens_return();
		retval.start = input.LT(1);
		int non_close_parens_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope non_close_paren641 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }

			// PCRE.g:687:2: ( ( non_close_paren )+ )
			// PCRE.g:687:4: ( non_close_paren )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// PCRE.g:687:4: ( non_close_paren )+
			int cnt50=0;
			loop50:
			while (true) {
				int alt50=2;
				int LA50_0 = input.LA(1);
				if ( ((LA50_0 >= ALC && LA50_0 <= CloseBrace)||(LA50_0 >= Colon && LA50_0 <= ZUC)) ) {
					alt50=1;
				}

				switch (alt50) {
				case 1 :
					// PCRE.g:687:4: non_close_paren
					{
					pushFollow(FOLLOW_non_close_paren_in_non_close_parens5598);
					non_close_paren641=non_close_paren();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, non_close_paren641.getTree());

					}
					break;

				default :
					if ( cnt50 >= 1 ) break loop50;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(50, input);
					throw eee;
				}
				cnt50++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 37, non_close_parens_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "non_close_parens"


	public static class non_close_paren_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "non_close_paren"
	// PCRE.g:690:1: non_close_paren : ~ CloseParen ;
	public final PCREParser.non_close_paren_return non_close_paren() throws RecognitionException {
		PCREParser.non_close_paren_return retval = new PCREParser.non_close_paren_return();
		retval.start = input.LT(1);
		int non_close_paren_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set642=null;

		CommonTree set642_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }

			// PCRE.g:691:2: (~ CloseParen )
			// PCRE.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set642=input.LT(1);
			if ( (input.LA(1) >= ALC && input.LA(1) <= CloseBrace)||(input.LA(1) >= Colon && input.LA(1) <= ZUC) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set642));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 38, non_close_paren_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "non_close_paren"


	public static class letter_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "letter"
	// PCRE.g:694:1: letter : ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC );
	public final PCREParser.letter_return letter() throws RecognitionException {
		PCREParser.letter_return retval = new PCREParser.letter_return();
		retval.start = input.LT(1);
		int letter_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set643=null;

		CommonTree set643_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }

			// PCRE.g:695:2: ( ALC | BLC | CLC | DLC | ELC | FLC | GLC | HLC | ILC | JLC | KLC | LLC | MLC | NLC | OLC | PLC | QLC | RLC | SLC | TLC | ULC | VLC | WLC | XLC | YLC | ZLC | AUC | BUC | CUC | DUC | EUC | FUC | GUC | HUC | IUC | JUC | KUC | LUC | MUC | NUC | OUC | PUC | QUC | RUC | SUC | TUC | UUC | VUC | WUC | XUC | YUC | ZUC )
			// PCRE.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set643=input.LT(1);
			if ( input.LA(1)==ALC||input.LA(1)==AUC||(input.LA(1) >= BLC && input.LA(1) <= BUC)||input.LA(1)==CLC||input.LA(1)==CUC||(input.LA(1) >= DLC && input.LA(1) <= DUC)||input.LA(1)==ELC||input.LA(1)==EUC||(input.LA(1) >= FLC && input.LA(1) <= FUC)||input.LA(1)==GLC||input.LA(1)==GUC||(input.LA(1) >= HLC && input.LA(1) <= HUC)||(input.LA(1) >= ILC && input.LA(1) <= KUC)||input.LA(1)==LLC||input.LA(1)==LUC||(input.LA(1) >= MLC && input.LA(1) <= MUC)||input.LA(1)==NLC||input.LA(1)==NUC||input.LA(1)==OLC||input.LA(1)==OUC||input.LA(1)==PLC||input.LA(1)==PUC||input.LA(1)==QLC||input.LA(1)==QUC||(input.LA(1) >= RLC && input.LA(1) <= RUC)||input.LA(1)==SLC||input.LA(1)==SUC||(input.LA(1) >= TLC && input.LA(1) <= TUC)||input.LA(1)==ULC||input.LA(1)==UUC||(input.LA(1) >= VLC && input.LA(1) <= VUC)||(input.LA(1) >= WLC && input.LA(1) <= WUC)||(input.LA(1) >= XLC && input.LA(1) <= XUC)||(input.LA(1) >= YLC && input.LA(1) <= ZUC) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set643));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 39, letter_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "letter"

	// $ANTLR start synpred1_PCRE
	public final void synpred1_PCRE_fragment() throws RecognitionException {
		// PCRE.g:213:47: ( '|' alternative )
		// PCRE.g:213:47: '|' alternative
		{
		match(input,Pipe,FOLLOW_Pipe_in_synpred1_PCRE507); if (state.failed) return;

		pushFollow(FOLLOW_alternative_in_synpred1_PCRE509);
		alternative();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_PCRE

	// $ANTLR start synpred2_PCRE
	public final void synpred2_PCRE_fragment() throws RecognitionException {
		// PCRE.g:213:46: ( ( '|' alternative )+ )
		// PCRE.g:213:46: ( '|' alternative )+
		{
		// PCRE.g:213:46: ( '|' alternative )+
		int cnt51=0;
		loop51:
		while (true) {
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==Pipe) ) {
				alt51=1;
			}

			switch (alt51) {
			case 1 :
				// PCRE.g:213:47: '|' alternative
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred2_PCRE507); if (state.failed) return;

				pushFollow(FOLLOW_alternative_in_synpred2_PCRE509);
				alternative();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt51 >= 1 ) break loop51;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(51, input);
				throw eee;
			}
			cnt51++;
		}

		}

	}
	// $ANTLR end synpred2_PCRE

	// $ANTLR start synpred4_PCRE
	public final void synpred4_PCRE_fragment() throws RecognitionException {
		// PCRE.g:225:9: ( quantifier )
		// PCRE.g:225:9: quantifier
		{
		pushFollow(FOLLOW_quantifier_in_synpred4_PCRE569);
		quantifier();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_PCRE

	// $ANTLR start synpred13_PCRE
	public final void synpred13_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope a =null;


		// PCRE.g:288:4: ( '[' '^' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']' )
		// PCRE.g:288:4: '[' '^' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']'
		{
		match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_synpred13_PCRE968); if (state.failed) return;

		match(input,Caret,FOLLOW_Caret_in_synpred13_PCRE972); if (state.failed) return;

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred13_PCRE974); if (state.failed) return;

		match(input,Hyphen,FOLLOW_Hyphen_in_synpred13_PCRE976); if (state.failed) return;

		pushFollow(FOLLOW_cc_atom_end_range_in_synpred13_PCRE980);
		a=cc_atom_end_range();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:288:86: ( cc_atom )*
		loop52:
		while (true) {
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==ALC||LA52_0==AUC||LA52_0==Ampersand||(LA52_0 >= BLC && LA52_0 <= BlockQuoted)||LA52_0==CLC||(LA52_0 >= CUC && LA52_0 <= CharWithoutProperty)||(LA52_0 >= CharacterClassStart && LA52_0 <= D9)||(LA52_0 >= DLC && LA52_0 <= ELC)||LA52_0==EUC||LA52_0==EndOfSubjectOrLine||(LA52_0 >= Equals && LA52_0 <= Exclamation)||(LA52_0 >= FLC && LA52_0 <= GLC)||(LA52_0 >= GUC && LA52_0 <= HexChar)||(LA52_0 >= HorizontalWhiteSpace && LA52_0 <= KUC)||LA52_0==LLC||(LA52_0 >= LUC && LA52_0 <= MUC)||LA52_0==NLC||LA52_0==NUC||(LA52_0 >= NewLine && LA52_0 <= NewLineSequence)||(LA52_0 >= NotDecimalDigit && LA52_0 <= OLC)||LA52_0==OUC||(LA52_0 >= OpenBrace && LA52_0 <= POSIXNegatedNamedSet)||(LA52_0 >= PUC && LA52_0 <= Plus)||LA52_0==QLC||(LA52_0 >= QUC && LA52_0 <= Quoted)||(LA52_0 >= RLC && LA52_0 <= RUC)||LA52_0==SLC||(LA52_0 >= SUC && LA52_0 <= Star)||(LA52_0 >= TLC && LA52_0 <= ULC)||(LA52_0 >= UUC && LA52_0 <= Underscore)||(LA52_0 >= VLC && LA52_0 <= XUC)||(LA52_0 >= YLC && LA52_0 <= ZUC)) ) {
				alt52=1;
			}

			switch (alt52) {
			case 1 :
				// PCRE.g:288:86: cc_atom
				{
				pushFollow(FOLLOW_cc_atom_in_synpred13_PCRE982);
				cc_atom();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop52;
			}
		}

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred13_PCRE985); if (state.failed) return;

		}

	}
	// $ANTLR end synpred13_PCRE

	// $ANTLR start synpred15_PCRE
	public final void synpred15_PCRE_fragment() throws RecognitionException {
		// PCRE.g:289:4: ( '[' '^' CharacterClassEnd ( cc_atom )* ']' )
		// PCRE.g:289:4: '[' '^' CharacterClassEnd ( cc_atom )* ']'
		{
		match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_synpred15_PCRE1010); if (state.failed) return;

		match(input,Caret,FOLLOW_Caret_in_synpred15_PCRE1014); if (state.failed) return;

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred15_PCRE1016); if (state.failed) return;

		// PCRE.g:289:59: ( cc_atom )*
		loop53:
		while (true) {
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==ALC||LA53_0==AUC||LA53_0==Ampersand||(LA53_0 >= BLC && LA53_0 <= BlockQuoted)||LA53_0==CLC||(LA53_0 >= CUC && LA53_0 <= CharWithoutProperty)||(LA53_0 >= CharacterClassStart && LA53_0 <= D9)||(LA53_0 >= DLC && LA53_0 <= ELC)||LA53_0==EUC||LA53_0==EndOfSubjectOrLine||(LA53_0 >= Equals && LA53_0 <= Exclamation)||(LA53_0 >= FLC && LA53_0 <= GLC)||(LA53_0 >= GUC && LA53_0 <= HexChar)||(LA53_0 >= HorizontalWhiteSpace && LA53_0 <= KUC)||LA53_0==LLC||(LA53_0 >= LUC && LA53_0 <= MUC)||LA53_0==NLC||LA53_0==NUC||(LA53_0 >= NewLine && LA53_0 <= NewLineSequence)||(LA53_0 >= NotDecimalDigit && LA53_0 <= OLC)||LA53_0==OUC||(LA53_0 >= OpenBrace && LA53_0 <= POSIXNegatedNamedSet)||(LA53_0 >= PUC && LA53_0 <= Plus)||LA53_0==QLC||(LA53_0 >= QUC && LA53_0 <= Quoted)||(LA53_0 >= RLC && LA53_0 <= RUC)||LA53_0==SLC||(LA53_0 >= SUC && LA53_0 <= Star)||(LA53_0 >= TLC && LA53_0 <= ULC)||(LA53_0 >= UUC && LA53_0 <= Underscore)||(LA53_0 >= VLC && LA53_0 <= XUC)||(LA53_0 >= YLC && LA53_0 <= ZUC)) ) {
				alt53=1;
			}

			switch (alt53) {
			case 1 :
				// PCRE.g:289:59: cc_atom
				{
				pushFollow(FOLLOW_cc_atom_in_synpred15_PCRE1018);
				cc_atom();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop53;
			}
		}

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred15_PCRE1021); if (state.failed) return;

		}

	}
	// $ANTLR end synpred15_PCRE

	// $ANTLR start synpred17_PCRE
	public final void synpred17_PCRE_fragment() throws RecognitionException {
		// PCRE.g:290:4: ( '[' '^' ( cc_atom )+ ']' )
		// PCRE.g:290:4: '[' '^' ( cc_atom )+ ']'
		{
		match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_synpred17_PCRE1067); if (state.failed) return;

		match(input,Caret,FOLLOW_Caret_in_synpred17_PCRE1071); if (state.failed) return;

		// PCRE.g:290:41: ( cc_atom )+
		int cnt54=0;
		loop54:
		while (true) {
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==ALC||LA54_0==AUC||LA54_0==Ampersand||(LA54_0 >= BLC && LA54_0 <= BlockQuoted)||LA54_0==CLC||(LA54_0 >= CUC && LA54_0 <= CharWithoutProperty)||(LA54_0 >= CharacterClassStart && LA54_0 <= D9)||(LA54_0 >= DLC && LA54_0 <= ELC)||LA54_0==EUC||LA54_0==EndOfSubjectOrLine||(LA54_0 >= Equals && LA54_0 <= Exclamation)||(LA54_0 >= FLC && LA54_0 <= GLC)||(LA54_0 >= GUC && LA54_0 <= HexChar)||(LA54_0 >= HorizontalWhiteSpace && LA54_0 <= KUC)||LA54_0==LLC||(LA54_0 >= LUC && LA54_0 <= MUC)||LA54_0==NLC||LA54_0==NUC||(LA54_0 >= NewLine && LA54_0 <= NewLineSequence)||(LA54_0 >= NotDecimalDigit && LA54_0 <= OLC)||LA54_0==OUC||(LA54_0 >= OpenBrace && LA54_0 <= POSIXNegatedNamedSet)||(LA54_0 >= PUC && LA54_0 <= Plus)||LA54_0==QLC||(LA54_0 >= QUC && LA54_0 <= Quoted)||(LA54_0 >= RLC && LA54_0 <= RUC)||LA54_0==SLC||(LA54_0 >= SUC && LA54_0 <= Star)||(LA54_0 >= TLC && LA54_0 <= ULC)||(LA54_0 >= UUC && LA54_0 <= Underscore)||(LA54_0 >= VLC && LA54_0 <= XUC)||(LA54_0 >= YLC && LA54_0 <= ZUC)) ) {
				alt54=1;
			}

			switch (alt54) {
			case 1 :
				// PCRE.g:290:41: cc_atom
				{
				pushFollow(FOLLOW_cc_atom_in_synpred17_PCRE1073);
				cc_atom();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt54 >= 1 ) break loop54;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(54, input);
				throw eee;
			}
			cnt54++;
		}

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred17_PCRE1076); if (state.failed) return;

		}

	}
	// $ANTLR end synpred17_PCRE

	// $ANTLR start synpred19_PCRE
	public final void synpred19_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope a =null;


		// PCRE.g:291:4: ( '[' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']' )
		// PCRE.g:291:4: '[' CharacterClassEnd Hyphen a= cc_atom_end_range ( cc_atom )* ']'
		{
		match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_synpred19_PCRE1137); if (state.failed) return;

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred19_PCRE1141); if (state.failed) return;

		match(input,Hyphen,FOLLOW_Hyphen_in_synpred19_PCRE1143); if (state.failed) return;

		pushFollow(FOLLOW_cc_atom_end_range_in_synpred19_PCRE1147);
		a=cc_atom_end_range();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:291:82: ( cc_atom )*
		loop55:
		while (true) {
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==ALC||LA55_0==AUC||LA55_0==Ampersand||(LA55_0 >= BLC && LA55_0 <= BlockQuoted)||LA55_0==CLC||(LA55_0 >= CUC && LA55_0 <= CharWithoutProperty)||(LA55_0 >= CharacterClassStart && LA55_0 <= D9)||(LA55_0 >= DLC && LA55_0 <= ELC)||LA55_0==EUC||LA55_0==EndOfSubjectOrLine||(LA55_0 >= Equals && LA55_0 <= Exclamation)||(LA55_0 >= FLC && LA55_0 <= GLC)||(LA55_0 >= GUC && LA55_0 <= HexChar)||(LA55_0 >= HorizontalWhiteSpace && LA55_0 <= KUC)||LA55_0==LLC||(LA55_0 >= LUC && LA55_0 <= MUC)||LA55_0==NLC||LA55_0==NUC||(LA55_0 >= NewLine && LA55_0 <= NewLineSequence)||(LA55_0 >= NotDecimalDigit && LA55_0 <= OLC)||LA55_0==OUC||(LA55_0 >= OpenBrace && LA55_0 <= POSIXNegatedNamedSet)||(LA55_0 >= PUC && LA55_0 <= Plus)||LA55_0==QLC||(LA55_0 >= QUC && LA55_0 <= Quoted)||(LA55_0 >= RLC && LA55_0 <= RUC)||LA55_0==SLC||(LA55_0 >= SUC && LA55_0 <= Star)||(LA55_0 >= TLC && LA55_0 <= ULC)||(LA55_0 >= UUC && LA55_0 <= Underscore)||(LA55_0 >= VLC && LA55_0 <= XUC)||(LA55_0 >= YLC && LA55_0 <= ZUC)) ) {
				alt55=1;
			}

			switch (alt55) {
			case 1 :
				// PCRE.g:291:82: cc_atom
				{
				pushFollow(FOLLOW_cc_atom_in_synpred19_PCRE1149);
				cc_atom();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop55;
			}
		}

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred19_PCRE1152); if (state.failed) return;

		}

	}
	// $ANTLR end synpred19_PCRE

	// $ANTLR start synpred21_PCRE
	public final void synpred21_PCRE_fragment() throws RecognitionException {
		// PCRE.g:292:4: ( '[' CharacterClassEnd ( cc_atom )* ']' )
		// PCRE.g:292:4: '[' CharacterClassEnd ( cc_atom )* ']'
		{
		match(input,CharacterClassStart,FOLLOW_CharacterClassStart_in_synpred21_PCRE1181); if (state.failed) return;

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred21_PCRE1185); if (state.failed) return;

		// PCRE.g:292:55: ( cc_atom )*
		loop56:
		while (true) {
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==ALC||LA56_0==AUC||LA56_0==Ampersand||(LA56_0 >= BLC && LA56_0 <= BlockQuoted)||LA56_0==CLC||(LA56_0 >= CUC && LA56_0 <= CharWithoutProperty)||(LA56_0 >= CharacterClassStart && LA56_0 <= D9)||(LA56_0 >= DLC && LA56_0 <= ELC)||LA56_0==EUC||LA56_0==EndOfSubjectOrLine||(LA56_0 >= Equals && LA56_0 <= Exclamation)||(LA56_0 >= FLC && LA56_0 <= GLC)||(LA56_0 >= GUC && LA56_0 <= HexChar)||(LA56_0 >= HorizontalWhiteSpace && LA56_0 <= KUC)||LA56_0==LLC||(LA56_0 >= LUC && LA56_0 <= MUC)||LA56_0==NLC||LA56_0==NUC||(LA56_0 >= NewLine && LA56_0 <= NewLineSequence)||(LA56_0 >= NotDecimalDigit && LA56_0 <= OLC)||LA56_0==OUC||(LA56_0 >= OpenBrace && LA56_0 <= POSIXNegatedNamedSet)||(LA56_0 >= PUC && LA56_0 <= Plus)||LA56_0==QLC||(LA56_0 >= QUC && LA56_0 <= Quoted)||(LA56_0 >= RLC && LA56_0 <= RUC)||LA56_0==SLC||(LA56_0 >= SUC && LA56_0 <= Star)||(LA56_0 >= TLC && LA56_0 <= ULC)||(LA56_0 >= UUC && LA56_0 <= Underscore)||(LA56_0 >= VLC && LA56_0 <= XUC)||(LA56_0 >= YLC && LA56_0 <= ZUC)) ) {
				alt56=1;
			}

			switch (alt56) {
			case 1 :
				// PCRE.g:292:55: cc_atom
				{
				pushFollow(FOLLOW_cc_atom_in_synpred21_PCRE1187);
				cc_atom();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop56;
			}
		}

		match(input,CharacterClassEnd,FOLLOW_CharacterClassEnd_in_synpred21_PCRE1190); if (state.failed) return;

		}

	}
	// $ANTLR end synpred21_PCRE

	// $ANTLR start synpred31_PCRE
	public final void synpred31_PCRE_fragment() throws RecognitionException {
		// PCRE.g:324:4: ( octal_char )
		// PCRE.g:324:4: octal_char
		{
		pushFollow(FOLLOW_octal_char_in_synpred31_PCRE1543);
		octal_char();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred31_PCRE

	// $ANTLR start synpred66_PCRE
	public final void synpred66_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:466:4: ( '(' '?' '(' number ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:466:4: '(' '?' '(' number ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred66_PCRE2833); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred66_PCRE2835); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred66_PCRE2837); if (state.failed) return;

		pushFollow(FOLLOW_number_in_synpred66_PCRE2839);
		number();
		state._fsp--;
		if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred66_PCRE2841); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred66_PCRE2845);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:466:35: ( '|' f= regex )?
		int alt57=2;
		int LA57_0 = input.LA(1);
		if ( (LA57_0==Pipe) ) {
			alt57=1;
		}
		switch (alt57) {
			case 1 :
				// PCRE.g:466:36: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred66_PCRE2848); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred66_PCRE2852);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred66_PCRE2856); if (state.failed) return;

		}

	}
	// $ANTLR end synpred66_PCRE

	// $ANTLR start synpred68_PCRE
	public final void synpred68_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:467:4: ( '(' '?' '(' '+' number ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:467:4: '(' '?' '(' '+' number ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred68_PCRE2901); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred68_PCRE2903); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred68_PCRE2905); if (state.failed) return;

		match(input,Plus,FOLLOW_Plus_in_synpred68_PCRE2907); if (state.failed) return;

		pushFollow(FOLLOW_number_in_synpred68_PCRE2909);
		number();
		state._fsp--;
		if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred68_PCRE2911); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred68_PCRE2915);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:467:39: ( '|' f= regex )?
		int alt58=2;
		int LA58_0 = input.LA(1);
		if ( (LA58_0==Pipe) ) {
			alt58=1;
		}
		switch (alt58) {
			case 1 :
				// PCRE.g:467:40: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred68_PCRE2918); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred68_PCRE2922);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred68_PCRE2926); if (state.failed) return;

		}

	}
	// $ANTLR end synpred68_PCRE

	// $ANTLR start synpred70_PCRE
	public final void synpred70_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:468:4: ( '(' '?' '(' '-' number ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:468:4: '(' '?' '(' '-' number ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred70_PCRE2967); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred70_PCRE2969); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred70_PCRE2971); if (state.failed) return;

		match(input,Hyphen,FOLLOW_Hyphen_in_synpred70_PCRE2973); if (state.failed) return;

		pushFollow(FOLLOW_number_in_synpred70_PCRE2975);
		number();
		state._fsp--;
		if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred70_PCRE2977); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred70_PCRE2981);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:468:39: ( '|' f= regex )?
		int alt59=2;
		int LA59_0 = input.LA(1);
		if ( (LA59_0==Pipe) ) {
			alt59=1;
		}
		switch (alt59) {
			case 1 :
				// PCRE.g:468:40: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred70_PCRE2984); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred70_PCRE2988);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred70_PCRE2992); if (state.failed) return;

		}

	}
	// $ANTLR end synpred70_PCRE

	// $ANTLR start synpred72_PCRE
	public final void synpred72_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:469:4: ( '(' '?' '(' '<' name '>' ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:469:4: '(' '?' '(' '<' name '>' ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred72_PCRE3033); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred72_PCRE3035); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred72_PCRE3037); if (state.failed) return;

		match(input,LessThan,FOLLOW_LessThan_in_synpred72_PCRE3039); if (state.failed) return;

		pushFollow(FOLLOW_name_in_synpred72_PCRE3041);
		name();
		state._fsp--;
		if (state.failed) return;

		match(input,GreaterThan,FOLLOW_GreaterThan_in_synpred72_PCRE3043); if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred72_PCRE3045); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred72_PCRE3049);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:469:41: ( '|' f= regex )?
		int alt60=2;
		int LA60_0 = input.LA(1);
		if ( (LA60_0==Pipe) ) {
			alt60=1;
		}
		switch (alt60) {
			case 1 :
				// PCRE.g:469:42: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred72_PCRE3052); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred72_PCRE3056);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred72_PCRE3060); if (state.failed) return;

		}

	}
	// $ANTLR end synpred72_PCRE

	// $ANTLR start synpred74_PCRE
	public final void synpred74_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:470:4: ( '(' '?' '(' '\\'' name '\\'' ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:470:4: '(' '?' '(' '\\'' name '\\'' ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred74_PCRE3099); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred74_PCRE3101); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred74_PCRE3103); if (state.failed) return;

		match(input,SingleQuote,FOLLOW_SingleQuote_in_synpred74_PCRE3105); if (state.failed) return;

		pushFollow(FOLLOW_name_in_synpred74_PCRE3107);
		name();
		state._fsp--;
		if (state.failed) return;

		match(input,SingleQuote,FOLLOW_SingleQuote_in_synpred74_PCRE3109); if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred74_PCRE3111); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred74_PCRE3115);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:470:43: ( '|' f= regex )?
		int alt61=2;
		int LA61_0 = input.LA(1);
		if ( (LA61_0==Pipe) ) {
			alt61=1;
		}
		switch (alt61) {
			case 1 :
				// PCRE.g:470:44: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred74_PCRE3118); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred74_PCRE3122);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred74_PCRE3126); if (state.failed) return;

		}

	}
	// $ANTLR end synpred74_PCRE

	// $ANTLR start synpred76_PCRE
	public final void synpred76_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:471:4: ( '(' '?' '(' 'R' number ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:471:4: '(' '?' '(' 'R' number ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred76_PCRE3163); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred76_PCRE3165); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred76_PCRE3167); if (state.failed) return;

		match(input,RUC,FOLLOW_RUC_in_synpred76_PCRE3169); if (state.failed) return;

		pushFollow(FOLLOW_number_in_synpred76_PCRE3171);
		number();
		state._fsp--;
		if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred76_PCRE3173); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred76_PCRE3177);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:471:39: ( '|' f= regex )?
		int alt62=2;
		int LA62_0 = input.LA(1);
		if ( (LA62_0==Pipe) ) {
			alt62=1;
		}
		switch (alt62) {
			case 1 :
				// PCRE.g:471:40: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred76_PCRE3180); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred76_PCRE3184);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred76_PCRE3188); if (state.failed) return;

		}

	}
	// $ANTLR end synpred76_PCRE

	// $ANTLR start synpred78_PCRE
	public final void synpred78_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:472:4: ( '(' '?' '(' 'R' ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:472:4: '(' '?' '(' 'R' ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred78_PCRE3229); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred78_PCRE3231); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred78_PCRE3233); if (state.failed) return;

		match(input,RUC,FOLLOW_RUC_in_synpred78_PCRE3235); if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred78_PCRE3237); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred78_PCRE3241);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:472:32: ( '|' f= regex )?
		int alt63=2;
		int LA63_0 = input.LA(1);
		if ( (LA63_0==Pipe) ) {
			alt63=1;
		}
		switch (alt63) {
			case 1 :
				// PCRE.g:472:33: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred78_PCRE3244); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred78_PCRE3248);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred78_PCRE3252); if (state.failed) return;

		}

	}
	// $ANTLR end synpred78_PCRE

	// $ANTLR start synpred80_PCRE
	public final void synpred80_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:473:4: ( '(' '?' '(' 'R' '&' name ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:473:4: '(' '?' '(' 'R' '&' name ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred80_PCRE3298); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred80_PCRE3300); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred80_PCRE3302); if (state.failed) return;

		match(input,RUC,FOLLOW_RUC_in_synpred80_PCRE3304); if (state.failed) return;

		match(input,Ampersand,FOLLOW_Ampersand_in_synpred80_PCRE3306); if (state.failed) return;

		pushFollow(FOLLOW_name_in_synpred80_PCRE3308);
		name();
		state._fsp--;
		if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred80_PCRE3310); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred80_PCRE3314);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:473:41: ( '|' f= regex )?
		int alt64=2;
		int LA64_0 = input.LA(1);
		if ( (LA64_0==Pipe) ) {
			alt64=1;
		}
		switch (alt64) {
			case 1 :
				// PCRE.g:473:42: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred80_PCRE3317); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred80_PCRE3321);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred80_PCRE3325); if (state.failed) return;

		}

	}
	// $ANTLR end synpred80_PCRE

	// $ANTLR start synpred82_PCRE
	public final void synpred82_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:474:4: ( '(' '?' '(' 'D' 'E' 'F' 'I' 'N' 'E' ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:474:4: '(' '?' '(' 'D' 'E' 'F' 'I' 'N' 'E' ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred82_PCRE3364); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred82_PCRE3366); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred82_PCRE3368); if (state.failed) return;

		match(input,DUC,FOLLOW_DUC_in_synpred82_PCRE3370); if (state.failed) return;

		match(input,EUC,FOLLOW_EUC_in_synpred82_PCRE3372); if (state.failed) return;

		match(input,FUC,FOLLOW_FUC_in_synpred82_PCRE3374); if (state.failed) return;

		match(input,IUC,FOLLOW_IUC_in_synpred82_PCRE3376); if (state.failed) return;

		match(input,NUC,FOLLOW_NUC_in_synpred82_PCRE3378); if (state.failed) return;

		match(input,EUC,FOLLOW_EUC_in_synpred82_PCRE3380); if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred82_PCRE3382); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred82_PCRE3386);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:474:52: ( '|' f= regex )?
		int alt65=2;
		int LA65_0 = input.LA(1);
		if ( (LA65_0==Pipe) ) {
			alt65=1;
		}
		switch (alt65) {
			case 1 :
				// PCRE.g:474:53: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred82_PCRE3389); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred82_PCRE3393);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred82_PCRE3397); if (state.failed) return;

		}

	}
	// $ANTLR end synpred82_PCRE

	// $ANTLR start synpred84_PCRE
	public final void synpred84_PCRE_fragment() throws RecognitionException {
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope f =null;


		// PCRE.g:475:4: ( '(' '?' '(' 'a' 's' 's' 'e' 'r' 't' ')' t= regex ( '|' f= regex )? ')' )
		// PCRE.g:475:4: '(' '?' '(' 'a' 's' 's' 'e' 'r' 't' ')' t= regex ( '|' f= regex )? ')'
		{
		match(input,OpenParen,FOLLOW_OpenParen_in_synpred84_PCRE3423); if (state.failed) return;

		match(input,QuestionMark,FOLLOW_QuestionMark_in_synpred84_PCRE3425); if (state.failed) return;

		match(input,OpenParen,FOLLOW_OpenParen_in_synpred84_PCRE3427); if (state.failed) return;

		match(input,ALC,FOLLOW_ALC_in_synpred84_PCRE3429); if (state.failed) return;

		match(input,SLC,FOLLOW_SLC_in_synpred84_PCRE3431); if (state.failed) return;

		match(input,SLC,FOLLOW_SLC_in_synpred84_PCRE3433); if (state.failed) return;

		match(input,ELC,FOLLOW_ELC_in_synpred84_PCRE3435); if (state.failed) return;

		match(input,RLC,FOLLOW_RLC_in_synpred84_PCRE3437); if (state.failed) return;

		match(input,TLC,FOLLOW_TLC_in_synpred84_PCRE3439); if (state.failed) return;

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred84_PCRE3441); if (state.failed) return;

		pushFollow(FOLLOW_regex_in_synpred84_PCRE3445);
		t=regex();
		state._fsp--;
		if (state.failed) return;

		// PCRE.g:475:52: ( '|' f= regex )?
		int alt66=2;
		int LA66_0 = input.LA(1);
		if ( (LA66_0==Pipe) ) {
			alt66=1;
		}
		switch (alt66) {
			case 1 :
				// PCRE.g:475:53: '|' f= regex
				{
				match(input,Pipe,FOLLOW_Pipe_in_synpred84_PCRE3448); if (state.failed) return;

				pushFollow(FOLLOW_regex_in_synpred84_PCRE3452);
				f=regex();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,CloseParen,FOLLOW_CloseParen_in_synpred84_PCRE3456); if (state.failed) return;

		}

	}
	// $ANTLR end synpred84_PCRE

	// $ANTLR start synpred106_PCRE
	public final void synpred106_PCRE_fragment() throws RecognitionException {
		// PCRE.g:553:4: ( literal )
		// PCRE.g:553:4: literal
		{
		pushFollow(FOLLOW_literal_in_synpred106_PCRE4392);
		literal();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred106_PCRE

	// $ANTLR start synpred113_PCRE
	public final void synpred113_PCRE_fragment() throws RecognitionException {
		// PCRE.g:560:4: ( backreference )
		// PCRE.g:560:4: backreference
		{
		pushFollow(FOLLOW_backreference_in_synpred113_PCRE4427);
		backreference();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred113_PCRE

	// $ANTLR start synpred129_PCRE
	public final void synpred129_PCRE_fragment() throws RecognitionException {
		// PCRE.g:580:4: ( cc_literal Hyphen cc_literal )
		// PCRE.g:580:4: cc_literal Hyphen cc_literal
		{
		pushFollow(FOLLOW_cc_literal_in_synpred129_PCRE4562);
		cc_literal();
		state._fsp--;
		if (state.failed) return;

		match(input,Hyphen,FOLLOW_Hyphen_in_synpred129_PCRE4564); if (state.failed) return;

		pushFollow(FOLLOW_cc_literal_in_synpred129_PCRE4566);
		cc_literal();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred129_PCRE

	// $ANTLR start synpred131_PCRE
	public final void synpred131_PCRE_fragment() throws RecognitionException {
		// PCRE.g:582:4: ( cc_literal )
		// PCRE.g:582:4: cc_literal
		{
		pushFollow(FOLLOW_cc_literal_in_synpred131_PCRE4586);
		cc_literal();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred131_PCRE

	// $ANTLR start synpred188_PCRE
	public final void synpred188_PCRE_fragment() throws RecognitionException {
		// PCRE.g:660:6: ( Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit )
		// PCRE.g:660:6: Backslash ( D0 | D1 | D2 | D3 ) octal_digit octal_digit
		{
		match(input,Backslash,FOLLOW_Backslash_in_synpred188_PCRE5377); if (state.failed) return;

		if ( (input.LA(1) >= D0 && input.LA(1) <= D3) ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		pushFollow(FOLLOW_octal_digit_in_synpred188_PCRE5395);
		octal_digit();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_octal_digit_in_synpred188_PCRE5397);
		octal_digit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred188_PCRE

	// $ANTLR start synpred196_PCRE
	public final void synpred196_PCRE_fragment() throws RecognitionException {
		// PCRE.g:671:4: ( digit )
		// PCRE.g:671:4: digit
		{
		pushFollow(FOLLOW_digit_in_synpred196_PCRE5493);
		digit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred196_PCRE

	// Delegated rules

	public final boolean synpred188_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred188_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred72_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred72_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred19_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred19_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred80_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred80_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred21_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred66_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred66_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred74_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred74_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred131_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred131_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred84_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred84_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred106_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred106_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred129_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred129_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred70_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred70_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred76_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred76_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred15_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred15_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred68_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred68_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred31_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred31_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred82_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred82_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred113_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred113_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred78_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred78_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred196_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred196_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred17_PCRE() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred17_PCRE_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA4 dfa4 = new DFA4(this);
	protected DFA5 dfa5 = new DFA5(this);
	protected DFA18 dfa18 = new DFA18(this);
	protected DFA41 dfa41 = new DFA41(this);
	static final String DFA4_eotS =
		"\12\uffff";
	static final String DFA4_eofS =
		"\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff";
	static final String DFA4_minS =
		"\1\4\1\uffff\1\4\1\uffff\1\4\1\0\1\4\1\0\1\4\1\0";
	static final String DFA4_maxS =
		"\1\u00d2\1\uffff\1\u00d2\1\uffff\1\u00d2\1\0\1\u00d2\1\0\1\u00d2\1\0";
	static final String DFA4_acceptS =
		"\1\uffff\1\1\1\uffff\1\2\6\uffff";
	static final String DFA4_specialS =
		"\5\uffff\1\0\1\uffff\1\1\1\uffff\1\2}>";
	static final String[] DFA4_transitionS = {
			"\1\3\5\uffff\1\3\2\uffff\1\3\12\uffff\5\3\3\uffff\1\3\1\uffff\26\3\1"+
			"\uffff\5\3\1\uffff\14\3\1\uffff\6\3\1\uffff\10\3\2\uffff\1\3\2\uffff"+
			"\4\3\25\uffff\1\3\3\uffff\1\3\6\uffff\3\3\1\uffff\10\3\7\uffff\1\3\1"+
			"\uffff\1\3\1\2\5\3\1\uffff\2\3\1\1\2\3\1\uffff\1\3\1\1\1\3\5\uffff\3"+
			"\3\1\uffff\1\3\3\uffff\2\3\1\1\6\3\1\uffff\2\3\1\uffff\12\3\1\uffff\4"+
			"\3",
			"",
			"\1\3\5\uffff\1\3\2\uffff\1\3\12\uffff\5\3\3\uffff\1\3\1\uffff\14\3\12"+
			"\4\1\uffff\5\3\1\uffff\14\3\1\uffff\6\3\1\uffff\10\3\2\uffff\1\3\2\uffff"+
			"\4\3\25\uffff\1\3\3\uffff\1\3\6\uffff\3\3\1\uffff\10\3\7\uffff\1\3\1"+
			"\uffff\7\3\1\uffff\5\3\1\uffff\3\3\5\uffff\3\3\1\uffff\1\3\3\uffff\11"+
			"\3\1\uffff\2\3\1\uffff\12\3\1\uffff\4\3",
			"",
			"\1\3\5\uffff\1\3\2\uffff\1\3\12\uffff\5\3\3\uffff\1\3\1\uffff\7\3\1"+
			"\5\2\3\1\6\1\3\12\4\1\uffff\5\3\1\uffff\14\3\1\uffff\6\3\1\uffff\10\3"+
			"\2\uffff\1\3\2\uffff\4\3\25\uffff\1\3\3\uffff\1\3\6\uffff\3\3\1\uffff"+
			"\10\3\7\uffff\1\3\1\uffff\7\3\1\uffff\5\3\1\uffff\3\3\5\uffff\3\3\1\uffff"+
			"\1\3\3\uffff\11\3\1\uffff\2\3\1\uffff\12\3\1\uffff\4\3",
			"\1\uffff",
			"\1\3\5\uffff\1\3\2\uffff\1\3\12\uffff\5\3\3\uffff\1\3\1\uffff\7\3\1"+
			"\7\4\3\12\10\1\uffff\5\3\1\uffff\14\3\1\uffff\6\3\1\uffff\10\3\2\uffff"+
			"\1\3\2\uffff\4\3\25\uffff\1\3\3\uffff\1\3\6\uffff\3\3\1\uffff\10\3\7"+
			"\uffff\1\3\1\uffff\7\3\1\uffff\5\3\1\uffff\3\3\5\uffff\3\3\1\uffff\1"+
			"\3\3\uffff\11\3\1\uffff\2\3\1\uffff\12\3\1\uffff\4\3",
			"\1\uffff",
			"\1\3\5\uffff\1\3\2\uffff\1\3\12\uffff\5\3\3\uffff\1\3\1\uffff\7\3\1"+
			"\11\4\3\12\10\1\uffff\5\3\1\uffff\14\3\1\uffff\6\3\1\uffff\10\3\2\uffff"+
			"\1\3\2\uffff\4\3\25\uffff\1\3\3\uffff\1\3\6\uffff\3\3\1\uffff\10\3\7"+
			"\uffff\1\3\1\uffff\7\3\1\uffff\5\3\1\uffff\3\3\5\uffff\3\3\1\uffff\1"+
			"\3\3\uffff\11\3\1\uffff\2\3\1\uffff\12\3\1\uffff\4\3",
			"\1\uffff"
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "225:9: ( quantifier )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA4_5 = input.LA(1);
						 
						int index4_5 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred4_PCRE()) ) {s = 1;}
						else if ( (true) ) {s = 3;}
						 
						input.seek(index4_5);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA4_7 = input.LA(1);
						 
						int index4_7 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred4_PCRE()) ) {s = 1;}
						else if ( (true) ) {s = 3;}
						 
						input.seek(index4_7);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA4_9 = input.LA(1);
						 
						int index4_9 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred4_PCRE()) ) {s = 1;}
						else if ( (true) ) {s = 3;}
						 
						input.seek(index4_9);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 4, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA5_eotS =
		"\12\uffff";
	static final String DFA5_eofS =
		"\12\uffff";
	static final String DFA5_minS =
		"\1\u009a\3\uffff\1\56\1\51\1\uffff\1\51\2\uffff";
	static final String DFA5_maxS =
		"\1\u00b9\3\uffff\2\67\1\uffff\1\67\2\uffff";
	static final String DFA5_acceptS =
		"\1\uffff\1\1\1\2\1\3\2\uffff\1\4\1\uffff\1\5\1\6";
	static final String DFA5_specialS =
		"\12\uffff}>";
	static final String[] DFA5_transitionS = {
			"\1\4\10\uffff\1\2\4\uffff\1\1\20\uffff\1\3",
			"",
			"",
			"",
			"\12\5",
			"\1\6\2\uffff\1\7\1\uffff\12\5",
			"",
			"\1\10\4\uffff\12\11",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "246:1: quantifier : ( '?' quantifier_type -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[\"1\"] quantifier_type ) | '+' quantifier_type -> ^( QUANTIFIER NUMBER[\"1\"] NUMBER[HUGE_NUMBER] quantifier_type ) | '*' quantifier_type -> ^( QUANTIFIER NUMBER[\"0\"] NUMBER[HUGE_NUMBER] quantifier_type ) | '{' number '}' quantifier_type -> ^( QUANTIFIER number number quantifier_type ) | '{' number ',' '}' quantifier_type -> ^( QUANTIFIER number NUMBER[HUGE_NUMBER] quantifier_type ) | '{' number ',' number '}' quantifier_type -> ^( QUANTIFIER number number quantifier_type ) );";
		}
	}

	static final String DFA18_eotS =
		"\24\uffff";
	static final String DFA18_eofS =
		"\24\uffff";
	static final String DFA18_minS =
		"\1\u009b\1\u00a8\1\124\1\175\1\uffff\6\52\1\uffff\1\42\2\uffff\1\110\1"+
		"\uffff\1\57\2\uffff";
	static final String DFA18_maxS =
		"\1\u009b\1\u00b9\1\u00cc\1\u00c1\1\uffff\6\u00cc\1\uffff\1\u00bd\2\uffff"+
		"\1\110\1\uffff\1\66\2\uffff";
	static final String DFA18_acceptS =
		"\4\uffff\1\3\6\uffff\1\4\1\uffff\1\1\1\2\1\uffff\1\7\1\uffff\1\5\1\6";
	static final String DFA18_specialS =
		"\24\uffff}>";
	static final String[] DFA18_transitionS = {
			"\1\1",
			"\1\2\20\uffff\1\3",
			"\1\4\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff\1\11\12\uffff"+
			"\1\12",
			"\1\13\103\uffff\1\14",
			"",
			"\1\16\51\uffff\1\15\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff"+
			"\1\11\12\uffff\1\12",
			"\1\16\51\uffff\1\15\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff"+
			"\1\11\12\uffff\1\12",
			"\1\16\51\uffff\1\15\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff"+
			"\1\11\12\uffff\1\12",
			"\1\16\51\uffff\1\15\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff"+
			"\1\11\12\uffff\1\12",
			"\1\16\51\uffff\1\15\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff"+
			"\1\11\12\uffff\1\12",
			"\1\16\51\uffff\1\15\1\5\2\uffff\1\6\11\uffff\1\7\120\uffff\1\10\15\uffff"+
			"\1\11\12\uffff\1\12",
			"",
			"\1\20\u009a\uffff\1\17",
			"",
			"",
			"\1\21",
			"",
			"\1\23\6\uffff\1\22",
			"",
			""
	};

	static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
	static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
	static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
	static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
	static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
	static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
	static final short[][] DFA18_transition;

	static {
		int numStates = DFA18_transitionS.length;
		DFA18_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
		}
	}

	protected class DFA18 extends DFA {

		public DFA18(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 18;
			this.eot = DFA18_eot;
			this.eof = DFA18_eof;
			this.min = DFA18_min;
			this.max = DFA18_max;
			this.accept = DFA18_accept;
			this.special = DFA18_special;
			this.transition = DFA18_transition;
		}
		@Override
		public String getDescription() {
			return "378:1: option : ( '(' '?' s= option_flags '-' u= option_flags ')' -> ^( OPTIONS ^( SET $s) ^( UNSET $u) ) | '(' '?' option_flags ')' -> ^( OPTIONS ^( SET option_flags ) UNSET ) | '(' '?' '-' option_flags ')' -> ^( OPTIONS SET ^( UNSET option_flags ) ) | '(' '*' 'N' 'O' '_' 'S' 'T' 'A' 'R' 'T' '_' 'O' 'P' 'T' ')' -> OPTIONS_NO_START_OPT | '(' '*' 'U' 'T' 'F' '8' ')' -> OPTIONS_UTF8 | '(' '*' 'U' 'T' 'F' '1' '6' ')' -> OPTIONS_UTF16 | '(' '*' 'U' 'C' 'P' ')' -> OPTIONS_UCP );";
		}
	}

	static final String DFA41_eotS =
		"\141\uffff";
	static final String DFA41_eofS =
		"\2\uffff\44\56\1\uffff\5\54\65\uffff";
	static final String DFA41_minS =
		"\1\4\1\56\44\4\1\uffff\5\4\1\uffff\1\4\1\uffff\5\0\1\56\44\0\1\uffff\5"+
		"\4\2\0";
	static final String DFA41_maxS =
		"\1\u00d2\1\67\44\u00d2\1\uffff\5\u00d2\1\uffff\1\u00d2\1\uffff\5\0\1\67"+
		"\44\0\1\uffff\5\u00d2\2\0";
	static final String DFA41_acceptS =
		"\46\uffff\1\2\5\uffff\1\4\1\uffff\1\3\52\uffff\1\1\7\uffff";
	static final String DFA41_specialS =
		"\57\uffff\1\1\1\2\1\3\1\4\1\50\1\uffff\1\16\1\21\1\37\1\17\1\45\1\27\1"+
		"\11\1\47\1\32\1\13\1\42\1\24\1\0\1\33\1\22\1\5\1\35\1\23\1\52\1\26\1\7"+
		"\1\40\1\25\1\12\1\43\1\6\1\36\1\20\1\44\1\30\1\10\1\51\1\31\1\15\1\41"+
		"\1\34\6\uffff\1\46\1\14}>";
	static final String[] DFA41_transitionS = {
			"\1\2\5\uffff\1\2\2\uffff\1\31\12\uffff\2\2\1\1\1\4\1\14\3\uffff\1\2\1"+
			"\uffff\1\2\1\35\1\10\2\46\1\uffff\1\34\1\16\1\45\1\25\1\17\1\46\12\3"+
			"\1\uffff\2\2\1\46\1\33\1\2\1\uffff\1\2\1\uffff\1\42\1\uffff\1\27\1\5"+
			"\1\30\1\uffff\2\2\1\6\1\2\1\uffff\1\2\1\22\2\2\1\26\1\12\1\uffff\1\46"+
			"\1\20\6\2\2\uffff\1\2\2\uffff\1\2\1\21\2\2\25\uffff\1\2\3\uffff\1\2\7"+
			"\uffff\1\7\1\46\2\uffff\6\46\1\2\7\uffff\1\2\2\uffff\1\15\1\44\1\32\1"+
			"\2\2\46\1\uffff\1\2\1\43\1\37\1\uffff\1\2\1\uffff\1\2\1\36\1\13\5\uffff"+
			"\2\2\2\uffff\1\2\3\uffff\1\2\1\23\1\40\2\uffff\2\2\1\11\1\2\1\uffff\1"+
			"\2\1\24\1\uffff\2\2\1\46\2\2\1\46\1\41\1\46\2\2\1\uffff\4\2",
			"\1\47\1\50\1\51\1\52\4\53\2\54",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\26"+
			"\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\4\56"+
			"\1\uffff\6\56\1\uffff\1\56\1\55\6\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"",
			"\1\54\5\uffff\1\54\2\uffff\1\54\12\uffff\5\54\3\uffff\1\54\1\uffff\14"+
			"\54\10\57\2\54\1\uffff\5\54\1\uffff\1\54\1\uffff\1\54\1\uffff\3\54\1"+
			"\uffff\4\54\1\uffff\6\54\1\uffff\10\54\2\uffff\1\54\2\uffff\4\54\25\uffff"+
			"\1\54\3\uffff\1\54\7\uffff\2\54\2\uffff\7\54\7\uffff\1\54\2\uffff\6\54"+
			"\1\uffff\3\54\1\uffff\1\54\1\uffff\3\54\5\uffff\2\54\2\uffff\1\54\3\uffff"+
			"\3\54\2\uffff\4\54\1\uffff\2\54\1\uffff\12\54\1\uffff\4\54",
			"\1\54\5\uffff\1\54\2\uffff\1\54\12\uffff\5\54\3\uffff\1\54\1\uffff\14"+
			"\54\10\60\2\54\1\uffff\5\54\1\uffff\1\54\1\uffff\1\54\1\uffff\3\54\1"+
			"\uffff\4\54\1\uffff\6\54\1\uffff\10\54\2\uffff\1\54\2\uffff\4\54\25\uffff"+
			"\1\54\3\uffff\1\54\7\uffff\2\54\2\uffff\7\54\7\uffff\1\54\2\uffff\6\54"+
			"\1\uffff\3\54\1\uffff\1\54\1\uffff\3\54\5\uffff\2\54\2\uffff\1\54\3\uffff"+
			"\3\54\2\uffff\4\54\1\uffff\2\54\1\uffff\12\54\1\uffff\4\54",
			"\1\54\5\uffff\1\54\2\uffff\1\54\12\uffff\5\54\3\uffff\1\54\1\uffff\14"+
			"\54\10\61\2\54\1\uffff\5\54\1\uffff\1\54\1\uffff\1\54\1\uffff\3\54\1"+
			"\uffff\4\54\1\uffff\6\54\1\uffff\10\54\2\uffff\1\54\2\uffff\4\54\25\uffff"+
			"\1\54\3\uffff\1\54\7\uffff\2\54\2\uffff\7\54\7\uffff\1\54\2\uffff\6\54"+
			"\1\uffff\3\54\1\uffff\1\54\1\uffff\3\54\5\uffff\2\54\2\uffff\1\54\3\uffff"+
			"\3\54\2\uffff\4\54\1\uffff\2\54\1\uffff\12\54\1\uffff\4\54",
			"\1\54\5\uffff\1\54\2\uffff\1\54\12\uffff\5\54\3\uffff\1\54\1\uffff\14"+
			"\54\10\62\2\54\1\uffff\5\54\1\uffff\1\54\1\uffff\1\54\1\uffff\3\54\1"+
			"\uffff\4\54\1\uffff\6\54\1\uffff\10\54\2\uffff\1\54\2\uffff\4\54\25\uffff"+
			"\1\54\3\uffff\1\54\7\uffff\2\54\2\uffff\7\54\7\uffff\1\54\2\uffff\6\54"+
			"\1\uffff\3\54\1\uffff\1\54\1\uffff\3\54\5\uffff\2\54\2\uffff\1\54\3\uffff"+
			"\3\54\2\uffff\4\54\1\uffff\2\54\1\uffff\12\54\1\uffff\4\54",
			"\1\54\5\uffff\1\54\2\uffff\1\54\12\uffff\5\54\3\uffff\1\54\1\uffff\14"+
			"\54\10\63\2\54\1\uffff\5\54\1\uffff\1\54\1\uffff\1\54\1\uffff\3\54\1"+
			"\uffff\4\54\1\uffff\6\54\1\uffff\10\54\2\uffff\1\54\2\uffff\4\54\25\uffff"+
			"\1\54\3\uffff\1\54\7\uffff\2\54\2\uffff\7\54\7\uffff\1\54\2\uffff\6\54"+
			"\1\uffff\3\54\1\uffff\1\54\1\uffff\3\54\5\uffff\2\54\2\uffff\1\54\3\uffff"+
			"\3\54\2\uffff\4\54\1\uffff\2\54\1\uffff\12\54\1\uffff\4\54",
			"",
			"\1\65\5\uffff\1\65\2\uffff\1\114\12\uffff\2\65\1\64\1\67\1\77\3\uffff"+
			"\1\65\1\uffff\1\65\1\120\1\73\3\56\1\117\1\101\1\130\1\110\1\102\1\56"+
			"\12\66\1\uffff\2\65\1\56\1\116\1\65\1\uffff\1\65\1\uffff\1\125\1\uffff"+
			"\1\112\1\70\1\113\1\uffff\2\65\1\71\1\65\1\uffff\1\65\1\105\2\65\1\111"+
			"\1\75\1\uffff\1\56\1\103\6\65\2\uffff\1\65\2\uffff\1\65\1\104\2\65\25"+
			"\uffff\1\65\3\uffff\1\65\7\uffff\1\72\1\56\2\uffff\6\56\1\65\7\uffff"+
			"\1\65\2\uffff\1\100\1\127\1\115\1\65\2\56\1\uffff\1\65\1\126\1\122\1"+
			"\uffff\1\65\1\uffff\1\65\1\121\1\76\5\uffff\2\65\2\uffff\1\65\3\uffff"+
			"\1\65\1\106\1\123\2\uffff\2\65\1\74\1\65\1\uffff\1\65\1\107\1\uffff\2"+
			"\65\1\56\2\65\1\56\1\124\1\56\2\65\1\uffff\4\65",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\132\1\133\1\134\1\135\4\136\2\56",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\14"+
			"\56\10\137\2\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1"+
			"\uffff\4\56\1\uffff\6\56\1\uffff\10\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\14"+
			"\56\10\137\2\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1"+
			"\uffff\4\56\1\uffff\6\56\1\uffff\10\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\14"+
			"\56\10\137\2\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1"+
			"\uffff\4\56\1\uffff\6\56\1\uffff\10\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\14"+
			"\56\10\137\2\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1"+
			"\uffff\4\56\1\uffff\6\56\1\uffff\10\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\56\5\uffff\1\56\2\uffff\1\56\12\uffff\5\56\3\uffff\1\56\1\uffff\14"+
			"\56\10\140\2\56\1\uffff\5\56\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1"+
			"\uffff\4\56\1\uffff\6\56\1\uffff\10\56\2\uffff\1\56\2\uffff\4\56\25\uffff"+
			"\1\56\3\uffff\1\56\7\uffff\2\56\2\uffff\7\56\7\uffff\1\56\2\uffff\6\56"+
			"\1\uffff\3\56\1\uffff\1\56\1\uffff\3\56\5\uffff\2\56\2\uffff\1\56\3\uffff"+
			"\3\56\2\uffff\4\56\1\uffff\2\56\1\uffff\12\56\1\uffff\4\56",
			"\1\uffff",
			"\1\uffff"
	};

	static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
	static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
	static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
	static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
	static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
	static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
	static final short[][] DFA41_transition;

	static {
		int numStates = DFA41_transitionS.length;
		DFA41_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
		}
	}

	protected class DFA41 extends DFA {

		public DFA41(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 41;
			this.eot = DFA41_eot;
			this.eof = DFA41_eof;
			this.min = DFA41_min;
			this.max = DFA41_max;
			this.accept = DFA41_accept;
			this.special = DFA41_special;
			this.transition = DFA41_transition;
		}
		@Override
		public String getDescription() {
			return "579:1: cc_atom : ( cc_literal Hyphen cc_literal -> ^( RANGE cc_literal cc_literal ) | shared_atom | cc_literal | backreference_or_octal );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA41_65 = input.LA(1);
						 
						int index41_65 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_65);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA41_47 = input.LA(1);
						 
						int index41_47 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						else if ( (true) ) {s = 44;}
						 
						input.seek(index41_47);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA41_48 = input.LA(1);
						 
						int index41_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						else if ( (true) ) {s = 44;}
						 
						input.seek(index41_48);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA41_49 = input.LA(1);
						 
						int index41_49 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						else if ( (true) ) {s = 44;}
						 
						input.seek(index41_49);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA41_50 = input.LA(1);
						 
						int index41_50 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						else if ( (true) ) {s = 44;}
						 
						input.seek(index41_50);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA41_68 = input.LA(1);
						 
						int index41_68 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_68);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA41_78 = input.LA(1);
						 
						int index41_78 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_78);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA41_73 = input.LA(1);
						 
						int index41_73 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_73);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA41_83 = input.LA(1);
						 
						int index41_83 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_83);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA41_59 = input.LA(1);
						 
						int index41_59 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_59);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA41_76 = input.LA(1);
						 
						int index41_76 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_76);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA41_62 = input.LA(1);
						 
						int index41_62 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_62);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA41_96 = input.LA(1);
						 
						int index41_96 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_96);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA41_86 = input.LA(1);
						 
						int index41_86 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_86);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA41_53 = input.LA(1);
						 
						int index41_53 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_53);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA41_56 = input.LA(1);
						 
						int index41_56 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_56);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA41_80 = input.LA(1);
						 
						int index41_80 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_80);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA41_54 = input.LA(1);
						 
						int index41_54 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_54);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA41_67 = input.LA(1);
						 
						int index41_67 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_67);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA41_70 = input.LA(1);
						 
						int index41_70 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_70);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA41_64 = input.LA(1);
						 
						int index41_64 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_64);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA41_75 = input.LA(1);
						 
						int index41_75 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_75);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA41_72 = input.LA(1);
						 
						int index41_72 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_72);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA41_58 = input.LA(1);
						 
						int index41_58 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_58);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA41_82 = input.LA(1);
						 
						int index41_82 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_82);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA41_85 = input.LA(1);
						 
						int index41_85 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_85);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA41_61 = input.LA(1);
						 
						int index41_61 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_61);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA41_66 = input.LA(1);
						 
						int index41_66 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_66);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA41_88 = input.LA(1);
						 
						int index41_88 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_88);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA41_69 = input.LA(1);
						 
						int index41_69 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_69);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA41_79 = input.LA(1);
						 
						int index41_79 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_79);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA41_55 = input.LA(1);
						 
						int index41_55 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_55);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA41_74 = input.LA(1);
						 
						int index41_74 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_74);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA41_87 = input.LA(1);
						 
						int index41_87 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_87);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA41_63 = input.LA(1);
						 
						int index41_63 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_63);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA41_77 = input.LA(1);
						 
						int index41_77 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_77);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA41_81 = input.LA(1);
						 
						int index41_81 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_81);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA41_57 = input.LA(1);
						 
						int index41_57 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_57);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA41_95 = input.LA(1);
						 
						int index41_95 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_95);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA41_60 = input.LA(1);
						 
						int index41_60 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_60);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA41_51 = input.LA(1);
						 
						int index41_51 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						else if ( (true) ) {s = 44;}
						 
						input.seek(index41_51);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA41_84 = input.LA(1);
						 
						int index41_84 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_84);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA41_71 = input.LA(1);
						 
						int index41_71 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred129_PCRE()) ) {s = 89;}
						else if ( (synpred131_PCRE()) ) {s = 46;}
						 
						input.seek(index41_71);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 41, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_regex_in_parse473 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_first_alternative_in_regex498 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_regex507 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B6FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_alternative_in_regex509 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_alternative_in_first_alternative535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_alternative546 = new BitSet(new long[]{0xBEFFFBFD1F002412L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_atom_in_element567 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0200010804000000L});
	public static final BitSet FOLLOW_quantifier_in_element569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionMark_in_quantifier610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010800000000L});
	public static final BitSet FOLLOW_quantifier_type_in_quantifier612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Plus_in_quantifier661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010800000000L});
	public static final BitSet FOLLOW_quantifier_type_in_quantifier663 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Star_in_quantifier704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010800000000L});
	public static final BitSet FOLLOW_quantifier_type_in_quantifier706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenBrace_in_quantifier747 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_quantifier749 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_quantifier751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010800000000L});
	public static final BitSet FOLLOW_quantifier_type_in_quantifier753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenBrace_in_quantifier799 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_quantifier801 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Comma_in_quantifier803 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_quantifier805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010800000000L});
	public static final BitSet FOLLOW_quantifier_type_in_quantifier807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenBrace_in_quantifier837 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_quantifier839 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Comma_in_quantifier841 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_quantifier843 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_quantifier845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010800000000L});
	public static final BitSet FOLLOW_quantifier_type_in_quantifier847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Plus_in_quantifier_type888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionMark_in_quantifier_type908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_character_class968 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Caret_in_character_class972 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_character_class976 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_end_range_in_character_class980 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_character_class982 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_character_class1010 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Caret_in_character_class1014 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1016 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_character_class1018 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1021 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_character_class1067 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Caret_in_character_class1071 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_character_class1073 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_character_class1137 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_character_class1143 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_end_range_in_character_class1147 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_character_class1149 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_character_class1181 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1185 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_character_class1187 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_character_class1240 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_character_class1244 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_character_class1247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cc_atom_in_cc_atom_end_range1318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_backreference_or_octal_in_backreference1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1345 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_backreference1347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_OpenBrace_in_backreference1374 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_backreference1376 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_backreference1378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_OpenBrace_in_backreference1397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_backreference1399 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_backreference1401 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_backreference1403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NamedReferenceStartK_in_backreference1416 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_backreference1418 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_backreference1420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_backreference1422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NamedReferenceStartK_in_backreference1441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_backreference1443 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_backreference1445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_backreference1447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_backreference1464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_OpenBrace_in_backreference1466 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_backreference1468 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_backreference1470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NamedReferenceStartK_in_backreference1489 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_OpenBrace_in_backreference1491 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_backreference1493 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_CloseBrace_in_backreference1495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backreference1514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_backreference1516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_backreference1518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Equals_in_backreference1520 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_backreference1522 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backreference1524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_octal_char_in_backreference_or_octal1543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Backslash_in_backreference_or_octal1548 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_digit_in_backreference_or_octal1550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_capture1583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_capture1587 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_capture1589 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_capture1591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_capture1593 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_capture1597 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_capture1599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_capture1618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_capture1622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_capture1623 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_capture1625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_capture1627 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_capture1631 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_capture1633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_capture1652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_capture1656 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_capture1658 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_capture1660 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_capture1662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_capture1664 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_capture1668 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_capture1670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_capture1685 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_capture1689 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_capture1691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_non_capture1773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_non_capture1775 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Colon_in_non_capture1777 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_non_capture1779 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_non_capture1781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_non_capture1794 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_non_capture1796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_non_capture1798 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_non_capture1800 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_non_capture1802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_non_capture1815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_non_capture1817 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_non_capture1819 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_non_capture1821 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_non_capture1823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_comment1845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_comment1847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_Hash_in_comment1849 = new BitSet(new long[]{0xFFFFFBFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x000000000007FFFFL});
	public static final BitSet FOLLOW_non_close_parens_in_comment1851 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_comment1853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option1886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_option1888 = new BitSet(new long[]{0x0000000000000000L,0x0000000401200000L,0x0008000000000000L,0x0000000000001002L});
	public static final BitSet FOLLOW_option_flags_in_option1892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_option1894 = new BitSet(new long[]{0x0000000000000000L,0x0000000401200000L,0x0008000000000000L,0x0000000000001002L});
	public static final BitSet FOLLOW_option_flags_in_option1898 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option1900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option1939 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_option1941 = new BitSet(new long[]{0x0000000000000000L,0x0000000401200000L,0x0008000000000000L,0x0000000000001002L});
	public static final BitSet FOLLOW_option_flags_in_option1943 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option1945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option1999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_option2001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_option2003 = new BitSet(new long[]{0x0000000000000000L,0x0000000401200000L,0x0008000000000000L,0x0000000000001002L});
	public static final BitSet FOLLOW_option_flags_in_option2005 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option2007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option2057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_option2059 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_option2061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_OUC_in_option2063 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Underscore_in_option2065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_SUC_in_option2067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_option2069 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_option2071 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_option2073 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_option2075 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Underscore_in_option2077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_OUC_in_option2079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_option2081 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_option2083 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option2085 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option2094 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_option2096 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_option2098 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_option2100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_option2102 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_D8_in_option2104 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option2106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option2147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_option2149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_option2151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_option2153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_option2155 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_D1_in_option2157 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_D6_in_option2159 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option2161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_option2198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_option2200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_option2202 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_option2204 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_option2206 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_option2208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_flag_in_option_flags2259 = new BitSet(new long[]{0x0000000000000002L,0x0000000401200000L,0x0008000000000000L,0x0000000000001002L});
	public static final BitSet FOLLOW_ILC_in_option_flag2271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JUC_in_option_flag2281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MLC_in_option_flag2291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SLC_in_option_flag2301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_option_flag2311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_XLC_in_option_flag2321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_look_around2345 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_look_around2347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Equals_in_look_around2349 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_look_around2351 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_look_around2353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_look_around2370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_look_around2372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_Exclamation_in_look_around2374 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_look_around2376 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_look_around2378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_look_around2395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_look_around2397 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_look_around2399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_Equals_in_look_around2401 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_look_around2403 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_look_around2405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_look_around2418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_look_around2420 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_look_around2422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_Exclamation_in_look_around2424 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_look_around2426 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_look_around2428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_subroutine_reference2463 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_subroutine_reference2465 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_subroutine_reference2467 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_subroutine_reference2469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_subroutine_reference2494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_subroutine_reference2496 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2498 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_subroutine_reference2500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_subroutine_reference2521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_subroutine_reference2523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_Plus_in_subroutine_reference2525 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2527 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_subroutine_reference2529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_subroutine_reference2546 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_subroutine_reference2548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_subroutine_reference2550 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2552 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_subroutine_reference2554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_subroutine_reference2571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_subroutine_reference2573 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Ampersand_in_subroutine_reference2575 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_subroutine_reference2577 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_subroutine_reference2579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_subroutine_reference2598 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_subroutine_reference2600 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_subroutine_reference2602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_subroutine_reference2604 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_subroutine_reference2606 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_subroutine_reference2608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2623 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_subroutine_reference2625 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_subroutine_reference2627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_subroutine_reference2629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2652 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_subroutine_reference2654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2675 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_subroutine_reference2677 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2679 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_subroutine_reference2681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2702 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2723 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_subroutine_reference2725 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_Plus_in_subroutine_reference2727 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2729 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_subroutine_reference2731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_Plus_in_subroutine_reference2750 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2752 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_subroutine_reference2769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_subroutine_reference2771 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_subroutine_reference2775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SubroutineOrNamedReferenceStartG_in_subroutine_reference2790 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_subroutine_reference2794 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_subroutine_reference2796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_subroutine_reference2798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional2833 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional2835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional2837 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_conditional2839 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional2841 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional2845 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional2848 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional2852 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional2856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional2901 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional2903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional2905 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_Plus_in_conditional2907 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_conditional2909 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional2911 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional2915 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional2918 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional2922 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional2926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional2967 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional2969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional2971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_conditional2973 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_conditional2975 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional2977 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional2981 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional2984 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional2988 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional2992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3035 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3037 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_conditional3039 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_conditional3041 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_conditional3043 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3045 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3049 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3052 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3056 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3099 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_conditional3105 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_conditional3107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_conditional3109 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3111 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3115 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3118 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3122 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_conditional3169 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_conditional3171 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3173 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3177 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3180 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3184 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_conditional3235 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3237 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3241 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3244 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3248 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3302 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_conditional3304 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Ampersand_in_conditional3306 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_conditional3308 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3310 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3314 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3317 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3321 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3368 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_DUC_in_conditional3370 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_conditional3372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_conditional3374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_conditional3376 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_conditional3378 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_conditional3380 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3382 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3386 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3389 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3393 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3427 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ALC_in_conditional3429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_SLC_in_conditional3431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_SLC_in_conditional3433 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ELC_in_conditional3435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_RLC_in_conditional3437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_TLC_in_conditional3439 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3441 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3445 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3448 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3452 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3482 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_conditional3484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_conditional3486 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_conditional3488 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3490 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3494 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_conditional3497 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_conditional3501 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_conditional3505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3582 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3584 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_backtrack_control3586 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_backtrack_control3588 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_backtrack_control3592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_backtrack_control3594 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_backtrack_control3625 = new BitSet(new long[]{0x0000040000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_backtrack_control3630 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_LUC_in_backtrack_control3632 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3668 = new BitSet(new long[]{0x0000080000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3671 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_backtrack_control3675 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KUC_in_backtrack_control3677 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Colon_in_backtrack_control3681 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3683 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3685 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3687 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3689 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3703 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_backtrack_control3705 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_OUC_in_backtrack_control3707 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3709 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_backtrack_control3713 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_backtrack_control3715 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_backtrack_control3746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_backtrack_control3748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_backtrack_control3750 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3752 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3754 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3756 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_backtrack_control3789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_backtrack_control3791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_backtrack_control3793 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3795 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3797 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Colon_in_backtrack_control3799 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3801 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3803 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3805 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3807 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3818 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_SUC_in_backtrack_control3822 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KUC_in_backtrack_control3824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_backtrack_control3826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_backtrack_control3828 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3863 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_SUC_in_backtrack_control3867 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KUC_in_backtrack_control3869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_backtrack_control3871 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_PUC_in_backtrack_control3873 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Colon_in_backtrack_control3875 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3877 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3879 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3881 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3883 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3898 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_backtrack_control3902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_HUC_in_backtrack_control3904 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3906 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3908 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_backtrack_control3943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_backtrack_control3945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_TUC_in_backtrack_control3947 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_HUC_in_backtrack_control3949 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3951 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3953 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Colon_in_backtrack_control3955 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_backtrack_control3957 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_backtrack_control3959 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_MUC_in_backtrack_control3961 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_backtrack_control3963 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_backtrack_control3965 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4002 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4004 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_newline_convention4006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_newline_convention4008 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4057 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_LUC_in_newline_convention4059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_newline_convention4061 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4110 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_newline_convention4112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_newline_convention4114 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_LUC_in_newline_convention4116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_newline_convention4118 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4159 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_newline_convention4161 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_newline_convention4163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_YUC_in_newline_convention4165 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_newline_convention4167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_newline_convention4169 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_LUC_in_newline_convention4171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_newline_convention4173 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4202 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_newline_convention4204 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_newline_convention4206 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_YUC_in_newline_convention4208 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4253 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_BUC_in_newline_convention4255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_SUC_in_newline_convention4257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_newline_convention4259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Underscore_in_newline_convention4261 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_AUC_in_newline_convention4263 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_newline_convention4265 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_YUC_in_newline_convention4267 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_newline_convention4269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_newline_convention4271 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_LUC_in_newline_convention4273 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_newline_convention4275 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_newline_convention4286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_Star_in_newline_convention4288 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_BUC_in_newline_convention4290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_SUC_in_newline_convention4292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_newline_convention4294 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Underscore_in_newline_convention4296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_UUC_in_newline_convention4298 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_newline_convention4300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_newline_convention4302 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_newline_convention4304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_OUC_in_newline_convention4306 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_DUC_in_newline_convention4308 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_newline_convention4310 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_newline_convention4312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_callout4331 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_callout4333 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_callout4335 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_callout4337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_callout4355 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_callout4357 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CUC_in_callout4359 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_callout4361 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_callout4363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subroutine_reference_in_atom4382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shared_atom_in_atom4387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_atom4392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_character_class_in_atom4397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_capture_in_atom4402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_non_capture_in_atom4407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_in_atom4412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_in_atom4417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_look_around_in_atom4422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_backreference_in_atom4427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_atom4432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_backtrack_control_in_atom4437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_newline_convention_in_atom4442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_callout_in_atom4447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Dot_in_atom4452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Caret_in_atom4476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StartOfSubject_in_atom4498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WordBoundary_in_atom4511 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NonWordBoundary_in_atom4516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EndOfSubjectOrLine_in_atom4521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EndOfSubjectOrLineEndOfSubject_in_atom4526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EndOfSubject_in_atom4531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PreviousMatchInSubject_in_atom4536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ResetStartMatch_in_atom4541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OneDataUnit_in_atom4546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ExtendedUnicodeChar_in_atom4551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cc_literal_in_cc_atom4562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_cc_atom4564 = new BitSet(new long[]{0xB6FFDF1D1F002410L,0x2200000F27F3F7BAL,0xF38983AE3C808020L,0x000000000007B5B6L});
	public static final BitSet FOLLOW_cc_literal_in_cc_atom4566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shared_atom_in_cc_atom4581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cc_literal_in_cc_atom4586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_backreference_or_octal_in_cc_atom4591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shared_literal_in_literal4695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_literal4700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_shared_literal_in_cc_literal4716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Dot_in_cc_literal4721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_cc_literal4747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Caret_in_cc_literal4757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionMark_in_cc_literal4781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Plus_in_cc_literal4798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Star_in_cc_literal4823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WordBoundary_in_cc_literal4848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EndOfSubjectOrLine_in_cc_literal4866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Pipe_in_cc_literal4877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_cc_literal4902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CloseParen_in_cc_literal4922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_octal_char_in_shared_literal4947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_letter_in_shared_literal4952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_digit_in_shared_literal4970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BellChar_in_shared_literal4989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EscapeChar_in_shared_literal5005 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormFeed_in_shared_literal5019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NewLine_in_shared_literal5035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CarriageReturn_in_shared_literal5052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Tab_in_shared_literal5062 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HexChar_in_shared_literal5083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Quoted_in_shared_literal5100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BlockQuoted_in_shared_literal5118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenBrace_in_shared_literal5131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CloseBrace_in_shared_literal5146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Comma_in_shared_literal5160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Hyphen_in_shared_literal5179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LessThan_in_shared_literal5197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GreaterThan_in_shared_literal5213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SingleQuote_in_shared_literal5226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Underscore_in_shared_literal5239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Colon_in_shared_literal5253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Hash_in_shared_literal5272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Equals_in_shared_literal5292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Exclamation_in_shared_literal5310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ampersand_in_shared_literal5323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OtherChar_in_shared_literal5338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_digits_in_number5359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Backslash_in_octal_char5377 = new BitSet(new long[]{0x0003C00000000000L});
	public static final BitSet FOLLOW_D0_in_octal_char5380 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_D1_in_octal_char5384 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_D2_in_octal_char5388 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_D3_in_octal_char5392 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_octal_digit_in_octal_char5395 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_octal_digit_in_octal_char5397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Backslash_in_octal_char5404 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_octal_digit_in_octal_char5406 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_octal_digit_in_octal_char5408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_digit_in_digits5493 = new BitSet(new long[]{0x00FFC00000000002L});
	public static final BitSet FOLLOW_alpha_nums_in_name5552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_letter_in_alpha_nums5569 = new BitSet(new long[]{0xA6FFC00503000412L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_Underscore_in_alpha_nums5573 = new BitSet(new long[]{0xA6FFC00503000412L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_letter_in_alpha_nums5577 = new BitSet(new long[]{0xA6FFC00503000412L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_Underscore_in_alpha_nums5581 = new BitSet(new long[]{0xA6FFC00503000412L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_digit_in_alpha_nums5585 = new BitSet(new long[]{0xA6FFC00503000412L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_non_close_paren_in_non_close_parens5598 = new BitSet(new long[]{0xFFFFFBFFFFFFFFF2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x000000000007FFFFL});
	public static final BitSet FOLLOW_Pipe_in_synpred1_PCRE507 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_alternative_in_synpred1_PCRE509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Pipe_in_synpred2_PCRE507 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B6FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_alternative_in_synpred2_PCRE509 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_quantifier_in_synpred4_PCRE569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_synpred13_PCRE968 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Caret_in_synpred13_PCRE972 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred13_PCRE974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_synpred13_PCRE976 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_end_range_in_synpred13_PCRE980 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_synpred13_PCRE982 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred13_PCRE985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_synpred15_PCRE1010 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Caret_in_synpred15_PCRE1014 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred15_PCRE1016 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_synpred15_PCRE1018 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred15_PCRE1021 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_synpred17_PCRE1067 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Caret_in_synpred17_PCRE1071 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_synpred17_PCRE1073 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred17_PCRE1076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_synpred19_PCRE1137 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred19_PCRE1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_synpred19_PCRE1143 = new BitSet(new long[]{0xBEFFFF7D1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_end_range_in_synpred19_PCRE1147 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_synpred19_PCRE1149 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred19_PCRE1152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CharacterClassStart_in_synpred21_PCRE1181 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred21_PCRE1185 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_cc_atom_in_synpred21_PCRE1187 = new BitSet(new long[]{0xBEFFFFFD1F002410L,0x2200000F27FBF7BAL,0xF38983AEFC80FE60L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_CharacterClassEnd_in_synpred21_PCRE1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_octal_char_in_synpred31_PCRE1543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred66_PCRE2833 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred66_PCRE2835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred66_PCRE2837 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_synpred66_PCRE2839 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred66_PCRE2841 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred66_PCRE2845 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred66_PCRE2848 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred66_PCRE2852 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred66_PCRE2856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred68_PCRE2901 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred68_PCRE2903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred68_PCRE2905 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_Plus_in_synpred68_PCRE2907 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_synpred68_PCRE2909 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred68_PCRE2911 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred68_PCRE2915 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred68_PCRE2918 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred68_PCRE2922 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred68_PCRE2926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred70_PCRE2967 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred70_PCRE2969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred70_PCRE2971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_synpred70_PCRE2973 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_synpred70_PCRE2975 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred70_PCRE2977 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred70_PCRE2981 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred70_PCRE2984 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred70_PCRE2988 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred70_PCRE2992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred72_PCRE3033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred72_PCRE3035 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred72_PCRE3037 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_LessThan_in_synpred72_PCRE3039 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_synpred72_PCRE3041 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_GreaterThan_in_synpred72_PCRE3043 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred72_PCRE3045 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred72_PCRE3049 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred72_PCRE3052 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred72_PCRE3056 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred72_PCRE3060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred74_PCRE3099 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred74_PCRE3101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred74_PCRE3103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_synpred74_PCRE3105 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_synpred74_PCRE3107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_SingleQuote_in_synpred74_PCRE3109 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred74_PCRE3111 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred74_PCRE3115 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred74_PCRE3118 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred74_PCRE3122 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred74_PCRE3126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred76_PCRE3163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred76_PCRE3165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred76_PCRE3167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_synpred76_PCRE3169 = new BitSet(new long[]{0x00FFC00000000000L});
	public static final BitSet FOLLOW_number_in_synpred76_PCRE3171 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred76_PCRE3173 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred76_PCRE3177 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred76_PCRE3180 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred76_PCRE3184 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred76_PCRE3188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred78_PCRE3229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred78_PCRE3231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred78_PCRE3233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_synpred78_PCRE3235 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred78_PCRE3237 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred78_PCRE3241 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred78_PCRE3244 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred78_PCRE3248 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred78_PCRE3252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred80_PCRE3298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred80_PCRE3300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred80_PCRE3302 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_RUC_in_synpred80_PCRE3304 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Ampersand_in_synpred80_PCRE3306 = new BitSet(new long[]{0xA600000503000410L,0x2200000D27E0D580L,0xB08980A220808000L,0x000000000007B1B6L});
	public static final BitSet FOLLOW_name_in_synpred80_PCRE3308 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred80_PCRE3310 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred80_PCRE3314 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred80_PCRE3317 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred80_PCRE3321 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred80_PCRE3325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred82_PCRE3364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred82_PCRE3366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred82_PCRE3368 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_DUC_in_synpred82_PCRE3370 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_synpred82_PCRE3372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_FUC_in_synpred82_PCRE3374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_IUC_in_synpred82_PCRE3376 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_NUC_in_synpred82_PCRE3378 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_EUC_in_synpred82_PCRE3380 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred82_PCRE3382 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred82_PCRE3386 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred82_PCRE3389 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred82_PCRE3393 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred82_PCRE3397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OpenParen_in_synpred84_PCRE3423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_QuestionMark_in_synpred84_PCRE3425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_OpenParen_in_synpred84_PCRE3427 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ALC_in_synpred84_PCRE3429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_SLC_in_synpred84_PCRE3431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_SLC_in_synpred84_PCRE3433 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ELC_in_synpred84_PCRE3435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_RLC_in_synpred84_PCRE3437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_TLC_in_synpred84_PCRE3439 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred84_PCRE3441 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred84_PCRE3445 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Pipe_in_synpred84_PCRE3448 = new BitSet(new long[]{0xBEFFFBFD1F002410L,0x2200000F27FBF7FFL,0xFD8B82B2FE80FF70L,0x000000000007BFF6L});
	public static final BitSet FOLLOW_regex_in_synpred84_PCRE3452 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_CloseParen_in_synpred84_PCRE3456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_synpred106_PCRE4392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_backreference_in_synpred113_PCRE4427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cc_literal_in_synpred129_PCRE4562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_Hyphen_in_synpred129_PCRE4564 = new BitSet(new long[]{0xB6FFDF1D1F002410L,0x2200000F27F3F7BAL,0xF38983AE3C808020L,0x000000000007B5B6L});
	public static final BitSet FOLLOW_cc_literal_in_synpred129_PCRE4566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cc_literal_in_synpred131_PCRE4586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Backslash_in_synpred188_PCRE5377 = new BitSet(new long[]{0x0003C00000000000L});
	public static final BitSet FOLLOW_set_in_synpred188_PCRE5379 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_octal_digit_in_synpred188_PCRE5395 = new BitSet(new long[]{0x003FC00000000000L});
	public static final BitSet FOLLOW_octal_digit_in_synpred188_PCRE5397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_digit_in_synpred196_PCRE5493 = new BitSet(new long[]{0x0000000000000002L});
}
