# Rub on Rails Cheatsheet

## Basics
```sh
$ rails new <app_name>				// initialie rails app
$ bundle install 					// bundler install GEMs
$ rails server 						// runs rails application
$ rails s -p 8080					// start server
$ rails generate model <model_name>	// model names are capitalized and singular
$ rails generate controller <ctrl_name> // controller names are capitalized and plural
$ rake routes						// view all routes
$ rake db:migrate					// migrate database
$ rake db:seed						// seed database
$ rails console
```
## Database
### Query
Note: Database queries can be chained together
```rb
TableName.find(<id>) # also works for multiple id queries
TableName.all
TableName.first
TableName.last
TableName.count	# count of entires in table
TableName.order(:attr) # returns all entries ordered by attribute :attr
TableName.limit(10)	# returns first 10
TableName.where(<attribute>: <value>)	# returns all entries with <attribute> of <value>
TableName.destroy_all	# clears all entries
```
### Create
```rb
t = TableName.create
# assign t values
t.save # save an entry based on its model validation
```
OR
```rb
t = TableName.create
t.update( # in this case don't need to save, update takes care of that
  # <attrname>: <new value>
  # ...
)
```
### Read
```rb
TableName.find(<id>) # also works for multiple id queries
```
### Update
```rb
t = TableName.find(<id>)
# update t values
t.save
# .save method returns true if successfully saved, false otherwise
```
### Delete
```rb
t = TableName.find(<id>)
t.destroy
```
### Model
```rb
class <capitalized singular model name> < ActiveRecord::Base
# model validations 
  validates_presence_of :attribute            # ensures that entry will always have value defined in :attribute
  validates_numericality_of :attribute        # ensure ensures that entry will always have numeric value defined in :attribute
  validates_uniqueness_of :attribute          # ensure ensures that entry will always have unique value defined in :attribute
  validates_confirmation_of :attribute
  validates_acceptance_of :attribute          # for e.g. checkboxes that have to be indicated true
  validates_length_of :password, minimum: 3   # ensures passsword field in entry have minimum length of 3
  validates_format_of :email, with: /regex/i  # ensures format of email complies with regex
  validates_inclusion_of :age, in: 21..99     # ensures age is within range (21..99)
  validates_exclusion_of :age, in: 0..21      # ensures age is not within range (21..99)
  # shorthands
    validates :attribute, presence: true
    validates :attribute, length: {minimum:3}
    # combining the above two:
      validates 	:attribute, 
            presence: true,
            length: {minimum:3}

# using relationships
  belongs_to :<singular>
  has_many :<plural>
  ash = Zombie.find(3)
  t = Tweet.create(status: "some tweet", zombie: ash)
  t.zombie # returns the Zombie(lowercase) object that t belongs to
```

## View
```erb
# link
<%= link_to '<link text>',<model name>_path(<entry obj>) %>
<%= link_to '<link text>', <entry obj>) %> # shorthand
<%= link_to '<link text>', <entry obj>, confirm: "Are you sure?") %> # confirm text
<%= link_to '<link text>', edit_<model name>_path(<entry obj>)) %> # Edit
<%= link_to '<link text>', <entry obj>, method: :delete %> # Destroy
# URL generator methods. Note <model name> is in lowercase
  <model name>s_path					# redirects to /<model name>s
  new_<model name>_path 			# redirects to '<model name>s/new'
  <model name>_path(<entry obj>)	# redirects to <model name>s/<entry obj>.id
  edit_<model name>_path(<entry obj>)	# redirects to <model name>s/<entry obj>.id/edit
  <model name>, method: :delete 	# redirects to <model name>s/<entry obj>.id
```

## Controller
```rb
class PluralizedModelNameController < ApplicationController
```

## PostgreSQL
```sh
sudo -u postgres psql postgres
```
