<?php
$arr = array(
    "foo" => "bar",
    "bar" => "foo",
);

$arr2 = [
    "foo" => "bar",
    "bar" => "foo",
];

$array = array(
    1 => "a",
    "1" => "b",
    1.5 => "c",
    true => "d",
);
// var_dump($array);

#Multi Array
$array = array(
    "foo" => "bar",
    42 => 24,
    "multi" => array(
        "dimensional" => array(
            "array" => "foo",
        ),
    ),
);

// var_dump($array["foo"]);
// var_dump($array[42]);
// var_dump($array["multi"]["dimensional"]["array"]);

$arr3 = array('a', 'b', 'c');
#print_r($arr3);

foreach ($arr3 as $i => $value) {
    #print_r($i);
    #print_r($value);
}

$arr4 = array(1 => 'one', 2 => 'two', 3 => 'three');

foreach ($arr4 as $i => $value) {
    echo "{$i} ";
    echo $value;
    echo "\n";
}

$b = array_values($arr4);
// print_r($b);

$arr5 = array(1, 2);
$count = count($arr5);

#
$firstquarter = array(1 => 'January', 'February', 'March');
print_r($firstquarter);

#map
$map = array('version' => 4,
    'OS' => 'Linux',
    'lang' => 'english',
    'short_tags' => true,
);

#2차원
$fruits = array("fruits" => array("a" => "orange",
    "b" => "banana",
    "c" => "apple",
),
    "numbers" => array(1,
        2,
        3,
        4,
        5,
        6,
    ),
    "holes" => array("first",
        5 => "second",
        "third",
    ),
);

// Some examples to address values in the array above
echo $fruits["holes"][5]; // prints "second"
echo $fruits["fruits"]["a"]; // prints "orange"
unset($fruits["holes"][0]); // remove "first"