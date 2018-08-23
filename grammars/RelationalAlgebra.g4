// GRAMMAR'S NAME
grammar RelationalAlgebra;

// PRODUCTION RULES
start:     (view ';')*  expr (';')* EOF
;

view:    IDENTIFIER '=' expr                                    # viewAssignment
;

expr:    relation                                               # relationFromExpr
    |    '(' expr ')'                                           # bracketsExpr
    |    PROJECTION '(' attrlist ')' '(' expr ')'      
           (GROUP_BY '(' attrlist ')' (HAVING condlistaggr)?)?  # projection
    |    SELECTION  '(' condlist ')' '(' expr ')'               # selection
    |    RENAME '(' attrlist ')' '(' expr ')'                   # rename
    |    expr UNION expr                                        # union
    |    expr CARTESIAN_PRODUCT expr                            # cartesianProduct
    |    expr DIFFERENCE expr                                   # difference
    |    expr NATURAL_JOIN expr                                 # naturalJoin
    |    expr INTERSECTION expr                                 # intersection
    |    expr JOIN expr '(' condlist ')'                        # join
    |    expr LEFT_OUTER_JOIN expr '(' condlist ')'             # leftOuterJoin
    |    expr RIGHT_OUTER_JOIN expr '(' condlist ')'            # rightOuterJoin
    |    expr FULL_OUTER_JOIN expr '(' condlist ')'             # fullOuterJoin
    |    expr DIVISION expr                                     # division
;

aggrlist:    aggrfunction                                       # aggrFromAggrList
    |    aggrfunction ',' aggrlist                              # aggregateList
;

attrlist:   attribute                                           # attributeFromAttrlist
    |       attribute ',' attrlist                              # attributeList
;

condlist:   condlist BOOLEAN_AND condlist                       # andCondlist
    |    condlist BOOLEAN_OR condlist                           # orCondlist
    |    BOOLEAN_NOT condlist                                   # notCondlist
    |    '(' condlist ')'                                       # bracketsCondlist
    |    compared comparator compared                           # comparedCondlist
;

condlistaggr:   condlistaggr BOOLEAN_OR condlistaggr                                # orCondlistAggr
    |           condlistaggr BOOLEAN_AND condlistaggr                               # andCondlistAggr
    |           '(' condlistaggr ')'                                                # bracketsCondlistaggr
    |           (compared | aggrfunction) comparator (compared | aggrfunction)      # comparedCondlistaggr
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
;

aggrfunction:    SUM '(' attribute ')'                          # aggrSum
    |    COUNT   '(' (attribute | '*') ')'                      # aggrCount
    |    MIN     '(' attribute ')'                              # aggrMin
    |    MAX     '(' attribute ')'                              # aggrMax
    |    AVERAGE '(' attribute ')'                              # aggrAvg
;

relation:   IDENTIFIER                                          # relationIdentifier
;        
            
attribute:  IDENTIFIER                                          # attributeIdentifier
;

// TABLE BINARY OPERATORS
PROJECTION:         'PROJECT'           | 'project';
SELECTION:          'SELECT'            | 'select';
RENAME:             'RENAME'            | 'rename';
UNION:              'UNION'             | 'union'               | 'U';
DIFFERENCE:         'MINUS'             | 'minus'               | '-';
CARTESIAN_PRODUCT:  'CROSS JOIN'        | 'cross join'          | 'X'    | 'x';
INTERSECTION:       'INTERSECT'         | 'intersect'           | '∩';
NATURAL_JOIN:       'NATURAL JOIN'      | 'natural join'        | '*';
JOIN:               'JOIN'              | 'join'                | 'Y';
GROUP_BY:           'GROUP BY'          | 'group by';
HAVING :            'HAVING'            | 'having';
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

// COMMENTS
MULTILINE_COMMENT:  '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]* -> channel(HIDDEN);
