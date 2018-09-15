// GRAMMAR'S NAME
grammar RelationalAlgebra;

// PRODUCTION RULES
start:   (view SEMICOLON)*  expr (SEMICOLON)* EOF
;

view:    IDENTIFIER EQUAL expr SEMICOLON                                                                                # viewAssignment
;

expr:    relation                                                                                                       # relationFromExpr
    |    LEFT_BRACKET expr RIGHT_BRACKET                                                                                # bracketsExpr
    |    PROJECTION attrlist LEFT_BRACKET expr RIGHT_BRACKET      
           (GROUP_BY attrlist ((HAVING condlist) | (LEFT_SQUARE_BRACKET condlist RIGHT_SQUARE_BRACKET))?)?              # projection
    |    SELECTION LEFT_SQUARE_BRACKET condlist RIGHT_SQUARE_BRACKET LEFT_BRACKET expr RIGHT_BRACKET                    # selection
    |    RENAME attrlist LEFT_BRACKET expr RIGHT_BRACKET                                                                # rename
    |    expr UNION expr                                                                                                # union
    |    expr CARTESIAN_PRODUCT expr                                                                                    # cartesianProduct
    |    expr DIFFERENCE expr                                                                                           # difference
    |    expr NATURAL_JOIN expr                                                                                         # naturalJoin
    |    expr INTERSECTION expr                                                                                         # intersection
    |    expr JOIN expr LEFT_SQUARE_BRACKET condlist RIGHT_SQUARE_BRACKET                                               # join
    |    expr LEFT_OUTER_JOIN expr LEFT_SQUARE_BRACKET condlist RIGHT_SQUARE_BRACKET                                    # leftOuterJoin
    |    expr RIGHT_OUTER_JOIN expr LEFT_SQUARE_BRACKET condlist RIGHT_SQUARE_BRACKET                                   # rightOuterJoin
    |    expr FULL_OUTER_JOIN expr LEFT_SQUARE_BRACKET condlist RIGHT_SQUARE_BRACKET                                    # fullOuterJoin
    |    expr DIVISION expr                                                                                             # division
;

attrlist:   attribute                                           # attributeFromAttrlist
    |       attribute COMMA attrlist                            # attributeList
;

condlist:   condlist BOOLEAN_AND condlist                       # andCondlist
    |    condlist BOOLEAN_OR condlist                           # orCondlist
    |    BOOLEAN_NOT condlist                                   # notCondlist
    |    LEFT_BRACKET condlist RIGHT_BRACKET                    # bracketsCondlist
    |    compared comparator compared                           # comparedCondlist
;

comparator:     EQUAL                                           # equal
    |     NOT_EQUAL                                             # notEqual
    |     GREATER_THAN                                          # greaterThan
    |     GREATER_EQUAL                                         # greaterEqual
    |     LESS_THAN                                             # lessThan
    |     LESS_EQUAL                                            # lessEqual
;

compared:   attribute                                           # attributeFromCompared
    |       STRING                                              # stringFromCompared
    |       NUMBER                                              # numberFromCompared
    |       NULL_VAL                                            # nullFromCompared
;

attribute:   IDENTIFIER                                                # attributeIdentifier
    |    SUM     LEFT_BRACKET IDENTIFIER RIGHT_BRACKET                 # aggrSum
    |    COUNT   LEFT_BRACKET (IDENTIFIER | ASTERISK) RIGHT_BRACKET    # aggrCount
    |    MIN     LEFT_BRACKET IDENTIFIER RIGHT_BRACKET                 # aggrMin
    |    MAX     LEFT_BRACKET IDENTIFIER RIGHT_BRACKET                 # aggrMax
    |    AVERAGE LEFT_BRACKET IDENTIFIER RIGHT_BRACKET                 # aggrAvg
;

relation:   IDENTIFIER                                          # relationIdentifier
;

// TABLE BINARY OPERATORS
PROJECTION:         'PROJECT'           | 'project';
SELECTION:          'SELECT'            | 'select';
RENAME:             'RENAME'            | 'rename';
UNION:              'UNION'             | 'union'               | 'U';
DIFFERENCE:         'MINUS'             | 'minus'               | '-';
CARTESIAN_PRODUCT:  'CROSS JOIN'        | 'cross join'          | 'X'    | 'x';
INTERSECTION:       'INTERSECT'         | 'intersect'           | '∩';
NATURAL_JOIN:       'NATURAL JOIN'      | 'natural join'        | ASTERISK;
JOIN:               'JOIN'              | 'join'                | 'Y';
GROUP_BY:           'GROUP BY'          | 'group by';
HAVING:             'HAVING'            | 'having';
LEFT_OUTER_JOIN:    'LEFT OUTER JOIN'   | 'left outer join';
RIGHT_OUTER_JOIN:   'RIGHT OUTER JOIN'  | 'right outer join';
FULL_OUTER_JOIN:    'FULL OUTER JOIN'   | 'full outer join';
DIVISION:           'DIVISION'          | 'division'            | '/';

// AGGREGATE FUNCTIONS
SUM:        'SUM'    | 'sum';
COUNT:      'COUNT'  | 'count';
MIN:        'MIN'    | 'min';
MAX:        'MAX'    | 'max';
AVERAGE:    'AVG'    | 'avg';

// COMPARISON OPERATORS
EQUAL:          '=';
NOT_EQUAL:      '!=' | '<>';
GREATER_THAN:   '>';
GREATER_EQUAL:  '>=';
LESS_THAN:      '<';
LESS_EQUAL:     '<=';

// BOOLEAN OPERATORS
BOOLEAN_AND:    'AND' | 'and';
BOOLEAN_OR:     'OR'  | 'or';
BOOLEAN_NOT:    'NOT' | 'not';

STRING:          '"' (.)*? '"' | '\'' (.)*? '\'';
// IDENTIFIER OPTIONALLY LIKE 'TABLE.ATTR'
IDENTIFIER:      [a-zA-Z]+([0-9] | [a-zA-Z] | '_')* ('.' ([a-zA-Z]+([0-9] | [a-zA-Z] | '_')*)+ )?;
NUMBER:          [0-9]+;
WHITESPACES:     [ \t\r\n]+ -> skip;
NULL_VAL:        'NULL' | 'null';

SEMICOLON:              ';';
COMMA:                  ',';
LEFT_BRACKET:           '(';
RIGHT_BRACKET:          ')';
LEFT_SQUARE_BRACKET:    '[';
RIGHT_SQUARE_BRACKET:   ']'; 
ASTERISK:               '*';

// COMMENTS
MULTILINE_COMMENT:  '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]* -> channel(HIDDEN);